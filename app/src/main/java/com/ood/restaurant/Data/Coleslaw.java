package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the BBQRibs object of type with a Coleslaw object
 *
 * @author Nicholas Lilly
 */
public class Coleslaw extends Decorator
{
    Food ribs;
    String name = "Coleslaw";
    double cost = 0;
    String decoratorDescription = "fresh made coleslaw";

    public Coleslaw(Food ribsToOrder)
    {
        this.ribs = ribsToOrder;
    }
    public Coleslaw(){}

    // gets the description from the BBQRibs object and then adds on the description from this class
    @Override
    public String getDescription()
    {
        return ribs.getDescription() + " with coleslaw";
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

    // gets the cost from the BBQRibs object and then adds on the cost for Coleslaw(if there is a cost) and returns that value.
    @Override
    public double cost()
    {
        return ribs.cost() + cost;
    }
}
