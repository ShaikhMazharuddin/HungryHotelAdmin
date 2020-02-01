package com.hungry.hotel.hungryhoteladmin.orders.repository;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hungry.hotel.hungryhoteladmin.deliveryboy.model.DeliveryBoy;
import com.hungry.hotel.hungryhoteladmin.login.api.LoginApi;
import com.hungry.hotel.hungryhoteladmin.login.model.User;
import com.hungry.hotel.hungryhoteladmin.orders.api.OrderApi;
import com.hungry.hotel.hungryhoteladmin.orders.model.Customer;
import com.hungry.hotel.hungryhoteladmin.orders.model.Hotel;
import com.hungry.hotel.hungryhoteladmin.orders.model.Order;
import com.hungry.hotel.hungryhoteladmin.orders.model.OrderResponse;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.Dish;
import com.hungry.hotel.hungryhoteladmin.retrofit.HungryAdminApiFactory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderRepository {

    public LiveData<List<Order>> getOrders(String orderStatus, String hotelMasterId, String deliveryBoyMasterId) {
//        List<Order> orderList = new ArrayList<>();
        MutableLiveData<List<Order>> liveDataOrderList = new MutableLiveData<>();
        OrderApi orderApi = HungryAdminApiFactory.getInstance().create(OrderApi.class);

        Call<OrderResponse> orderResponseCall = orderApi.getOrders(HungryAdminApiFactory.API_KEY, orderStatus,
                hotelMasterId, deliveryBoyMasterId, null);
        orderResponseCall.enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                Log.d("order_header", response.raw().toString());
                Log.d("order_response", response.toString());
                Log.d("order_result", response.body().getOrderList().toString());
                liveDataOrderList.setValue(response.body().getOrderList());
            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable t) {
                Log.d("order_response", t.getMessage());
            }
        });

        return liveDataOrderList;
/*
//        Customer
        Customer customer = new Customer();
        customer.setCustomerName("Prasad Chawan");
        customer.setCustomerMobileNumber("8888888888");
        customer.setCustomerAddress("Ghorpade peth swar gate Mominpura Pune 411042");
//DeliveryBoy
        DeliveryBoy deliveryBoy = new DeliveryBoy();
        deliveryBoy.setDeliveryBoyName("Delivery Boy");
        deliveryBoy.setDeliveryBoyMobile("9999999999");
//        Hotel
        Hotel hotel = new Hotel();
        hotel.setHotelName("Hotel Royal");
//        Dishes
        Dish dish = new Dish();
        dish.setDishName("Sev Bhaji");
        dish.setDishPrice(80.00);
        List<Dish> dishList = new ArrayList<>();
        dishList.add(dish);
        dishList.add(dish);
//        Order
        Order order = new Order();
        order.setHotel(hotel);
        order.setNewOrder(true);
        order.setOrderImage("");
        order.setOrderDate("26 Nov 2019 11:55AM");
        order.setCustomer(customer);
        order.setCustomer(customer);
        order.setDeliveryBoy(deliveryBoy);
        order.setDishCount(3);
        order.setOrderStatus("NEW");
        order.setTotalPrice(300.00);
        order.setCommissionPercent(20);
        order.setCommission(15.00);
        order.setReceivableAmount(200.00);
        order.setOrderRating(3.5f);
        order.setDeliveryAddress("Ghorpade peth swar gate Mominpura Pune 411042");
        order.setDishList(dishList);
        orderList.add(order);
        orderList.add(order);
        orderList.add(order);
        liveDataOrderList.setValue(orderList);
        return liveDataOrderList;*/
    }
}
