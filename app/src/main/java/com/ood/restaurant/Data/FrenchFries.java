package com.ood.restaurant.Data;

/**
 * Created by Nicholas on 4/26/2016.
 */
public class FrenchFries extends Decorator
{
    Food burger;
    String name = "FrenchFries";
    double cost = 0;
    String decoratorDescription = "french fries";

    public FrenchFries(Food burgerToOrder)
    {
        this.burger = burgerToOrder;
    }

    public FrenchFries(){}

    @Override
    public String getDescription()
    {

        return burger.getDescription() + " and with a side of French Fries ";
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

    public double cost()
    {
        return burger.cost();
    }
}
