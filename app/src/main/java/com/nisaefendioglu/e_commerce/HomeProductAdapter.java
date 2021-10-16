package com.nisaefendioglu.e_commerce;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeProductAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<HomeProductList> mailArrayList;

    public HomeProductAdapter(Activity activity, ArrayList<HomeProductList> gmailArrayList) {

        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mailArrayList = gmailArrayList;
    }

    @Override
    public int getCount() {
        return mailArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mailArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = mInflater.inflate(R.layout.product_item_layout, null);
        TextView tvProductName =  convertView.findViewById(R.id.tvProductName);
        TextView tvProductPrice = convertView.findViewById(R.id.tvProductPrice);
        ImageView imageView = convertView.findViewById(R.id.ivProductImage);
        HomeProductList mail = mailArrayList.get(position);
        tvProductName.setText(mail.getName());
        tvProductPrice.setText(mail.getPrice());
        imageView.setImageResource(mail.getImage());
        return convertView;
    }
}