package com.example.abdulrahman.tabingifts;

import com.example.abdulrahman.tabingifts.model.Product;

// This interface to call ViewProductFragment.class
// This interface impl in MainActivity .
public interface CallViewProdcutFragment {

    void inflateViewProductFragment(Product product);
    void addToCart(Product product,int quantity);
}
