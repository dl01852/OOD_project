package com.ood.restaurant.Data;

/**
 * Created by Nicholas on 4/26/2016.
 */
public class MacnCheese extends Decorator
{
    Food friedChicken;
    String name = "MacnCheese";
    double cost = 0;
    String decoratorDescription = "mac n cheese";

    public MacnCheese(Food chickenToOrder)
    {
        this.friedChicken = chickenToOrder;
    }

    public MacnCheese(){}

    @Override
    public String getDescription()
    {
        return friedChicken.getDescription() + " with Mac & Cheese ";
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
        return friedChicken.cost();
    }
}
