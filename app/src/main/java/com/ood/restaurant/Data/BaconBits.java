package com.ood.restaurant.Data;
/**
 * Created by Nicholas on 4/16/2016.
 */
public class BaconBits extends PizzaDecorator
{
    Food pizza;
    public BaconBits(Food pizzaToOrder)
    {
        this.pizza = pizzaToOrder;
    }
    @Override
    public String getDescription()
    {
        return pizza.getDescription() + "with bacon bits  ";
    }

    @Override
    public double cost()
    {
        return pizza.cost() + .50;
    }

    @Override
    public String orderMessage() {
        return "Bacon Bits Added...";
    }
}
