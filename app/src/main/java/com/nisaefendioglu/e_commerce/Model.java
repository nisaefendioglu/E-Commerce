package com.nisaefendioglu.e_commerce;

import android.widget.ImageView;

public class Model
{
  String name,desc,price,img;
  ImageView imageUrl;

    public Model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public ImageView getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(ImageView imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Model(String name, String desc, String price, String img, ImageView imageUrl) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.img = img;
        this.imageUrl = imageUrl;
    }
}
