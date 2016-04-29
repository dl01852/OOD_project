package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the FriedChicken object of type with a MacnCheese object
 *
 * @author Nicholas Lilly
 */
public class MacnCheese extends Decorator
{
    Food friedChicken;
    String name = "MacnCheese";
    double cost = 0;
    String decoratorDescription = "mac n cheese";

    public MacnCheese(Food chickenToOrder)
    {
        this.friedChicken = chickenToOrder;
    }

    public MacnCheese(){}

    // gets the description from the FriedChicken object and then adds on the description from this class
    @Override
    public String getDescription()
    {
        return friedChicken.getDescription() + " with Mac & Cheese";
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

    // gets the cost from the FriedChicken object and then adds on the cost for MacnCheese(if there is a cost) and returns that value.
    public double cost()
    {
        return friedChicken.cost();
    }
}
