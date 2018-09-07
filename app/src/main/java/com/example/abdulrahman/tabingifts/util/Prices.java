package com.example.abdulrahman.tabingifts.util;

import com.example.abdulrahman.tabingifts.model.Product;

import java.math.BigDecimal;
import java.util.HashMap;

// This class to returning price for product object
public class Prices {

    private static final HashMap<String,BigDecimal> PRICES ;
    static {
        PRICES = new HashMap<>();
        Products products = new Products();
        for (Product product : products.PRODUCTS){
            PRICES.put(String.valueOf(product.getSerial_number()),product.getPrice());
        }
    }

    public static HashMap<String,BigDecimal> getPrices(){
        return PRICES ;
    }
}
