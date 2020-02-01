package com.hungry.hotel.hungryhoteladmin.orders.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class OrderItem implements Parcelable {

    @SerializedName("OR_ITM_ID")
    String orderItemId;
    @SerializedName("MN_MA_ID")
    String menuMasterId;
    @SerializedName("NET_PRICE")
    String itemNetPrice;
    @SerializedName("DISCOUNT")
    String itemDiscount;
    @SerializedName("TOTALPRICE")
    String itemTotalPrice;
    @SerializedName("QUINTITY")
    String itemQuantity;
    @SerializedName("OR_MA_ID")
    String itemOrderMasterId;
    @SerializedName("CREATED_AT")
    String createdAt;
    @SerializedName("UPDADATED_AT")
    String updatedAt;
    @SerializedName("NAME")
    String itemName;
    @SerializedName("TYPE")
    String itemType;

    public OrderItem() {
    }

    protected OrderItem(Parcel in) {
        orderItemId = in.readString();
        menuMasterId = in.readString();
        itemNetPrice = in.readString();
        itemDiscount = in.readString();
        itemTotalPrice = in.readString();
        itemQuantity = in.readString();
        itemOrderMasterId = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        itemName = in.readString();
        itemType = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(orderItemId);
        dest.writeString(menuMasterId);
        dest.writeString(itemNetPrice);
        dest.writeString(itemDiscount);
        dest.writeString(itemTotalPrice);
        dest.writeString(itemQuantity);
        dest.writeString(itemOrderMasterId);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(itemName);
        dest.writeString(itemType);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<OrderItem> CREATOR = new Creator<OrderItem>() {
        @Override
        public OrderItem createFromParcel(Parcel in) {
            return new OrderItem(in);
        }

        @Override
        public OrderItem[] newArray(int size) {
            return new OrderItem[size];
        }
    };

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getMenuMasterId() {
        return menuMasterId;
    }

    public void setMenuMasterId(String menuMasterId) {
        this.menuMasterId = menuMasterId;
    }

    public String getItemNetPrice() {
        return itemNetPrice;
    }

    public void setItemNetPrice(String itemNetPrice) {
        this.itemNetPrice = itemNetPrice;
    }

    public String getItemDiscount() {
        return itemDiscount;
    }

    public void setItemDiscount(String itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    public String getItemTotalPrice() {
        return itemTotalPrice;
    }

    public void setItemTotalPrice(String itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemOrderMasterId() {
        return itemOrderMasterId;
    }

    public void setItemOrderMasterId(String itemOrderMasterId) {
        this.itemOrderMasterId = itemOrderMasterId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}
