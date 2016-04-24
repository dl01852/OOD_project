package com.ood.restaurant;

import android.content.Context;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by david-lewis on 4/5/2016.
 */
public class MenuItemViewAdapter extends RecyclerView.Adapter<MyHolder> {

    private LayoutInflater inflater;
    List<MenuItemData> MenuItems = Collections.emptyList(); // List of MenuItems.(OnBindViewHolder needs this)

    public MenuItemViewAdapter(Context context, List<MenuItemData> data)
    {
        inflater = LayoutInflater.from(context);
        MenuItems = data;
    }

    @Override // Note:This function must return whatever the type is in the Recycler.Adapter<Type>
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {  // Purpose: this function is to inflate each Menu item(each row) from the fragment_menu_item.xml.(inflate the XML)

        View view = inflater.inflate(R.layout.fragment_menu_item,parent,false); // this will inflate(create) a new view for each menu item
        MyHolder holder = new MyHolder(view); // pass the newly inflated view to MyHolder class.
        return holder;
    }

    @Override // The parameter holder must be of the same type of Recycler.Adapter<Type>
    public void onBindViewHolder(MyHolder holder, int position)
    {// this function binds each Menu XML with it's respective data.

        MenuItemData currentItem = MenuItems.get(position);
        holder.setItem_Name(currentItem.itemName);
        holder.setItem_Price(Double.toString(currentItem.itemPrice)); // price might want to be represented as string
        holder.setItem_description(currentItem.itemDescription);
    }

    @Override
    public int getItemCount() {

        return MenuItems.size();
    }
}

class MyHolder extends RecyclerView.ViewHolder
{
    // This class holds data about a particular Menu item and it also ensures
    // that we only call findViewById when necessary since it is a very expensive operation.

    private TextView item_Name;
    private TextView item_Price;
    private TextView item_description;


    public MyHolder(View itemView) {
        super(itemView);
        item_Name = (TextView) itemView.findViewById(R.id.item_name);
        item_Price = (TextView) itemView.findViewById(R.id.item_price);
        item_description = (TextView) itemView.findViewById(R.id.item_description);
    }


    // Setters to set the Text of each TextView.
    public void setItem_Name(String item_Name) {
        this.item_Name.setText(item_Name);
    }

    public void setItem_Price(String item_Price) {
        this.item_Price.setText(item_Price);
    }

    public void setItem_description(String item_description) {
        this.item_description.setText(item_description);
    }
}
