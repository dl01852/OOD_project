package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the BBQRibs object of type with a TexasToast object
 *
 * @author Nicholas Lilly
 */
public class TexasToast extends Decorator
{
    Food ribs;
    String name = "TexasToast";
    double cost = 0;
    String decoratorDescription = "Delicious";

    public TexasToast(Food ribsToOrder)
    {
        this.ribs = ribsToOrder;
    }

    public TexasToast(){}

    // gets the description from the BBQRibs object and then adds on the description from this class
    @Override
    public String getDescription()
    {
        return ribs.getDescription() + " with texas toast";
    }

    public String getName()
    {
        return name;
    }

    public double getCost()
    {
        return cost;
    }

    public String getDecoratorDescription()
    {
        return decoratorDescription;
    }

    // gets the cost from the BBQRibs object and then adds on the cost for TexasToast(if there is a cost) and returns that value.
    @Override
    public double cost()
    {
        return ribs.cost();
    }
}
