package com.ood.restaurant.Data;
/**
 * Created by Nicholas on 4/16/2016.
 */
public class Sausage extends PizzaDecorator
{
    Food pizza;

    public Sausage(Food pizzaToOrder)
    {
        this.pizza = pizzaToOrder;
    }
    @Override
    public String getDescription()
    {
        return pizza.getDescription() + "with Sausage ";
    }

    @Override
    public double cost()
    {
        return pizza.cost() + 0;
    }
}
