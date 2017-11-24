package org.androidtown.signalapplication.Server.Interface;

import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface AccountAPI {
    @POST("/account/login")

    @GET("/account/logout")

    @POST("/account/")

    @DELETE("/account/")

    @PUT("/account/")

    @GET("/account/")

    /*
    @POST("/api/v2/guest/requirements")
    Call<BasicResponse> postRequiremnet(@Body RequirementRequest data);

    @PUT("api/v2/phones/{phone_id}")
    Call<BasicResponse> putClearTime(@Path("phone_id") int phone_id, @Body ClearTimeRequest request);

    @GET("api/v2/services")
    Call<ArticleListClassResponse> getServiceArticleListClass();

    @POST("/api/person")
    Call<PersonResponse> postPerson(@Body Person p);
    */

}
