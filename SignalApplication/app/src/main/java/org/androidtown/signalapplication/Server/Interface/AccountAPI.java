package org.androidtown.signalapplication.Server.Interface;

import org.androidtown.signalapplication.Server.Models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AccountAPI {
    @POST("/account/login")
    Call<User> userLogin(@Body User user);

    @GET("/account/logout")
    Call<User> userLogout();

    @POST("/account/")
    Call<User> userRegister(@Body User user);

    @DELETE("/account/")
    Call<User> userDelete();

    @PUT("/account/")
    Call<User> userUpdate();

    @GET("/account/")
    Call<User> getUserInfo();

}
