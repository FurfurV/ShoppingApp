package com.example.viktoria_cseke_assignment2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viktoria_cseke_assignment2.DbHandler;
import com.example.viktoria_cseke_assignment2.FoodItem;
import com.example.viktoria_cseke_assignment2.R;

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
        holder.amount.setText(Integer.toString(food.get(position).getItemamount()));


        holder.addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(">>>>>>>>>>>>>>>>>>"+ food.get(position).getName());
                String foodname = food.get(position).getName();
                String foodcode = food.get(position).getCode();
                Double foodprice = food.get(position).getPrice();
                String itemamount = String.valueOf(holder.amount.getText());
                DbHandler dbHandler = new DbHandler(context);
//                ArrayList<HashMap<String, String>> myfood= dbHandler.getCartbyNum(food.get(position).getCode());
//                if(myfood.size() == 0){
//                    System.out.println("Newly added <<<<<<<<<<<<<<<<<<<");
//                }

                dbHandler.insertCartDetails(foodname,foodcode,foodprice,itemamount);
                Toast.makeText(v.getContext(), food.get(position).getName() +" added to cart", Toast.LENGTH_SHORT).show();
                ArrayList<HashMap<String, String>> foods = dbHandler.getCart();
                System.out.println(foods);
            }
        });

        holder.increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(String.valueOf(holder.amount.getText()));
                Double foodprice = food.get(position).getPrice();
                count++;
                holder.amount.setText(Integer.toString(count));
                holder.price.setText(String.format("€ %.2f", foodprice*count));
            }
        });

        holder.decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(String.valueOf(holder.amount.getText()));
                Double foodprice = food.get(position).getPrice();
                if(count == 1){
                    holder.amount.setText("1");
                    holder.price.setText(String.format("€ %.2f", foodprice));
                }else{
                    count-=1;
                    holder.amount.setText(Integer.toString(count));
                    holder.price.setText(String.format("€ %.2f", foodprice*count));
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return food.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView code;
        private TextView price;
        private TextView amount;
        private ImageView img;
        private Button addtocart;
        private FoodItem foodItem=new FoodItem();
        private ImageButton increase,decrease;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.textView_Name);
            code = (TextView) itemView.findViewById(R.id.textView_Code);
            price = (TextView) itemView.findViewById(R.id.textView_Price);
            img = (ImageView) itemView.findViewById(R.id.food_image);
            addtocart = (Button) itemView.findViewById(R.id.add_to_cart);
            increase = (ImageButton) itemView.findViewById(R.id.increase);
            decrease = (ImageButton) itemView.findViewById(R.id.decrease);
            amount = (TextView) itemView.findViewById(R.id.item_amount);

        }
    }
}
