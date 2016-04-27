package com.ood.restaurant.Data;

/**
 * Created by Nicholas on 4/26/2016.
 */
public class BakedBeans extends Decorator
{
    Food ribs;
    String name = "BakedBeans";
    double cost = 0;
    String decoratorDescription = "oven baked beans";

    public BakedBeans(Food ribsToOrder)
    {
        this.ribs = ribsToOrder;
    }

    public BakedBeans(){}

    @Override
    public String getDescription()
    {
        return ribs.getDescription() + "with baked beans ";
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
}
