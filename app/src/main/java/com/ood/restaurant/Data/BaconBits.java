package com.ood.restaurant.Data;
/**
 * This class provides the methods needed to decorate the pizza object of type with a BaconBits object
 *
 * @author Nicholas Lilly
 */
public class BaconBits extends Decorator
{
    Food pizza;
    String name = "BaconBits";
    double cost = .25;
    String decoratorDescription = "diced bacon bits";

    public BaconBits(Food pizzaToOrder)
    {
        this.pizza = pizzaToOrder;
    }

    public BaconBits(){}

    // gets the description from the pizza object and then adds on the description from this class
    @Override
    public String getDescription()
    {
        return pizza.getDescription() + " with bacon bits";
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

    // gets the cost from the pizza object and then adds on the cost for BaconBits(if there is a cost) and returns that value
    @Override
    public double cost()
    {
        return pizza.cost() + cost;
    }
}
