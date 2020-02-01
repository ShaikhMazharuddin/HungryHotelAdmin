package com.hungry.hotel.hungryhoteladmin.orders.api;

import com.hungry.hotel.hungryhoteladmin.orders.model.OrderResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OrderApi {

    @GET("/index.php/api/Order/orders")
    Call<OrderResponse> getOrders(@Query("api_key") String apiKey, @Query("OR_STATUS") String orderStatus, @Query("HOT_MS_ID") String hotelMasterId,
                                  @Query("DL_BO_MA_ID") String deliveryBoyMasterId, @Query("CM_MS_ID") String clientMasterId);

}
