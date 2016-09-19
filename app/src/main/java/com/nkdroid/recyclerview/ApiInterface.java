package com.nkdroid.recyclerview;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
    @GET("/api/Getbank/bank")
    Call<Bank> getBankDetails();

}
