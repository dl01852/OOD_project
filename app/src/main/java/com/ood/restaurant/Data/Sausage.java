package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the pizza object of type with a Sausage object
 *
 * @author Nicholas Lilly
 */
public class Sausage extends Decorator
{
    Food pizza;
    String name = "Sausage";
    double cost = .25;
    String decoratorDescription = "cooked sausage";

    public Sausage(Food pizzaToOrder)
    {
        this.pizza = pizzaToOrder;
    }

    public Sausage(){}

    // gets the description from the pizza object and then adds on the description from this class
    @Override
    public String getDescription()
    {
        return pizza.getDescription() + " with Sausage";
    }

    public String getName()
    {
        return name;
    }

    public double getCost()
    {
        return cost;
    }

    public String getDecoratorDescription(){return decoratorDescription;}

    // gets the cost from the pizza object and then adds on the cost for sausage(if there is a cost) and returns that value.
    @Override
    public double cost()
    {
        return pizza.cost() + cost;
    }
}
