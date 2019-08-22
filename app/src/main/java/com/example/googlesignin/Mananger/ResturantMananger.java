package com.example.googlesignin.Mananger;

import android.content.Context;

import com.example.googlesignin.Event.ResturantDataEvent;
import com.example.googlesignin.Interface.ApiUrl;
import com.example.googlesignin.Model.RestaurantDataModel;
import com.example.googlesignin.Request.RestaurantDataRequest;

import java.util.List;

import de.greenrobot.event.EventBus;

public class ResturantMananger implements RestaurantDataRequest.RestaurantDataDelegate {

    public static ResturantMananger resturantMananger;
    public RestaurantDataRequest restaurantDataRequest;
    Context context;


    public ResturantMananger(Context context) {
        this.context = context;
    }

    public static ResturantMananger getInstance() {
        return resturantMananger;
    }

    public static ResturantMananger getInstance(Context context) {
        if (resturantMananger == null) {
            resturantMananger = new ResturantMananger( context );
        }
        return resturantMananger;
    }

    public void restaurntData() {
        restaurantDataRequest = new RestaurantDataRequest(this);
        restaurantDataRequest.start( ApiUrl.getBaseUrl());
    }


    @Override
    public void restaurntDataSuccess(List<RestaurantDataModel> restaurantDataResponse) {
        EventBus.getDefault().post( new ResturantDataEvent(restaurantDataResponse));
    }
}
