package com.ood.restaurant.Data;

/**
 *
 * @author Nicholas Lilly
 */
public class BBQRibs extends Food
{
    private double cost;

    public BBQRibs()
    {
        FoodName = "BBQRibs";
    }
    @Override
    public double cost()
    {
        cost = 19.95;
        return cost;
    }
}
