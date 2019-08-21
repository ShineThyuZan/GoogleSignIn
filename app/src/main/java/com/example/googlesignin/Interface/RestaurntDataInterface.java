package com.example.googlesignin.Interface;

import com.example.googlesignin.Model.RestaurantDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestaurntDataInterface {

    @GET("https://api.myjson.com/bins/8d195.json")
    Call<List<RestaurantDataModel>> getRestaurantData();
}
