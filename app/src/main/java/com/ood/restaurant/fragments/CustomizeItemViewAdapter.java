package com.ood.restaurant.fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ood.restaurant.Data.Decorator;
import com.ood.restaurant.Data.Food;
import com.ood.restaurant.MenuItemData;
import com.ood.restaurant.R;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by david-lewis on 4/24/2016.
 */
public class CustomizeItemViewAdapter extends RecyclerView.Adapter<MyHolder> {

    private LayoutInflater inflater;
    List<MenuItemData> decorators = Collections.emptyList();
    public CustomizeItemViewAdapter(Context context, List<MenuItemData> hackyData)
    {

        inflater = LayoutInflater.from(context);
        decorators = hackyData;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = inflater.inflate(R.layout.fragment_customizeorder,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position)
    {
        MenuItemData currentDecorator = decorators.get(position);
        holder.setDecorator_Name(currentDecorator.itemName);
        holder.setDecorator_price(Double.toString(currentDecorator.itemPrice));
        holder.setDecorator_description(currentDecorator.itemDescription);
    }

    @Override
    public int getItemCount() {
       return decorators.size();
    }
}



class MyHolder extends RecyclerView.ViewHolder
{
    private TextView decorator_Name;
    private TextView decorator_price;
    private TextView decorator_description;


    public MyHolder(View itemView)
    {
        super(itemView);
        decorator_Name = (TextView) itemView.findViewById(R.id.txtTopping);
        decorator_price = (TextView) itemView.findViewById(R.id.txtToppingPrice);
        decorator_description = (TextView) itemView.findViewById(R.id.txtToppingDescription);
    }

    // setters to set the Text of each TextView
    public void setDecorator_Name(String decorator_name){this.decorator_Name.setText(decorator_name);}
    public void setDecorator_price(String decorator_price){this.decorator_price.setText(decorator_price);}
    public void setDecorator_description(String decorator_description){this.decorator_description.setText(decorator_description);}
}
