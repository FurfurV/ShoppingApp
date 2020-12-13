package com.example.viktoria_cseke_assignment2.fragments;

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

import com.example.viktoria_cseke_assignment2.FoodItem;
import com.example.viktoria_cseke_assignment2.R;
import com.example.viktoria_cseke_assignment2.adapters.MyRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class MeatFragment extends Fragment {
    private RecyclerView myRecycleV;
    private List<FoodItem> foodlist;
    View v;


    public MeatFragment() {
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
        foodlist.add(new FoodItem("Streaky bacon","m000",2.40, R.drawable.bacon));
        foodlist.add(new FoodItem("Chicken nuggets","m001",2.65,R.drawable.chickennuggets));
        foodlist.add(new FoodItem("T-bone steak","m002",10.50,R.drawable.tbonesteak));
        foodlist.add(new FoodItem("Italian sausage","m003",4.30,R.drawable.italiansausage));
        foodlist.add(new FoodItem("Organic beef ribs","m004",12.00,R.drawable.beefrib));
        foodlist.add(new FoodItem("Chilli chicken wings","m005",3.20,R.drawable.chilliwings));

        v=inflater.inflate(R.layout.fragment_meat, container, false);
        myRecycleV = (RecyclerView) v.findViewById(R.id.meatRecycle);
        MyRecycleViewAdapter myRecycleViewAdapter = new MyRecycleViewAdapter(getContext(), foodlist);
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