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


public class DairyFragment extends Fragment {

    private RecyclerView myRecycleV;
    private List<FoodItem> foodlist;
    View v;

    public DairyFragment() {
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
        foodlist.add(new FoodItem("Blue cheese","d000",3.00,R.drawable.bluecheese));
        foodlist.add(new FoodItem("Red cheddar cheese","d001",2.00,R.drawable.cheddar));
        foodlist.add(new FoodItem("Butter","d002",3.50,R.drawable.butter));
        foodlist.add(new FoodItem("Greek yogurt","d003",2.59,R.drawable.greekyogurt));
        foodlist.add(new FoodItem("Smoked scamorza","d004",3.30,R.drawable.scamorza));
        foodlist.add(new FoodItem("Emmental cheese","d005",2.60,R.drawable.emmental));

        v= inflater.inflate(R.layout.fragment_dairy, container, false);
        myRecycleV = (RecyclerView) v.findViewById(R.id.dairyRecycle);
        MyRecycleViewAdapter myRecycleViewAdapter = new MyRecycleViewAdapter(getContext(), foodlist, new ClickListener() {
            @Override
            public void onPositionClicked(int position,String foodItem) {

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