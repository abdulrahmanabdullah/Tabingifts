package com.example.abdulrahman.tabingifts;

import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.abdulrahman.tabingifts.databinding.ActivityMainBinding;
import com.example.abdulrahman.tabingifts.dialog.ChooseQuantityDialog;
import com.example.abdulrahman.tabingifts.fragments.MainFragment;
import com.example.abdulrahman.tabingifts.fragments.ViewProductFragment;
import com.example.abdulrahman.tabingifts.model.Product;
import com.example.abdulrahman.tabingifts.util.Preferencekeys;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements CallViewProdcutFragment,ShowDialogInterface {

    private  final String TAG =  "Main";
    // data binding
    ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        init();
        getShoppingCart();
    }

    // init fragment..
    public void init(){
//        ViewProductFragment fragment = new ViewProductFragment();
        MainFragment fragment = new MainFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container,fragment,getString(R.string.fragment_main)).commit();
    }

    private void getShoppingCart(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Set<String> serialNumbers = preferences.getStringSet(Preferencekeys.shopping_cart,new HashSet<String>());
        mBinding.setNumCartItem(serialNumbers.size());
    }

    @Override
    public void inflateViewProductFragment(Product product) {
       ViewProductFragment fragment = new ViewProductFragment();
       Bundle bundle = new Bundle();
       bundle.putParcelable(getString(R.string.intent_product),product);
       fragment.setArguments(bundle);
       FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
       transaction.addToBackStack(getString(R.string.fragment_view_product));
       transaction.replace(R.id.main_container,fragment,getString(R.string.fragment_view_product)).commit();
    }

    @Override
    public void showDialog() {
        ChooseQuantityDialog dialog = new ChooseQuantityDialog();
        dialog.show(getSupportFragmentManager(),getString(R.string.dialog_choose_quantity));
    }

    @Override
    public void setQuantity(int quantity) {
        ViewProductFragment fragment =(ViewProductFragment) getSupportFragmentManager().findFragmentByTag(getString(R.string.fragment_view_product));
        if ( fragment !=null ){
            // set quantity by using viewModel ..
            fragment.mBinding.getProductView().setQuantity(quantity);
        }
    }

    @Override
    public void addToCart(Product product, int quantity) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

        Set<String> serialNumbers = preferences.getStringSet(Preferencekeys.shopping_cart,new HashSet<String>());
        serialNumbers.add(String.valueOf(product.getSerial_number()));
        editor.commit();

        int currentQunatity = preferences.getInt(String.valueOf(product.getSerial_number()),0);
        editor.putInt(String.valueOf(product.getSerial_number()),(currentQunatity + quantity));
        editor.commit();

        setQuantity(1);

        Toast.makeText(this,"add to cart ",Toast.LENGTH_SHORT).show();

        getShoppingCart();

    }
}
