package com.example.myapplication.Models;

public class HIstoryModel {

    private boolean deleverd ;
    private  String date;
    private String product_name;

    private String price ;
    private String quantity;

    private String total_amount ;


    public HIstoryModel(boolean deleverd, String date, String product_name, String price, String quantity, String total_amount) {
        this.deleverd = deleverd;
        this.date = date;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.total_amount = total_amount;
    }


    public boolean isDeleverd() {
        return deleverd;
    }

    public String getDate() {
        return date;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getTotal_amount() {
        return total_amount;
    }
}
