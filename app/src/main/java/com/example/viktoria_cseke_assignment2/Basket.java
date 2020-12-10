package com.example.viktoria_cseke_assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Basket extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DbHandler dbHandler;
    private List<FoodItem> food;
    private Cursor cursor;
    private BasketItemAdapter basketItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        food= new ArrayList<>();
        DbHandler dbHandler=new DbHandler(this);
        ArrayList<HashMap<String, String>> getCart = dbHandler.GetCart();
        System.out.println(getCart.size());

//        food.add(new FoodItem("Mango","p004",0.99));
//        food.add(new FoodItem("Bananas","p005",1.10));

        recyclerView = (RecyclerView) findViewById(R.id.basketRecycle);
//        BasketItemAdapter basketItemAdapter = new BasketItemAdapter(food,this);
        BasketItemAdapter basketItemAdapter = new BasketItemAdapter( food,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(basketItemAdapter);
    }
}