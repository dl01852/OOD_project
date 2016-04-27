package com.ood.restaurant.Data;

/**
 * Created by Nicholas on 4/26/2016.
 */
public class FriedOkra extends Decorator
{
    Food friedChicken;
    String name = "FriedOkra";
    double cost = 0;
    String decoratorDescription = "breaded okra and fried";

    public FriedOkra(Food chickenToOrder)
    {
        this.friedChicken = chickenToOrder;
    }

    @Override
    public String getDescription()
    {
        return friedChicken.getDescription() + "with fried okra ";
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
        return friedChicken.cost();
    }

    @Override
    public String orderMessage() {
        return "Frid Okra Added...";
    }
}
