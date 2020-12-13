package com.example.viktoria_cseke_assignment2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BasketItemAdapter extends RecyclerView.Adapter<BasketItemAdapter.ThisViewHolder> {
    List<FoodItem> items;
    Context context;
    private DbHandler dbHandler;

    public BasketItemAdapter(){

    }

    public BasketItemAdapter( List<FoodItem> item, Context ct) {
        this.items = item;
        this.context = ct;
    }

    @NonNull
    @Override
    public ThisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.basket_item, parent,false);
        ThisViewHolder myViewHolder =  new ThisViewHolder(v);
        dbHandler=new DbHandler(context);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ThisViewHolder holder, int position) {
        holder.name.setText(items.get(position).getName());
        holder.code.setText(items.get(position).getCode());
        holder.price.setText(String.format("€ %.2f", items.get(position).getPrice()));
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println(">>>"+items.get(position).getName());
                DbHandler dbHandler = new DbHandler(context);
                dbHandler.DeleteCartItem(items.get(position).getCode());
                System.out.println("removed");
                notifyItemRemoved(position);
                items.remove(position);

            }
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ThisViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView code;
        private TextView price;
        private ImageButton remove;

        public ThisViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.basketitemname);
            code = (TextView) itemView.findViewById(R.id.basketitemcode);
            price = (TextView) itemView.findViewById(R.id.basketitemprice);
            remove = (ImageButton) itemView.findViewById(R.id.remove);
        }
    }
}
