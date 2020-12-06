package com.example.viktoria_cseke_assignment2;

public class FoodItem {
    private String name;
    private String code;
    private Double price;
    private int image;

    public FoodItem(){

    }

    public FoodItem(String name, String code, Double price, int image) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.image = image;
    }

    //Getter

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Double getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

    //Setter


    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
