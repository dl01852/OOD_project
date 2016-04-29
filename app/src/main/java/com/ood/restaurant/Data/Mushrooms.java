package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the pizza object of type with a mushrooms object
 *
 * @author Nicholas Lilly
 */
public class Mushrooms extends Decorator
{
    Food pizza;
    String name = "Mushrooms";
    double cost = 0;
    String decoratorDescription = "fresh mushrooms";

    public Mushrooms(Food pizzaToOrder)
    {
        this.pizza = pizzaToOrder;
    }

    public Mushrooms(){}

    // gets the description from the pizza object and then adds on the description from this class
    @Override
    public String getDescription()
    {
        return pizza.getDescription() + " with mushrooms";
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

    // gets the cost from the pizza object and then adds on the cost for mushrooms(if there is a cost) and returns that value.
    @Override
    public double cost()
    {
        return pizza.cost() + cost;
    }
}
