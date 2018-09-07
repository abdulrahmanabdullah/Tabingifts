package com.example.abdulrahman.tabingifts.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abdulrahman.tabingifts.BR;
import com.example.abdulrahman.tabingifts.CallViewProdcutFragment;
import com.example.abdulrahman.tabingifts.R;
import com.example.abdulrahman.tabingifts.databinding.ProductItemBinding;
import com.example.abdulrahman.tabingifts.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsHolder> {


    private List<Product> listProduct = new ArrayList<>();
    private Context context;

    public ProductsAdapter(List<Product> listProduct, Context context) {
        this.listProduct = listProduct;
        this.context = context;
    }

    @Override
    public ProductsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.product_item,parent,false);
        ProductItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.product_item,parent,false);
        return new ProductsHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(ProductsHolder holder, int position) {
        Product product = listProduct.get(position);
        holder.binding.setProduct(product);
//        holder.binding.setVariable(BR.porduct,product);
        holder.binding.setCallViewProduct((CallViewProdcutFragment) context);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public void refreshList(List<Product> products){
        listProduct.clear();
        listProduct.addAll(products);
        notifyDataSetChanged();
    }
    // ViewHolder ..
    public class ProductsHolder extends RecyclerView.ViewHolder{
//        ViewDataBinding binding ;
        ProductItemBinding binding ;
        public ProductsHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
