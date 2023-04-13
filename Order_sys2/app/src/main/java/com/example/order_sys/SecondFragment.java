package com.example.order_sys;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.order_sys.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private ListView lvFoods;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lvFoods = (ListView) getView().findViewById(R.id.lv_foods);

        ArrayList<FoodItem> foods = new ArrayList<FoodItem>();
        foods.add(new FoodItem(R.drawable.pokemon_1, "Hamburger", 50));
        foods.add(new FoodItem(R.drawable.pokemon_2, "Chiken", 60));
        foods.add(new FoodItem(R.drawable.pokemon_3, "Ice Cream", 25));

        ListViewAdapter adapter = new ListViewAdapter(getContext(), foods);

        lvFoods.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}