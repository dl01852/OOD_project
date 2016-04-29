package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the burger object of type with a onions object
 *
 * @author Nicholas Lilly
 */
public class Onions extends Decorator
{
    Food burger;
    String name = "Onions";
    double cost = 0;
    String decoratorDescription = "fresh onions";

    public Onions(Food burgerToOrder)
    {
        this.burger = burgerToOrder;
    }

    public Onions(){}

    // gets the description from the burger object and then adds on the description from this class
    @Override
    public String getDescription()
    {

        return burger.getDescription() + " with onions";
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

    // gets the cost from the burger object and then adds on the cost for onions(if there is a cost) and returns that value.
    @Override
    public double cost()
    {
        return burger.cost() + cost;
    }
}