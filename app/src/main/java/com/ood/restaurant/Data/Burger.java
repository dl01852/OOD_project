package src;
/**
 * Created by david-lewis on 3/28/2016.
 *
 * Burger class, is the component of the abstract Beverage class.
 */

public class Burger extends Food
{

    private double cost;
    public Burger()
    {
        FoodName = "Burger ";
    }


    @Override
    public double cost()
    {
        cost = 10.99;
        // set the cost, any price. idc
        // then return the cost.
        return cost;
    }
}
