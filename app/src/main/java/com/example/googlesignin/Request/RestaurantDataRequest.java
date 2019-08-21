package com.example.googlesignin.Request;

import com.example.googlesignin.Interface.RestaurntDataInterface;
import com.example.googlesignin.Model.RestaurantDataModel;
import com.example.googlesignin.network.RequestBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantDataRequest implements Callback<List<RestaurantDataModel>> {


    RestaurantDataDelegate mDelegate;
    RestaurntDataInterface restaurntDataInterface;
  //  String restrauntData = ResturantMananger.restaurantData;


    public RestaurantDataRequest(RestaurantDataDelegate delegate) {
        this.mDelegate = delegate;
    }

    @Override
    public void onResponse(Call<List<RestaurantDataModel>> call, Response<List<RestaurantDataModel>> response) {
        List<RestaurantDataModel> restaurantDataModels = response.body();

        if (response.isSuccessful()) {

        }
    }

    @Override
    public void onFailure(Call<List<RestaurantDataModel>> call, Throwable t) {

    }


    public void start(String baseUrl) {
        restaurntDataInterface = RequestBuilder.createService( RestaurntDataInterface.class, baseUrl );

        Call call = restaurntDataInterface.getRestaurantData(  );


        call.enqueue( this );
    }

    public interface RestaurantDataDelegate {
        void searchSuccess(List<RestaurantDataModel> saleItemResponse);
    }
}
