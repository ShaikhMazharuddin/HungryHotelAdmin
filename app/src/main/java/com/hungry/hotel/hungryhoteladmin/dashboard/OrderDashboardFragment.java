package com.hungry.hotel.hungryhoteladmin.dashboard;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hungry.hotel.hungryhoteladmin.R;
import com.hungry.hotel.hungryhoteladmin.dashboard.adapter.DashboardOrderAdapter;
import com.hungry.hotel.hungryhoteladmin.dashboard.model.OrderDashboard;
import com.hungry.hotel.hungryhoteladmin.dashboard.viewmodel.DashboardViewModel;
import com.hungry.hotel.hungryhoteladmin.home.MainActivity2;
import com.hungry.hotel.hungryhoteladmin.login.model.User;
import com.hungry.hotel.hungryhoteladmin.orders.OrderFragment;
import com.hungry.hotel.hungryhoteladmin.orders.viewmodel.OrdersViewModel;
import com.hungry.hotel.hungryhoteladmin.utils.FragmentUtils;
import com.hungry.hotel.hungryhoteladmin.utils.OnFragmentInteractionListener;
import com.hungry.hotel.hungryhoteladmin.utils.SharedPreferenceHelper;

import java.util.ArrayList;
import java.util.List;

import android.content.res.Resources;
import android.widget.Toast;

public class OrderDashboardFragment extends Fragment {
    private OrderDashboardFragmentListener orderDashboardFragmentListener;
    private OnFragmentInteractionListener mListener;
    Toolbar toolbar;
    ActionBar actionBar;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;


    public OrderDashboardFragment() {
        // Required empty public constructor
    }

    public void setOrderDashboardFragmentListener(OrderDashboardFragmentListener orderDashboardFragmentListener) {
        this.orderDashboardFragmentListener = orderDashboardFragmentListener;
    }

    public static OrderDashboardFragment newInstance(String param1, String param2) {

        return null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setupToolbar();


       /* ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Order dashborad");
        toolbar.setTitleTextColor(getActivity().getResources().getColor(R.color.black));
        AutoCompleteTextView actvSearchMenu = toolbar.findViewById(R.id.actvSearchMenu);
        ImageButton ibFilter = toolbar.findViewById(R.id.ibFilter);
        ImageButton ibSearch = toolbar.findViewById(R.id.ibSearch);
        actvSearchMenu.setVisibility(View.GONE);
        ibSearch.setVisibility(View.GONE);
        ibFilter.setVisibility(View.GONE);*/


        final View dashboardView = inflater.inflate(R.layout.fragment_order_dashboard, container, false);
        SharedPreferences sharedPreferences = SharedPreferenceHelper.getSharedPreferenceInstance(getActivity(), "USER");
        String accountType = sharedPreferences.getString(User.ACCOUNT_TYPE, "NONE");
        Log.d("Dashboard", accountType);
       /* Toolbar tbMain = getActivity().findViewById(R.id.tbMain);
        tbMain.setVisibility(View.GONE);*/
        /*if (accountType.equalsIgnoreCase(User.HOTEL_ADMIN)) {
            NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
            Menu nav_Menu = navigationView.getMenu();
            nav_Menu.findItem(R.id.nav_deliveryBoy).setVisible(false);
        }*/

        TextView tvTodaysStatus = dashboardView.findViewById(R.id.tvTodaysStatus);
        Button btnOtherOrder = dashboardView.findViewById(R.id.btnOtherOrder);
        RecyclerView rvOrderDashboard = dashboardView.findViewById(R.id.rvOrderDashboard);
        DashboardViewModel dashboardViewModel = ViewModelProviders.of(getActivity()).get(DashboardViewModel.class);
        DashboardOrderAdapter dashboardOrderAdapter = new DashboardOrderAdapter(getActivity(), new DashboardOrderAdapter.OrderClickListener() {
            @Override
            public void orderOpen(OrderDashboard order) {
                Toast.makeText(dashboardView.getContext(), "Order clicked", Toast.LENGTH_LONG).show();
                OrderFragment orderFragment = OrderFragment.newInstance(order.getOrderName());
                loadFragment(orderFragment, "ORDER_FRAGMENT", true);
            }
        });

        dashboardViewModel.getOrdersList().observe(getActivity(), new Observer<List<OrderDashboard>>() {
            @Override
            public void onChanged(List<OrderDashboard> dashboardOrderList) {
                if (dashboardOrderList != null && dashboardOrderList.size() > 0) {
                    dashboardOrderAdapter.setOrderDashboardList(dashboardOrderList);
                }
            }
        });
        setDashboardProperty(dashboardView, rvOrderDashboard);
        rvOrderDashboard.setAdapter(dashboardOrderAdapter);
        btnOtherOrder.setOnClickListener(v -> {

        });
        return dashboardView;
    }

    private void setDashboardProperty(View dashboardView, RecyclerView rvOrderDashboard) {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(dashboardView.getContext(), 2);
        rvOrderDashboard.setLayoutManager(mLayoutManager);
        rvOrderDashboard.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        rvOrderDashboard.setItemAnimator(new DefaultItemAnimator());
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {


        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }

        }


    }

    private void loadFragment(Fragment fragment, String fragmentName, boolean needToBackStack) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.clHomePageContainer, fragment);
        fragmentTransaction.addToBackStack(fragmentName);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    public interface OrderDashboardFragmentListener {
        void onDashboardOpen();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(this);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void setupToolbar() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        toolbar = ((MainActivity2) getActivity()).findViewById(R.id.toolbar);
        actionBar = ((MainActivity2) getActivity()).getSupportActionBar();
        drawer = ((MainActivity2) getActivity()).findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(true);
        // Show back button
        actionBar.setDisplayHomeAsUpEnabled(false);
        ((MainActivity2) getActivity()).setDrawerLocked(false);
        TextView tvToolbarTitle = toolbar.findViewById(R.id.tvToolbarTitle);
        tvToolbarTitle.setText("Dashboard");
        AppBarLayout.LayoutParams params =
                (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(0);
//        actionBar.setTitle("Dashboard");
        toggle.syncState();
        /*toggle.setDrawerIndicatorEnabled(true);
        // Show back button
        actionBar.setDisplayHomeAsUpEnabled(false);
        toggle.syncState();*/
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
      /*  Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Delivery Boy");
        toolbar.setTitleTextColor(getActivity().getResources().getColor(R.color.black));

        AutoCompleteTextView actvSearchMenu = toolbar.findViewById(R.id.actvSearchMenu);
        ImageButton ibFilter = toolbar.findViewById(R.id.ibFilter);
        ImageButton ibSearch = toolbar.findViewById(R.id.ibSearch);
        actvSearchMenu.setVisibility(View.GONE);
        ibSearch.setVisibility(View.GONE);
        ibFilter.setVisibility(View.GONE);*/
    }

}
