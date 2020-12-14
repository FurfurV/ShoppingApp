package com.example.viktoria_cseke_assignment2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viktoria_cseke_assignment2.Basket;
import com.example.viktoria_cseke_assignment2.DbHandler;
import com.example.viktoria_cseke_assignment2.FoodItem;
import com.example.viktoria_cseke_assignment2.R;

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
        int amount = items.get(position).getItemamount();
        double price = items.get(position).getPrice();

        holder.price.setText(String.format("€ %.2f", price*amount));
        holder.amount.setText(Integer.toString(items.get(position).getItemamount()));
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println(">>>"+items.get(position).getName());
                DbHandler dbHandler = new DbHandler(context);
                dbHandler.deleteCartItem(items.get(position).getCode());
                System.out.println("removed");
                items.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(0,getItemCount());

                System.out.println("Updated positions" +getItemCount());
                Basket.cost.setText(String.format("€ %.2f",updatePrice()));

                updatePrice();

            }
        });

        holder.increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(String.valueOf(holder.amount.getText()));
                Double foodprice = items.get(position).getPrice();

                count++;
                holder.amount.setText(Integer.toString(count));
                holder.price.setText(String.format("€ %.2f", foodprice*count));
                items.get(position).setItemamount(count);
                dbHandler.updateCartAmount(items.get(position).getCode(),Integer.toString(count));

                double price=updatePrice();
                Basket.cost.setText(String.format("€ %.2f",price));
            }
        });

        holder.decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(String.valueOf(holder.amount.getText()));
                Double foodprice = items.get(position).getPrice();
                if(count == 1){
                    holder.amount.setText("1");
                    holder.price.setText(String.format("€ %.2f", foodprice));
                    items.get(position).setItemamount(count);
                    dbHandler.updateCartAmount(items.get(position).getCode(),Integer.toString(count));

                    double price=updatePrice();
                    Basket.cost.setText(String.format("€ %.2f",price));
                }else{
                    count-=1;
                    holder.amount.setText(Integer.toString(count));
                    holder.price.setText(String.format("€ %.2f", foodprice*count));
                    items.get(position).setItemamount(count);
                    dbHandler.updateCartAmount(items.get(position).getCode(),Integer.toString(count));

                    double price=updatePrice();
                    Basket.cost.setText(String.format("€ %.2f",price));
                }

            }
        });
    }

    public void removeall(){
        items.clear();
        System.out.println("removed all");
        Basket.cost.setText(String.format("€ %.2f",0.0));
    }

    public double updatePrice(){
        double newPrice=0;
        for (int i =0; i<getItemCount();i++){
            int amount = items.get(i).getItemamount();
            double price = items.get(i).getPrice();

            System.out.println(amount*price+"prices <<<<<<<<<<<<<");
            newPrice=newPrice+(amount*price);
        }
        return newPrice;
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
        private ImageButton increase,decrease;
        private TextView amount;

        public ThisViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.basketitemname);
            code = (TextView) itemView.findViewById(R.id.basketitemcode);
            price = (TextView) itemView.findViewById(R.id.basketitemprice);
            remove = (ImageButton) itemView.findViewById(R.id.remove);
            increase = (ImageButton)itemView.findViewById(R.id.basketincrease);
            decrease = (ImageButton)itemView.findViewById(R.id.basketdecrease);
            amount =(TextView) itemView.findViewById(R.id.basketitem_amount);

        }

    }
}
