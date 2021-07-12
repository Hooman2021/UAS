package com.williamyo.uas12juli2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.williamyo.uas12juli2021.model.PostPutDelUser;
import com.williamyo.uas12juli2021.rest.ApiClient;
import com.williamyo.uas12juli2021.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity {
    EditText editID,editEmail,editFname,editLname,editAvatar;
    Button btnUpdate,btnDelete,btnBack;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        editID = (EditText) findViewById(R.id.editID);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editFname = (EditText) findViewById(R.id.editFname);
        editLname = (EditText) findViewById(R.id.editLname);
        editAvatar = (EditText) findViewById(R.id.editAvatar);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelUser> putUserCall = mApiInterface.putUser(editEmail.getText().toString(),editFname.getText().toString(),editLname.getText().toString(),editAvatar.getText().toString());
                putUserCall.enqueue(new Callback<PostPutDelUser>() {
                    @Override
                    public void onResponse(Call<PostPutDelUser> call, Response<PostPutDelUser> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelUser> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.ma.refresh();
                finish();
            }
        });
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelUser> DelUserCall = mApiInterface.deleteUser(editID.getText().toString());
                DelUserCall.enqueue(new Callback<PostPutDelUser>() {
                    @Override
                    public void onResponse(Call<PostPutDelUser> call, Response<PostPutDelUser> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelUser> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}