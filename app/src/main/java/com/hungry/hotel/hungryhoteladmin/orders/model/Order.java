package com.hungry.hotel.hungryhoteladmin.orders.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.hungry.hotel.hungryhoteladmin.deliveryboy.model.DeliveryBoy;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.Dish;

import java.util.List;

public class Order implements Parcelable {
    /*private int orderId;
    private boolean isNewOrder;
    private String orderImage;
    private String orderDate;
    private Customer customer;
    private List<Dish> dishList;
    private DeliveryBoy deliveryBoy;
    private int dishCount;
    private String orderStatus;
    private double totalPrice;
    private double commissionPercent;
    private double commission;
    private double receivableAmount;
    private float orderRating;
    private String deliveryAddress;
    private String orderFeedback;
    private Hotel hotel;*/

    @SerializedName("OR_ID")
    String orderId;
    @SerializedName("OR_NO")
    String ordernumber;
    @SerializedName("CM_MS_ID")
    String clientmasterId;
    @SerializedName("HOT_MS_ID")
    String hotelMasterId;
    @SerializedName("OR_STATUS")
    String orderStaus;
    @SerializedName("EX_DILIVERY_TIME")
    String expectedDeliveryTime;
    @SerializedName("DL_BOY_STATUS")
    String deliveryBoyStatus;
    @SerializedName("DL_BO_MA_ID")
    String deliveryBoyMasterId;
    @SerializedName("DL_DATE_TIME")
    String deliveryDateTime;
    @SerializedName("RATING")
    String orderRating;
    @SerializedName("FEEDBACK")
    String orderFeedback;
    @SerializedName("DL_AD_MA_ID")
    String delieryAddressMasterId;
    @SerializedName("PAY_METHOD")
    String paymentmethod;
    @SerializedName("PAYMENT_STATUS")
    String paymentStatus;
    @SerializedName("NET_TOTAL")
    String orderNetTotal;
    @SerializedName("TAX")
    String orderTax;
    @SerializedName("TOTAL")
    String orderTotal;
    @SerializedName("DISCOUNT")
    String orderDiscount;
    @SerializedName("COMM_PERCENT")
    String commissionPercent;
    @SerializedName("COMM_AMMOUNT")
    String commissionAmount;
    @SerializedName("CREATED_AT")
    String orderCreatedAt;
    @SerializedName("UPDATED_AT")
    String orderUpdatedAt;
    @SerializedName("DB_RATING")
    String deliveryBoyRating;
    @SerializedName("DISPATCH_CODE")
    String dispatchCode;
    @SerializedName("DB_FEEDBACK")
    String deliveryBoyFeedback;
    @SerializedName("FNAME")
    String firstName;
    @SerializedName("LNAME")
    String lastName;
    @SerializedName("NAME")
    String hotelName;
    @SerializedName("IMG_URL")
    String orderImageUrl;
    @SerializedName("items")
    List<OrderItem> orderItemList;


    public Order() {
    }


    protected Order(Parcel in) {
        orderId = in.readString();
        ordernumber = in.readString();
        clientmasterId = in.readString();
        hotelMasterId = in.readString();
        orderStaus = in.readString();
        expectedDeliveryTime = in.readString();
        deliveryBoyStatus = in.readString();
        deliveryBoyMasterId = in.readString();
        deliveryDateTime = in.readString();
        orderRating = in.readString();
        orderFeedback = in.readString();
        delieryAddressMasterId = in.readString();
        paymentmethod = in.readString();
        paymentStatus = in.readString();
        orderNetTotal = in.readString();
        orderTax = in.readString();
        orderTotal = in.readString();
        orderDiscount = in.readString();
        commissionPercent = in.readString();
        commissionAmount = in.readString();
        orderCreatedAt = in.readString();
        orderUpdatedAt = in.readString();
        deliveryBoyRating = in.readString();
        dispatchCode = in.readString();
        deliveryBoyFeedback = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        hotelName = in.readString();
        orderImageUrl = in.readString();
        orderItemList = in.createTypedArrayList(OrderItem.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(orderId);
        dest.writeString(ordernumber);
        dest.writeString(clientmasterId);
        dest.writeString(hotelMasterId);
        dest.writeString(orderStaus);
        dest.writeString(expectedDeliveryTime);
        dest.writeString(deliveryBoyStatus);
        dest.writeString(deliveryBoyMasterId);
        dest.writeString(deliveryDateTime);
        dest.writeString(orderRating);
        dest.writeString(orderFeedback);
        dest.writeString(delieryAddressMasterId);
        dest.writeString(paymentmethod);
        dest.writeString(paymentStatus);
        dest.writeString(orderNetTotal);
        dest.writeString(orderTax);
        dest.writeString(orderTotal);
        dest.writeString(orderDiscount);
        dest.writeString(commissionPercent);
        dest.writeString(commissionAmount);
        dest.writeString(orderCreatedAt);
        dest.writeString(orderUpdatedAt);
        dest.writeString(deliveryBoyRating);
        dest.writeString(dispatchCode);
        dest.writeString(deliveryBoyFeedback);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(hotelName);
        dest.writeString(orderImageUrl);
        dest.writeTypedList(orderItemList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getClientmasterId() {
        return clientmasterId;
    }

    public void setClientmasterId(String clientmasterId) {
        this.clientmasterId = clientmasterId;
    }

    public String getHotelMasterId() {
        return hotelMasterId;
    }

    public void setHotelMasterId(String hotelMasterId) {
        this.hotelMasterId = hotelMasterId;
    }

    public String getOrderStaus() {
        return orderStaus;
    }

    public void setOrderStaus(String orderStaus) {
        this.orderStaus = orderStaus;
    }

    public String getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }

    public void setExpectedDeliveryTime(String expectedDeliveryTime) {
        this.expectedDeliveryTime = expectedDeliveryTime;
    }

    public String getDeliveryBoyStatus() {
        return deliveryBoyStatus;
    }

    public void setDeliveryBoyStatus(String deliveryBoyStatus) {
        this.deliveryBoyStatus = deliveryBoyStatus;
    }

    public String getDeliveryBoyMasterId() {
        return deliveryBoyMasterId;
    }

    public void setDeliveryBoyMasterId(String deliveryBoyMasterId) {
        this.deliveryBoyMasterId = deliveryBoyMasterId;
    }

    public String getDeliveryDateTime() {
        return deliveryDateTime;
    }

    public void setDeliveryDateTime(String deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    public String getOrderRating() {
        return orderRating;
    }

    public void setOrderRating(String orderRating) {
        this.orderRating = orderRating;
    }

    public String getOrderFeedback() {
        return orderFeedback;
    }

    public void setOrderFeedback(String orderFeedback) {
        this.orderFeedback = orderFeedback;
    }

    public String getDelieryAddressMasterId() {
        return delieryAddressMasterId;
    }

    public void setDelieryAddressMasterId(String delieryAddressMasterId) {
        this.delieryAddressMasterId = delieryAddressMasterId;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderNetTotal() {
        return orderNetTotal;
    }

    public void setOrderNetTotal(String orderNetTotal) {
        this.orderNetTotal = orderNetTotal;
    }

    public String getOrderTax() {
        return orderTax;
    }

    public void setOrderTax(String orderTax) {
        this.orderTax = orderTax;
    }

    public String getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(String orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    public String getCommissionPercent() {
        return commissionPercent;
    }

    public void setCommissionPercent(String commissionPercent) {
        this.commissionPercent = commissionPercent;
    }

    public String getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(String commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public String getOrderCreatedAt() {
        return orderCreatedAt;
    }

    public void setOrderCreatedAt(String orderCreatedAt) {
        this.orderCreatedAt = orderCreatedAt;
    }

    public String getOrderUpdatedAt() {
        return orderUpdatedAt;
    }

    public void setOrderUpdatedAt(String orderUpdatedAt) {
        this.orderUpdatedAt = orderUpdatedAt;
    }

    public String getDeliveryBoyRating() {
        return deliveryBoyRating;
    }

    public void setDeliveryBoyRating(String deliveryBoyRating) {
        this.deliveryBoyRating = deliveryBoyRating;
    }

    public String getDispatchCode() {
        return dispatchCode;
    }

    public void setDispatchCode(String dispatchCode) {
        this.dispatchCode = dispatchCode;
    }

    public String getDeliveryBoyFeedback() {
        return deliveryBoyFeedback;
    }

    public void setDeliveryBoyFeedback(String deliveryBoyFeedback) {
        this.deliveryBoyFeedback = deliveryBoyFeedback;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getOrderImageUrl() {
        return orderImageUrl;
    }

    public void setOrderImageUrl(String orderImageUrl) {
        this.orderImageUrl = orderImageUrl;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
