package com.example.abdulrahman.tabingifts.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

public class Product implements Parcelable {

    private String title;
    private String description;
    private int image;
    private BigDecimal price;
    private BigDecimal sale_price;
    private int num_ratings;
    private BigDecimal rating;
    private int serial_number;

    public Product(String title, String description, int image, BigDecimal price, BigDecimal sale_price, int num_ratings, BigDecimal rating, int serial_number) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.price = price;
        this.sale_price = sale_price;
        this.num_ratings = num_ratings;
        this.rating = rating;
        this.serial_number = serial_number;
    }

    // Empty constructor .
    public Product(){}

    protected Product(Parcel parcel){
        title = parcel.readString();
        description=parcel.readString();
        image = parcel.readInt();
        num_ratings = parcel.readInt();
        serial_number = parcel.readInt();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeInt(image);
        parcel.writeInt(num_ratings);
        parcel.writeInt(serial_number);
    }


    public static Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel parcel) {
            return new Product(parcel);
        }

        @Override
        public Product[] newArray(int i) {
            return new Product[i];
        }
    };

    public boolean hasSalePrice(){
        double salePrice = sale_price.doubleValue();
        if(salePrice > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSale_price() {
        return sale_price;
    }

    public void setSale_price(BigDecimal sale_price) {
        this.sale_price = sale_price;
    }

    public int getNum_ratings() {
        return num_ratings;
    }
    // get num_ratings as String
    public String getNumRatingsString(){
        return ("( "+getNum_ratings() +") ");
    }

    public void setNum_ratings(int num_ratings) {
        this.num_ratings = num_ratings;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public int getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(int serial_number) {
        this.serial_number = serial_number;
    }
}
