package com.example.abdulrahman.tabingifts.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abdulrahman.tabingifts.databinding.FragmentMainBinding;
import com.example.abdulrahman.tabingifts.model.Product;
import com.example.abdulrahman.tabingifts.util.Products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    FragmentMainBinding binding ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater);
        binding.swipeRefreshLayout.setOnRefreshListener(this);
        setupBindingRecycler();
        return binding.getRoot();

    }

    private void setupBindingRecycler(){
        Products products = new Products();
        List<Product> list = new ArrayList<>();
        list.addAll(Arrays.asList(products.PRODUCTS));
        binding.setFoobar(list);
    }
    @Override
    public void onRefresh() {
        onItemsLoadComplete();
    }

    void onItemsLoadComplete(){
        (binding.recyclervView.getAdapter()).notifyDataSetChanged();
        binding.swipeRefreshLayout.setRefreshing(false);
    }
}
