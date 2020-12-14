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


public class BreadFragment extends Fragment {
    private RecyclerView myRecycleV;
    private List<FoodItem> foodlist;
    View v;

    public BreadFragment() {
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
        foodlist.add(new FoodItem("Artisan bread","b000",1.70, R.drawable.bread,1));
        foodlist.add(new FoodItem("Olive bread","b001",2.00,R.drawable.olive_bread,1));
        foodlist.add(new FoodItem("Tiger bread rolls","b002",1.90,R.drawable.tiger_bread_roll,1));
        foodlist.add(new FoodItem("Pain au chocolat","b003",0.80,R.drawable.painauchoco,1));
        foodlist.add(new FoodItem("Chocolate chip cookie","b004",0.60,R.drawable.cookies,1));
        foodlist.add(new FoodItem("Tomato focaccia","b005",2.60,R.drawable.tomatofocaccia,1));


        v= inflater.inflate(R.layout.fragment_bread, container, false);
        myRecycleV = (RecyclerView) v.findViewById(R.id.breadRecycle);
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