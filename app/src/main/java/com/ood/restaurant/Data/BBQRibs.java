package com.ood.restaurant.Data;

/**
 * Created by Nicholas on 4/26/2016.
 */
public class BBQRibs extends Food
{
    private double cost;

    public BBQRibs()
    {
        FoodName = "Full rack of ribs";
    }
    @Override
    public double cost()
    {
        cost = 19.95;
        return cost;
    }
}
