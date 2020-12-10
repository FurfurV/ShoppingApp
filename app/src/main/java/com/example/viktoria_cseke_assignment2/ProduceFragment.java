package com.example.viktoria_cseke_assignment2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ProduceFragment extends Fragment {
    private RecyclerView myRecycleV;
    private List<FoodItem> foodlist;
    View v;

    public ProduceFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        foodlist = new ArrayList<>();
        foodlist.add(new FoodItem("Cherry tomatoes","p000",0.89,R.drawable.cherrytomato));
        foodlist.add(new FoodItem("Red cabbage","p001",0.99,R.drawable.cabbage));
        foodlist.add(new FoodItem("Shiitake mushrooms","p002",2.30,R.drawable.shiitake));
        foodlist.add(new FoodItem("Birds eye chilli","p003",2.95,R.drawable.chilli));
        foodlist.add(new FoodItem("Mango","p004",0.99,R.drawable.mango));
        foodlist.add(new FoodItem("Bananas","p005",1.10,R.drawable.banana));

        v= inflater.inflate(R.layout.fragment_produce, container, false);
        myRecycleV = (RecyclerView) v.findViewById(R.id.produceRecycle);
        MyRecycleViewAdapter myRecycleViewAdapter = new MyRecycleViewAdapter(getContext(), foodlist, new ClickListener() {
            @Override
            public void onPositionClicked(int position,String foodItem) {
                foodlist.get(position);
            }
        });
        myRecycleV.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleV.setAdapter(myRecycleViewAdapter);

        return v;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}