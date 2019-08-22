package com.example.googlesignin.Event;

import com.example.googlesignin.Model.RestaurantDataModel;

import java.util.List;

public class ResturantDataEvent {

    List<RestaurantDataModel> restaurantDataModelList;

    public ResturantDataEvent(List<RestaurantDataModel> restaurantDataModelList) {
        this.restaurantDataModelList = restaurantDataModelList;
    }

    public List<RestaurantDataModel> getRestaurantDataModelList() {
        return restaurantDataModelList;
    }

    public void setRestaurantDataModelList(List<RestaurantDataModel> restaurantDataModelList) {
        this.restaurantDataModelList = restaurantDataModelList;
    }
}
