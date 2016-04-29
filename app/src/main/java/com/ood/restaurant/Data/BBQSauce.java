package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the BBQRibs object of type with a BBQSauce object
 *
 * @author Nicholas Lilly
 */
public class BBQSauce extends Decorator
{
    Food ribs;
    String name = "BBQSauce";
    double cost = 0;
    String decoratorDescription = "BBQ sauce";

    public BBQSauce(Food ribsToOrder)
    {
        this.ribs = ribsToOrder;
    }

    public BBQSauce(){}

    // gets the description from the BBQRibs object and then adds on the description from this class
    public String getDescription()
    {

        return ribs.getDescription() + " with bbq sauce";
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

    // gets the cost from the BBQRibs object and then adds on the cost for BBQSauce(if there is a cost) and returns that value.
    public double cost()
    {
        return ribs.cost() + cost;
    }
}
