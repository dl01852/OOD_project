package com.ood.restaurant.Data;
/**
 * Created by Nicholas on 4/16/2016.
 */
public class BaconBits extends PizzaDecorator
{
    Food pizza;
    String name = "Bacon Bits";
    double cost = .25;
    String decoratorDescription = "cooked bacon";

    public BaconBits(Food pizzaToOrder)
    {
        this.pizza = pizzaToOrder;
    }

    public BaconBits(){}

    @Override
    public String getDescription()
    {
        return pizza.getDescription() + "with bacon bits  ";
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
}
