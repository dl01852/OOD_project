package com.ood.restaurant.Data;

/**
 * Created by Nicholas on 4/26/2016.
 */
public class Coleslaw extends Decorator
{
    Food ribs;
    String name = "Coleslaw";
    double cost = 0;
    String decoratorDescription = "fresh made coleslaw";

    public Coleslaw(Food ribsToOrder)
    {
        this.ribs = ribsToOrder;
    }
    public Coleslaw(){}

    @Override
    public String getDescription()
    {
        return ribs.getDescription() + "with coleslaw ";
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
