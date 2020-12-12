package com.example.viktoria_cseke_assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder> {
    List<FoodItem> food;
    Context context;

    public MyRecycleViewAdapter(Context ct,List<FoodItem> myfood){
        context = ct;
        food=myfood;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.grocery_item, parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(food.get(position).getName());
        holder.code.setText(food.get(position).getCode());
        holder.price.setText(String.format("€ %.2f",food.get(position).getPrice()));
        holder.img.setImageResource(food.get(position).getImage());


        holder.addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(">>>>>>>>>>>>>>>>>>"+ food.get(position).getName());
                String foodname = food.get(position).getName();
                String foodcode = food.get(position).getCode();
                Double foodprice = food.get(position).getPrice();
                DbHandler dbHandler = new DbHandler(context);
                dbHandler.InsertCartDetails(foodname,foodcode,foodprice);
                Toast.makeText(v.getContext(), food.get(position).getName() +" added to cart", Toast.LENGTH_SHORT).show();
                ArrayList<HashMap<String, String>> foods = dbHandler.GetCart();
                System.out.println(foods);
            }
        });

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println(">>>>>>>>>>>>>>>>>>"+ food.get(position).getName());
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return food.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView code;
        private TextView price;
        private ImageView img;
        private Button addtocart;
        private FoodItem foodItem=new FoodItem();

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.textView_Name);
            code = (TextView) itemView.findViewById(R.id.textView_Code);
            price = (TextView) itemView.findViewById(R.id.textView_Price);
            img = (ImageView) itemView.findViewById(R.id.food_image);
            addtocart = (Button) itemView.findViewById(R.id.add_to_cart);

        }
    }
}
