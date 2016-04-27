package com.ood.restaurant.Data;

/**
 * Created by Nicholas on 4/26/2016.
 */
public class RanchDressing extends Decorator
{
    Food salad;
    String name = "RanchDressing";
    double cost = 0;
    String decoratorDescription = "ranch dressing";

    public RanchDressing(Food saladToOrder)
    {
        this.salad = saladToOrder;
    }

    public RanchDressing(){}

    @Override
    public String getDescription()
    {

        return salad.getDescription() + " with ranch dressing";
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

    @Override
    public String orderMessage() {
        return "Ranch Dressing Added...";
    }
}
