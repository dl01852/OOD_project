package com.ood.restaurant.Data;

/**
 * Created by Nicholas on 4/26/2016.
 */
public class CaesarSalad extends Food
{
    private double cost;
    public CaesarSalad()
    {
        FoodName = "CaesarSalad";
    }
    @Override
    public double cost()
    {
        cost = 4.99;
        return cost;
    }
}
