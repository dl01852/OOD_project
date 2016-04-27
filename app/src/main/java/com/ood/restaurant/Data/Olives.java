package com.ood.restaurant.Data;
/**
 * Created by Nicholas on 4/16/2016.
 */
public class Olives extends Decorator
{
    Food pizza;
    String name = "Olives";
    double cost = 0;
    String decoratorDescription = "fresh olives";

    public Olives(Food pizzaToOrder)
    {
        this.pizza = pizzaToOrder;
    }

    public Olives(){}

    @Override
    public String getDescription()
    {
        return pizza.getDescription() + "with Olives ";
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

    @Override
    public double cost()
    {
        return pizza.cost() + cost;
    }

    @Override
    public String orderMessage() {
        return "Olives Added...";
    }
}
