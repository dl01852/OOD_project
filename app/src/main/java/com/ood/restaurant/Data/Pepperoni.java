package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the pizza object of type with a Pepperoni object
 *
 * @author Nicholas Lilly
 */
public class Pepperoni extends Decorator
{
    Food pizza;
    String name = "Pepperoni";
    double cost = .10;
    String decoratorDescription = "piece of Salami";

    public Pepperoni(){}
    public Pepperoni(Food pizzaToOrder)
    {
        this.pizza = pizzaToOrder;
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

    // gets the description from the pizza object and then adds on the description from this class
    @Override
    public String getDescription()
    {
        return pizza.getDescription() + " with Pepperoni";
    }

    // gets the cost from the pizza object and then adds on the cost for pepperoni(if there is a cost) and returns that value.
    @Override
    public double cost()
    {
        return pizza.cost() + cost;
    }
}
