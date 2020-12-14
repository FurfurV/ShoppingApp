package com.example.viktoria_cseke_assignment2;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class BasketItem extends RecyclerView.ViewHolder {
    public TextView itemname;
    public TextView itemprice;
    public TextView itemcode;
    public TextView itemamount;

    public BasketItem(View itemView){
        super(itemView);
        itemname = itemView.findViewById(R.id.basketitemname);
        itemcode = itemView.findViewById(R.id.basketitemcode);
        itemprice = itemView.findViewById(R.id.basketitemprice);
        itemamount = itemView.findViewById(R.id.basketitem_amount);
    }

}
