package com.ood.restaurant.Data;
/**
 * Created by Nicholas on 4/16/2016.
 */
public class Pepperoni extends PizzaDecorator
{
    Food pizza;
    String name = "Pepperoni";
    double cost = 0;
    String decoratorDescription = "cooked pepperoni";

    public Pepperoni(Food pizzaToOrder)
    {
        this.pizza = pizzaToOrder;
    }

    public Pepperoni(){}

    @Override
    public String getDescription()
    {
        return pizza.getDescription() + "with Pepperoni ";
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
