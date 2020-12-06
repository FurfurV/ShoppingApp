package com.example.viktoria_cseke_assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder> {

//    String name_data[], code_data[];
//    Double price_data[];
//    int images_data[];
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
    }

    @Override
    public int getItemCount() {
        return food.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView code;
        private TextView price;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textView_Name);
            code = (TextView) itemView.findViewById(R.id.textView_Code);
            price = (TextView) itemView.findViewById(R.id.textView_Price);
            img = (ImageView) itemView.findViewById(R.id.food_image);
        }
    }
}
