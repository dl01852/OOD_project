package com.ood.restaurant;

import com.ood.restaurant.Data.Food;

/**
 * Created by david-lewis on 4/25/2016.
 * When order button is hit... You should create an order obj
 * to put into the database...
 */
public class Order {

    private int id;
    String orderDescription;
    Food food;

    public Order(int id,Food food,String orderDescription)
    {
        this.id = id;
        this.food = food;
        this.orderDescription = orderDescription;
    }

    public Order(int id,String orderDescription)
    {
        this.id = id;
        this.orderDescription = orderDescription;
    }

    public Order(int)
    {

    }


}
