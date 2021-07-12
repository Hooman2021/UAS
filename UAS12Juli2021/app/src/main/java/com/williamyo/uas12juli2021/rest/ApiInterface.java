package com.williamyo.uas12juli2021.rest;

import com.williamyo.uas12juli2021.model.GetUser;
import com.williamyo.uas12juli2021.model.PostPutDelUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("users")
    Call<GetUser> getUser();
    @FormUrlEncoded
    @POST("users")
    Call<PostPutDelUser> postUser(@Field("email") String email, @Field("first_name") String fname, @Field("last_name") String lname, @Field("avatar") String avatar);

    @FormUrlEncoded
    @PUT("users")
    Call<PostPutDelUser> putUser(@Field("email") String email, @Field("first_name") String fname, @Field("last_name") String lname, @Field("avatar") String avatar);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "users", hasBody = true)
    Call<PostPutDelUser> deleteUser(@Field("id") String id);

}
