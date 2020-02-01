package com.hungry.hotel.hungryhoteladmin.orders.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.orders.model.Order;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrderViewHolder> {
    List<Order> orderList;
    OrderOpenListener orderOpenListener;

    public OrdersAdapter(OrderOpenListener orderOpenListener) {
        this.orderOpenListener = orderOpenListener;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View orderView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_order_item, parent, false);
        return new OrderViewHolder(orderView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        final Order order = orderList.get(position);
        if (order != null) {
            Glide.with(holder.civOrderImage.getContext())
                    .load(order.getOrderImageUrl())
                    .centerCrop()
                    .placeholder(R.drawable.ic_user)
                    .into(holder.civOrderImage);
            holder.tvCustomerName.setText("customer-Vishal");
//            holder.tvCustomerName.setText(order.getCustomer().getCustomerName());
            holder.tvOrderDate.setText(order.getOrderCreatedAt());
            holder.tvDeliveryBoy.setText("deliveryboy-Vishal");
//            holder.tvDeliveryBoy.setText(order.getDeliveryBoy().getDeliveryBoyName());
            holder.tvDishCount.setText(order.getOrderDiscount() + " Items");
            if (order.getOrderStaus().equalsIgnoreCase("OPEN")) {
                holder.tvOrderStatus.setText("New");
            }
            holder.rbOrderRating.setRating(3);
            holder.tvTotalPrice.setText("Rs. " + order.getOrderTotal());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    orderOpenListener.openOrder(order);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return orderList != null ? orderList.size() : 0;
    }

    public interface OrderOpenListener {
        void openOrder(Order order);
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        LinearLayout llOrder;
        CircleImageView civOrderImage;
        TextView tvCustomerName, tvOrderDate, tvDeliveryBoy, tvDishCount, tvOrderStatus, tvTotalPrice;
        RatingBar rbOrderRating;


        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            civOrderImage = itemView.findViewById(R.id.civOrderImage);
            tvCustomerName = itemView.findViewById(R.id.tvCustomerName);
            tvOrderDate = itemView.findViewById(R.id.tvOrderDate);
            tvDeliveryBoy = itemView.findViewById(R.id.tvDeliveryBoy);
            tvDishCount = itemView.findViewById(R.id.tvDishCount);
            tvOrderStatus = itemView.findViewById(R.id.tvOrderStatus);
            tvTotalPrice = itemView.findViewById(R.id.tvTotalPrice);
            rbOrderRating = itemView.findViewById(R.id.rbOrderRating);
        }
    }
}
