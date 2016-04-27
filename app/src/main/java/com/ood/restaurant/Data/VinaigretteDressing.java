package com.ood.restaurant.Data;

/**
 * Created by Nicholas on 4/26/2016.
 */
public class VinaigretteDressing extends Decorator
{
    Food salad;
    String name = "VinaigretteDressing";
    double cost = 0;
    String decoratorDescription = "vinaigrette dressing";

    public VinaigretteDressing(Food saladToOrder)
    {
        this.salad = saladToOrder;
    }

    public VinaigretteDressing(){}

    @Override
    public String getDescription()
    {

        return salad.getDescription() + " with vinaigrette dressing";
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
        return "Vinaigrette Dressing Added...";
    }
}
