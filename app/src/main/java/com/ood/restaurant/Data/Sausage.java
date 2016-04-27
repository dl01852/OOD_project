package com.ood.restaurant.Data;
/**
 * Created by Nicholas on 4/16/2016.
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

    @Override
    public double cost()
    {
        return pizza.cost() + cost;
    }
}
