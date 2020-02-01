package com.hungry.hotel.hungryhoteladmin.orders.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.hungry.hotel.hungryhoteladmin.orders.model.Order;
import com.hungry.hotel.hungryhoteladmin.orders.repository.OrderRepository;

import java.util.List;

public class OrdersViewModel extends AndroidViewModel {
    public MutableLiveData<List<Order>> listLiveData = new MutableLiveData<>();

    public OrdersViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadOrderListObserver(String orderType, String hotelMasterId, String deliveryBoyMasterId) {
        OrderRepository orderRepository = new OrderRepository();
        orderRepository.getOrders(orderType, hotelMasterId, deliveryBoyMasterId).observeForever(new Observer<List<Order>>() {
            @Override
            public void onChanged(List<Order> orders) {
                listLiveData.setValue(orders);
            }
        });
    }
}
