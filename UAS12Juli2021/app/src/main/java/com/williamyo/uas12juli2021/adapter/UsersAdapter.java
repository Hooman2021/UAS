package com.williamyo.uas12juli2021.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.williamyo.uas12juli2021.EditActivity;
import com.williamyo.uas12juli2021.R;
import com.williamyo.uas12juli2021.model.User;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {
    List<User> mUserList;

    public UsersAdapter(List<User> userList){
        mUserList = userList;
    }

    @NonNull
    @Override
    public UsersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_list,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(mView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.MyViewHolder holder, final int position) {
        holder.mTextViewId.setText("Id = "+mUserList.get(position).getId());
        holder.mTextViewEmail.setText("Email = "+mUserList.get(position).getEmail());
        holder.mTextViewFname.setText("First Name = "+mUserList.get(position).getFname());
        holder.mTextViewLname.setText("Last Name = "+mUserList.get(position).getLname());
        holder.mTextViewAvatar.setText("Avatar = "+mUserList.get(position).getAvatar());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(v.getContext(), EditActivity.class);
                mIntent.putExtra("Id",mUserList.get(position).getId());
                mIntent.putExtra("Email",mUserList.get(position).getEmail());
                mIntent.putExtra("Fname",mUserList.get(position).getFname());
                mIntent.putExtra("Lname",mUserList.get(position).getLname());
                mIntent.putExtra("Avatar",mUserList.get(position).getAvatar());
                v.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewEmail, mTextViewFname, mTextViewLname, mTextViewAvatar;
        public MyViewHolder(View itemView){
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            mTextViewFname = (TextView) itemView.findViewById(R.id.tvFname);
            mTextViewLname = (TextView) itemView.findViewById(R.id.tvLname);
            mTextViewAvatar = (TextView) itemView.findViewById(R.id.tvAvatar);
        }
    }
}
