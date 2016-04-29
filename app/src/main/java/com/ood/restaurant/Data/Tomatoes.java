package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the burger object of type with a tomatoes object
 *
 * @author Nicholas Lilly
 */
public class Tomatoes extends Decorator
{
    Food burger;
    String name = "Tomatoes";
    double cost = .25;
    String decoratorDescription = "red succulent tomato";

    public Tomatoes(Food burgerToOrder)
    {
        this.burger = burgerToOrder;
    }
    public Tomatoes(){}

    // gets the description from the burger object and then adds on the description from this class
    @Override
    public String getDescription()
    {

        return burger.getDescription() + " with tomato";
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

    // gets the cost from the burger object and then adds on the cost for tomatoes(if there is a cost) and returns that value.
    @Override
    public double cost()
    {

        return burger.cost() + cost;
    }
}