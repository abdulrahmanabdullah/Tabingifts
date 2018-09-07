package com.example.abdulrahman.tabingifts.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.abdulrahman.tabingifts.adapter.ProductsAdapter;
import com.example.abdulrahman.tabingifts.model.Product;

import java.util.List;

public class MainFragmentBindingAdapter {

    // numbers of column
    private static final int NUM_COLUMNS = 2 ;
    @BindingAdapter("productsList")
    public static void setProductList(RecyclerView recyclerView , List<Product> list){
        if (list == null  ) return;
        // get LayoutManager
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager() ;
        if (layoutManager == null ){
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(),NUM_COLUMNS));
        }
        // get Adapter
        ProductsAdapter adapter =(ProductsAdapter) recyclerView.getAdapter() ;
        if (adapter == null ){
            adapter = new ProductsAdapter(list,recyclerView.getContext());
            recyclerView.setAdapter(adapter);
        }

    }
}
