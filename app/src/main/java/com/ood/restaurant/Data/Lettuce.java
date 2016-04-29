package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the burger object of type with a lettuce object
 *
 * @author Nicholas Lilly
 */

public class Lettuce extends Decorator
{
    Food burger;
    String name = "Lettuce";
    double cost = 0;
    String decoratorDescription = "fresh lettuce";

    public Lettuce(Food burgerToOrder)
    {
        this.burger = burgerToOrder;
    }
    public Lettuce(){}

    // gets the description from the burger object and then adds on the description from this class
    @Override
    public String getDescription()
    {

        return burger.getDescription() + " with lettuce";
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

    // gets the cost from the burger object and then adds on the cost for lettuce(if there is a cost) and returns that value.
    @Override
    public double cost()
    {
        return burger.cost() + cost;
    }
}
