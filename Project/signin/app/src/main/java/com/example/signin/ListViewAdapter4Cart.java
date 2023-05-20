package com.example.signin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter4Cart extends BaseAdapter {
    private Context context;
    private List<FoodItem> listFoods;

    public ListViewAdapter4Cart(Context context, List<FoodItem> listFoods) {
        this.context = context;
        this.listFoods = listFoods;
    }

    @Override
    public int getCount() {
        return listFoods.size();
    }

    @Override
    public Object getItem(int i) {
        return listFoods.get(i);
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
            view = LayoutInflater.from(context).inflate(R.layout.order_list_layout,viewGroup,false);
        }
        FoodItem food = listFoods.get(i);
        ImageView iv = view.findViewById(R.id.iv_order_food);
        iv.setImageResource(food.getImageId());
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);


        TextView tvFoodName = view.findViewById(R.id.tv_order_food_name);
        tvFoodName.setText(food.getFoodName());

        TextView tvFoodPrice = view.findViewById(R.id.tv_order_food_price);
        tvFoodPrice.setText(String.valueOf(food.getFoodPrice()));

        TextView tvFoodQuantity = view.findViewById(R.id.tv_order_quantity);
        tvFoodQuantity.setText(String.valueOf(food.getFoodQuantity()));

        TextView tvFoodPs = view.findViewById(R.id.tv_order_ps);
        tvFoodPs.setText(food.getFoodPs());

        return view;
    }
}
