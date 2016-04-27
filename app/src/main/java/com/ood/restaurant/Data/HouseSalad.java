package com.ood.restaurant.Data;

/**
 * Created by Nicholas on 4/26/2016.
 */
public class HouseSalad extends Food
{
    private double cost;
    public HouseSalad()
    {
        FoodName = "HouseSalad";
    }
    @Override
    public double cost()
    {
        cost = 4.99;

        return cost;
    }

    @Override
    public String orderMessage() {
        return "House Salad Added...";
    }
}
