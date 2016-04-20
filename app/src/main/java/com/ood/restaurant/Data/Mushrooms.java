package com.ood.restaurant.Data;
/**
 * Created by Nicholas on 4/16/2016.
 */
public class Mushrooms extends PizzaDecorator
{
    Food pizza;

    public Mushrooms(Food pizzaToOrder)
    {
        this.pizza = pizzaToOrder;
    }
    @Override
    public String getDescription()
    {
        return pizza.getDescription() + "with mushrooms ";
    }

    @Override
    public double cost()
    {
        return pizza.cost() + 0;
    }
}
