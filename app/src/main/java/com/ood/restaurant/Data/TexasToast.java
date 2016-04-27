package com.ood.restaurant.Data;

/**
 * Created by Nicholas on 4/26/2016.
 */
public class TexasToast extends Decorator
{
    Food ribs;
    String name = "TexasToast";
    double cost = 0;
    String decoratorDescription = "Delicious";

    public TexasToast(Food ribsToOrder)
    {
        this.ribs = ribsToOrder;
    }

    public TexasToast(){}

    @Override
    public String getDescription()
    {
        return ribs.getDescription() + " with texas toast ";
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
        return ribs.cost();
    }

    @Override
    public String orderMessage() {
        return "Texas Toast Added...";
    }
}
