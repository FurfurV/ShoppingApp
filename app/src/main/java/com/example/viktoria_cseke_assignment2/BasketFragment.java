package com.example.viktoria_cseke_assignment2;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;


public class BasketFragment extends Fragment {

    private RecyclerView recyclerView;
    private DbHandler dbHandler;
    private ArrayList<FoodItem> food = new ArrayList<>();
    private Cursor cursor;
    private BasketItemAdapter basketItemAdapter;

    public BasketFragment() {
        // Required empty public constructor
    }


    public static BasketFragment newInstance(String param1, String param2) {
        BasketFragment fragment = new BasketFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_basket, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.basketRecycle);
        food.add(new FoodItem("Mango","p004",0.99));
        food.add(new FoodItem("Bananas","p005",1.10));

        MyRecycleViewAdapter myRecycleViewAdapter = new MyRecycleViewAdapter(getContext(), food);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(myRecycleViewAdapter);
        return v;
    }

//    public void loadDatabase(){
//        dbHandler = new DbHandler(getActivity());
//        ArrayList<HashMap<String, String>> cart=dbHandler.GetCart();
//    }
}