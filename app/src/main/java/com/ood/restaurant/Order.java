package com.ood.restaurant;

import com.ood.restaurant.Data.Food;

/**
 * Created by david-lewis on 4/25/2016.
 * When order button is hit you should create
 * an order object to put into the database.
 */
public class Order {
    private int id;
    private String orderDescription;
    private Food food;
    private double cost;

    // Constructors
    public Order(int id,String orderDescription, double cost)
    {
        this.id = id;
        this.orderDescription = orderDescription;
        this.cost = cost;
    }
    public Order(){}

    // Setters
    public void setID(int id){this.id = id;}
    public void setOrderDescription(String orderDescription){this.orderDescription = orderDescription;}
    public void setFood(Food food){this.food = food;}
    public void setCost(double cost){this.cost = cost;}

    //getters
    public int getId(){return this.id;}
    public String getOrderDescription(){return this.orderDescription;}
    public Food getFood(){return this.food;}
    public double getCost(){return this.cost;}

}
