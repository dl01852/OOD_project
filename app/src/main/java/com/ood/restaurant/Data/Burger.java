package com.ood.restaurant.Data;

/**
 *
 * @author Nicholas Lilly
 */
public class Burger extends Food
{

    private double cost;
    public Burger()
    {
        FoodName = "Burger";
    }


    @Override
    public double cost()
    {
        cost = 5.99;
        return cost;
    }
}
