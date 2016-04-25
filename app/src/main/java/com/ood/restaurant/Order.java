package com.ood.restaurant;

import com.ood.restaurant.Data.Food;

/**
 * Created by david-lewis on 4/25/2016.
 * When order button is hit... You should create an order obj
 * to put into the database...
 */
public class Order {

    private int id;
    private String orderDescription;
    private Food food;

    // An assload of constructors cause i don't know which ones i'll need yet lol
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

    public Order(int id, Food food)
    {
        this.id = id;
        this.food = food;
        this.orderDescription = food.getDescription();
    }
    public Order(){}


    // Setters
    public void setID(int id){this.id = id;}
    public void setOrderDescription(String orderDescription){this.orderDescription = orderDescription;}
    public void setFood(Food food){this.food = food;}

    //getters
    public int getId(){return this.id;}
    public String getOrderDescription(){return this.orderDescription;}
    public Food getFood(){return this.food;}

}
