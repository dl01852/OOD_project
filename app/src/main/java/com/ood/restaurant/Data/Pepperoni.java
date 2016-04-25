package com.ood.restaurant.Data;
/**
 * Created by Nicholas on 4/16/2016.
 */
public class Pepperoni extends Decorator
{
    Food pizza;
    String name = "Pepperoni";
    double cost = .10;
    String decoratorDescription = "Nice round piece of Salami";

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
    @Override
    public String getDescription()
    {
        return pizza.getDescription() + "with Pepperoni ";
    }

    @Override
    public double cost()
    {
        return pizza.cost() + 0;
    }
}
