package com.hungry.hotel.hungryhoteladmin.deliveryboy.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.hungry.hotel.hungryhoteladmin.dashboard.model.OrderDashboard;
import com.hungry.hotel.hungryhoteladmin.dashboard.repository.DashboardRepository;
import com.hungry.hotel.hungryhoteladmin.deliveryboy.model.DeliveryBoy;
import com.hungry.hotel.hungryhoteladmin.deliveryboy.repository.DeliveryBoyRepository;

import java.util.List;

public class DeliveryBoyViewModel extends AndroidViewModel {
    public DeliveryBoyViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<DeliveryBoy> getDeliveryBoyDetails() {
        DeliveryBoyRepository deliveryBoyRepository = new DeliveryBoyRepository();
        return deliveryBoyRepository.getDeliveryBoyDetails();

    }
}
