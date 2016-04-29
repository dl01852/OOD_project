package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the burger object of type with a bacon object
 *
 * @author Nicholas Lilly
 */
public class Bacon extends Decorator
{
    Food burger;
    String name = "Bacon";
    double cost = .50;
    String decoratorDescription = "smoked bacon";

    public Bacon(Food burgerToOrder)
    {
        this.burger = burgerToOrder;
    }

    public Bacon(){}

    // gets the description from the burger object and then adds on the description from this class
    @Override
    public String getDescription()
    {

        return burger.getDescription() + " with bacon";
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

    // gets the cost from the burger object and then adds on the cost for bacon(if there is a cost) and returns that value.
    @Override
    public double cost()
    {
        return burger.cost() + cost;
    }
}