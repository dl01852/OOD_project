package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the salad object of type with a ItalianDressing object
 *
 * @author Nicholas Lilly
 */
public class ItalianDressing extends Decorator
{
    Food salad;
    String name = "ItalianDressing";
    double cost = 0;
    String decoratorDescription = "italian dressing";

    public ItalianDressing(Food saladToOrder)
    {
        this.salad = saladToOrder;
    }

    public ItalianDressing(){}

    // gets the description from the salad object and then adds on the description from this class
    public String getDescription()
    {

        return salad.getDescription() + " with italian dressing";
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

    // gets the cost from the salad object and then adds on the cost for ItalianDressing(if there is a cost) and returns that value.
    public double cost()
    {
        return salad.cost() + cost;
    }
}
