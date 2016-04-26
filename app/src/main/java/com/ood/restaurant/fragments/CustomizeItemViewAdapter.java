package com.ood.restaurant.fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ood.restaurant.Data.Decorator;
import com.ood.restaurant.Data.Food;
import com.ood.restaurant.Listeners;
import com.ood.restaurant.MenuItemData;
import com.ood.restaurant.R;
import com.ood.restaurant.StaticData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by david-lewis on 4/24/2016.
 */
public class CustomizeItemViewAdapter extends RecyclerView.Adapter<MyHolder> {

    private LayoutInflater inflater;
    private Listeners.OnCustomizeAddListener mListener;
    static Food food = null;
    StaticData sData = StaticData.i();
    String itemName = "com.ood.restaurant.Data.";
    List<MenuItemData> decorators = Collections.emptyList();
    HashMap<Food,List<MenuItemData>> foodListHashMap;
    public CustomizeItemViewAdapter(Context context, String itemName, Listeners.OnCustomizeAddListener listener,Food)
    {

        inflater = LayoutInflater.from(context);
        decorators = hackyData;
        foodListHashMap = hackyData;
        decorators = foodListHashMap.get()
        mListener = listener;
        this.itemName+=itemName.trim();
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
        final MenuItemData currentDecorator = decorators.get(position);
        holder.setDecorator_Name(currentDecorator.itemName);
        holder.setDecorator_price(Double.toString(currentDecorator.itemPrice));
        holder.setDecorator_description(currentDecorator.itemDescription);
        final Button btn_add = (Button) holder.mView.findViewById(R.id.btnAdd);
        btn_add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mListener != null)
                {

                    mListener.onCustomizeAddClicked(currentDecorator.itemName);


                }
            }
        });
    }

    @Override
    public int getItemCount() {
       return decorators.size();
    }
}


    public HashMap<Food, List<MenuItemData>> converToMenuItem(String itemName)
    {
        List<MenuItemData> data = new ArrayList<>();
        //HashMap<Food,List<MenuItemData>> foodListHashMap = new HashMap<>();


        String className = "com.ood.restaurant.Data."+itemName;

        try {
            List<Decorator> getClass = sData.getStuff().get(Class.forName(className.trim()));
            food  = (Food)Class.forName(className.trim()).newInstance();
            for (Decorator d : getClass) {
                MenuItemData tempData = new MenuItemData();
                tempData.itemName = (String) d.getClass().getMethod("getName", (Class[]) null).invoke(d, (Object[]) null);
                tempData.itemDescription = tempData.itemName;
                tempData.itemPrice = (Double) d.getClass().getMethod("getCost", (Class[]) null).invoke(d, (Object[]) null);
                data.add(tempData);
            }


        }catch (Exception e)
        {
            // Exception...
            e.printStackTrace();
        }
        foodListHashMap.put(food,data);
        //return data;
        return foodListHashMap;
    }



class MyHolder extends RecyclerView.ViewHolder
{
    private TextView decorator_Name;
    private TextView decorator_price;
    private TextView decorator_description;
    public View mView; // access to the current fragment and all it's data.


    public MyHolder(View itemView)
    {

        super(itemView);
        decorator_Name = (TextView) itemView.findViewById(R.id.txtTopping);
        decorator_price = (TextView) itemView.findViewById(R.id.txtToppingPrice);
        decorator_description = (TextView) itemView.findViewById(R.id.txtToppingDescription);
        mView = itemView;
    }

    // setters to set the Text of each TextView
    public void setDecorator_Name(String decorator_name){this.decorator_Name.setText(decorator_name);}
    public void setDecorator_price(String decorator_price){this.decorator_price.setText(decorator_price);}
    public void setDecorator_description(String decorator_description){this.decorator_description.setText(decorator_description);}
}
