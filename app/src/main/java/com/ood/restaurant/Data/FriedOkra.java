package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the FriedChicken object of type with a FriedOkra object
 *
 * @author Nicholas Lilly
 */
public class FriedOkra extends Decorator
{
    Food friedChicken;
    String name = "FriedOkra";
    double cost = 0;
    String decoratorDescription = "breaded okra & fried";

    public FriedOkra(Food chickenToOrder)
    {
        this.friedChicken = chickenToOrder;
    }
    public FriedOkra(){}

    // gets the description from the FriedChicken object and then adds on the description from this class
    @Override
    public String getDescription()
    {
        return friedChicken.getDescription() + " with fried okra";
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

    // gets the cost from the FriedChicken object and then adds on the cost for FriedOkra(if there is a cost) and returns that value.
    @Override
    public double cost()
    {
        return friedChicken.cost() + cost;
    }
}
