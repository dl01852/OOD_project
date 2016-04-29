package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the salad object of type with a VinaigretteDressing object
 *
 * @author Nicholas Lilly
 */
public class VinaigretteDressing extends Decorator
{
    Food salad;
    String name = "VinaigretteDressing";
    double cost = 0;
    String decoratorDescription = "vinaigrette dressing";

    public VinaigretteDressing(Food saladToOrder)
    {
        this.salad = saladToOrder;
    }

    public VinaigretteDressing(){}

    // gets the description from the salad object and then adds on the description from this class
    @Override
    public String getDescription()
    {

        return salad.getDescription() + " with vinaigrette dressing";
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

    // gets the cost from the salad object and then adds on the cost for VinaigretteDressing(if there is a cost) and returns that value.
    @Override
    public double cost()
    {
        return salad.cost() + cost;
    }
}
