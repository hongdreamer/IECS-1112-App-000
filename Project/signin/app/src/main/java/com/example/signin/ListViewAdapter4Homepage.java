package com.example.signin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter4Homepage extends BaseAdapter {
    private Context context;
    private List<FoodItem> listAd;

    public ListViewAdapter4Homepage(Context context, List<FoodItem> listAd) {
        this.context = context;
        this.listAd = listAd;
    }

    @Override
    public int getCount() {
        return listAd.size();
    }

    @Override
    public Object getItem(int i) {
        return listAd.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    // set the content of the items
    // setting the name and image would be dealt here.
    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.homepage_ad_layout,viewGroup,false);
        }
        FoodItem ad = listAd.get(i);
        ImageView iv = view.findViewById(R.id.iv_ad_pic);
        iv.setImageResource(ad.getImageId());
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);

        TextView tvAdName = view.findViewById(R.id.tv_ad_text);
        tvAdName.setText(ad.getFoodName());;

        return view;
    }
}
