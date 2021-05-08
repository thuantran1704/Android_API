package com.example.wibugrams.Retrofit;


import com.example.wibugrams.Model.JSONResponsePost;
import com.example.wibugrams.Model.JSONResponseUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
//    @GET("user")
//    Call<String> getUserLogin(@Query("username") String username, @Query("password") String password);
//
    @POST("login")
    Call<JSONResponseUser> getUserLogin(@Header("APIKEY") String key, @Query("username") String username, @Query("password") String password);
//
//
    @GET("post")
    Call<JSONResponsePost> getPost(@Header("APIKEY") String key);
//
//
//    @GET("foods")
//    Call<JSONResponseFoods> getFoodDetail(@Query("_id") String id, @Header("api_key") String key);
//
//
//    @POST("orders")
//    @Headers("Content-type: application/json")
//    Call<ResponseModel> insertOrder(@Body Order orderJ, @Header("api_key") String key);
//
//    @POST("customers")
//    @FormUrlEncoded
//    Call<ResponseModel> insertCustomer(@Field("_id")String _id,
//                                       @Field("firstName")String firstName,
//                                       @Field("lastName")String lastname,
//                                       @Field("address")String address,
//                                       @Field("password")String pass,
//                                       @Field("isAdmin")boolean isAdmin,
//                                       @Header("api_key") String key);
//
//
//
//    @GET("orders")
//    Call<JSONResponseCustomerOrder> getListOrder(@Header("api_key") String key, @Query("customerid") String customerid);
//
//
//    @DELETE("orders/{id}")
//    Call<ResponseModel> deleteOrder(@Header("api_key") String key, @Path("id") String id);
//
//
//
//    @PUT("orders/{id}")
//    @Headers("Content-type: application/json")
//    Call<ResponseModel> updateOrder(@Header("api_key") String key, @Path("id") String id, @Body Order orderJ);
//
//
//    @GET("statistic")
//    Call<StaticalResponse> getStatistical(@Query("customerid") String id);
}
