package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the burger object of type with a FrenchFries object
 *
 * @author Nicholas Lilly
 */
public class FrenchFries extends Decorator
{
    Food burger;
    String name = "FrenchFries";
    double cost = 0;
    String decoratorDescription = "french fries";

    public FrenchFries(Food burgerToOrder)
    {
        this.burger = burgerToOrder;
    }

    public FrenchFries(){}

    // gets the description from the burger object and then adds on the description from this class
    @Override
    public String getDescription()
    {

        return burger.getDescription() + " and with a side of French Fries";
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

    // gets the cost from the burger object and then adds on the cost for FrenchFries(if there is a cost) and returns that value.
    public double cost()
    {
        return burger.cost();
    }
}
