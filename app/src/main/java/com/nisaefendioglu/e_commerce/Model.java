package com.nisaefendioglu.e_commerce;

import android.widget.ImageView;

import java.util.Comparator;

public class Model
{
  String name,desc,price,img;
  ImageView imageUrl;

  public static Comparator<Model> modelComparatorAZ = new Comparator<Model>() {
      @Override
      public int compare(Model m1, Model m2) {
          return m1.getName().compareTo(m2.getName());

      }
  };

    public static Comparator<Model> modelComparatorZA = new Comparator<Model>() {
        @Override
        public int compare(Model m1, Model m2) {
            return m2.getName().compareTo(m1.getName());

        }
    };


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
