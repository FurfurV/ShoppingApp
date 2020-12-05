package com.example.viktoria_cseke_assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder> {

    String name_data[], code_data[];
    Double price_data[];
    int images_data[];
    Context context;

    public MyRecycleViewAdapter(Context ct,String name[],String code[],Double price[],int images[]){
        context = ct;
        name_data = name;
        code_data = code;
        price_data = price;
        images_data = images;
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

        holder.name.setText(name_data[position]);
        holder.code.setText(code_data[position]);
        String p=Double.toString(price_data[position]);
        holder.price.setText(p);
        holder.img.setImageResource(images_data[position]);


    }

    @Override
    public int getItemCount() {
        return name_data.length;
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
