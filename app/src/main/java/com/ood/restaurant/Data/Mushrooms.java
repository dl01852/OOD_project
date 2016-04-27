package com.ood.restaurant.Data;
/**
 * Created by Nicholas on 4/16/2016.
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

    @Override
    public String getDescription()
    {
        return pizza.getDescription() + " with mushrooms ";
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
        return "Mushrooms Added...";
    }
}
