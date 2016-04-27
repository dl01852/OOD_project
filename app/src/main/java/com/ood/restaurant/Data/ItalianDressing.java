package com.ood.restaurant.Data;

/**
 * Created by Nicholas on 4/26/2016.
 */
public class ItalianDressing extends Decorator
{
    Food salad;
    String name = "ItalianDressing";
    double cost = 0;
    String decoratorDescription = "italian dressing";

    public ItalianDressing(Food saladToOrder)
    {
        this.salad = saladToOrder;
    }

    public ItalianDressing(){}


    public String getDescription()
    {

        return salad.getDescription() + " with italian dressing";
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
        return salad.cost() + cost;
    }
}
