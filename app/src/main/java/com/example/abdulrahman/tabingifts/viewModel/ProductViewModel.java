package com.example.abdulrahman.tabingifts.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.Nullable;

import com.android.databinding.library.baseAdapters.BR;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.abdulrahman.tabingifts.model.Product;

public class ProductViewModel extends BaseObservable {

    private Product product ;
    private int quantity ;
    private boolean imageVisibility = false ;
    //This variable write in fragment_view_product.xml. to bind ImageBindingAdapter.class
    private RequestListener customRequestListener;


    @Bindable
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        notifyPropertyChanged(BR.quantity);
    }


    @Bindable
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        notifyPropertyChanged(BR.product);
    }

    @Bindable
    public boolean isImageVisibility() {
        return imageVisibility;
    }

    public void setImageVisibility(boolean imageVisibility) {
        this.imageVisibility = imageVisibility;
        notifyPropertyChanged(BR.imageVisibility);
    }

    // Request Listener .. this method call into fragment_view_product.xml,without get word .
    public RequestListener getCustomRequestListener() {
        return new RequestListener() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {
                setImageVisibility(true);
                return false;
            }
        };
    }
}
