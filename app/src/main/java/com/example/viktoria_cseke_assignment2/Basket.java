package com.example.viktoria_cseke_assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Basket extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DbHandler dbHandler;
    private List<FoodItem> food;
    private BasketItemAdapter basketItemAdapter;
    private Toolbar toolbar;
    private Double totalprice;
    public static TextView cost;
    private ArrayList<HashMap<String, String>> getCart;
    private Button emptybasket, continueShopping;
    private int size;

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        cost=(TextView) findViewById(R.id.cost);
        food= new ArrayList<>();
        dbHandler=new DbHandler(this);
        getCart = new ArrayList<>();
        getCart.addAll(dbHandler.GetCart());
        size = dbHandler.GetCart().size();

        emptybasket = (Button) findViewById(R.id.emptybasket);
        continueShopping = (Button) findViewById(R.id.continueshop);

        totalprice=0.0;

        for(int i =0; i<size;i++){
            Double price =Double.parseDouble(getCart.get(i).get("price"));
            String name = getCart.get(i).get("itemname").toString();
            String code = getCart.get(i).get("itemcode").toString();
            System.out.println(totalprice + price);
            totalprice= totalprice + price;
            food.add(new FoodItem(name,code,price));
        }

        recyclerView = (RecyclerView) findViewById(R.id.basketRecycle);
        basketItemAdapter = new BasketItemAdapter( food,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(basketItemAdapter);

        toolbar = findViewById(R.id.toolbarbasket);
        setSupportActionBar(toolbar);
        cost.setText(String.format("€ %.2f",basketItemAdapter.updatePrice()));
        basketItemAdapter.notifyDataSetChanged();
        basketItemAdapter.notifyItemRangeChanged(0,getCart.size());

        emptybasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.DeleteCart();
                food=new ArrayList<>();
                basketItemAdapter.notifyDataSetChanged();
                basketItemAdapter.removeall();
                Toast.makeText(getApplicationContext(), "Empty basket",Toast.LENGTH_SHORT).show();
            }
        });

        continueShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionsignin:
                startActivity(new Intent(this, Login.class));
                return true;

            case R.id.actionopencart:
                startActivity(new Intent(this, Basket.class));
                return true;

            case R.id.actiongohome:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}