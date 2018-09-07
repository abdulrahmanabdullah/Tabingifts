package com.example.abdulrahman.tabingifts.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abdulrahman.tabingifts.R;
import com.example.abdulrahman.tabingifts.databinding.FragmentViewProductBinding;
import com.example.abdulrahman.tabingifts.model.Product;
import com.example.abdulrahman.tabingifts.util.Products;
import com.example.abdulrahman.tabingifts.viewModel.ProductViewModel;

public class ViewProductFragment extends Fragment {

// dataBinding
  public FragmentViewProductBinding mBinding ;
    // Product object
    private Product product ;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null ){
           product = bundle.getParcelable(getString(R.string.intent_product));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentViewProductBinding.inflate(inflater);
//        Products products = new Products();
//        mBinding.setProduct(product);
        ProductViewModel productViewModel = new ProductViewModel();
        productViewModel.setProduct(product);
        productViewModel.setQuantity(1);
        mBinding.setProductView(productViewModel);
        return mBinding.getRoot();
    }
}
