package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the BBQRibs object of type with a BakedBeans object
 *
 * @author Nicholas Lilly
 */
public class BakedBeans extends Decorator
{
    Food ribs;
    String name = "BakedBeans";
    double cost = 0;
    String decoratorDescription = "oven baked beans";

    public BakedBeans(Food ribsToOrder)
    {
        this.ribs = ribsToOrder;
    }

    public BakedBeans(){}

    // gets the description from the BBQRibs object and then adds on the description from this class
    @Override
    public String getDescription()
    {
        return ribs.getDescription() + " with baked beans";
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

    // gets the cost from the BBQRibs object and then adds on the cost for baked beans(if there is a cost) and returns that value.
    @Override
    public double cost()
    {
        return ribs.cost() + cost;
    }
}
