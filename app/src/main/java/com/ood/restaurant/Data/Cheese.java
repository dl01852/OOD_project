package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the burger object of type with a cheese object
 *
 * @author Nicholas Lilly
 */
public class Cheese extends Decorator
{
    Food food;
    String name = "Cheese";
    double cost = .25;
    String decoratorDescription = "cheddar cheese";

    public Cheese(Food foodToOrder)
    {
        this.food = foodToOrder;
    }

    public Cheese(){}

    // gets the description from the burger object and then adds on the description from this class
    @Override
    public String getDescription()
    {
        return food.getDescription() + " with cheese";
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

    // gets the cost from the burger object and then adds on the cost for cheese(if there is a cost) and returns that value.
    @Override
    public double cost()
    {
        return food.cost() + cost;
    }

}
