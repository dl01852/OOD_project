package com.ood.restaurant.Data;

/**
 * Created by Nicholas on 4/26/2016.
 */
public class CaesarDressing extends Decorator
{
    Food salad;
    String name = "CaesarDressing";
    double cost = 0;
    String decoratorDescription = "caesar dressing";

    public CaesarDressing(Food saladToOrder)
    {
        this.salad = saladToOrder;
    }

    public CaesarDressing(){}

    @Override
    public String getDescription()
    {

        return salad.getDescription() + " with caesar dressing";
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
        return salad.cost() + cost;
    }
}
