package com.ood.restaurant.Data;

/**
 * Created by Nicholas on 4/26/2016.
 */
public class CollardGreens
{
    Food friedChicken;
    String name = "Collard greens";
    double cost = 0;
    String decoratorDescription = "Sauteed collard greens";

    public CollardGreens(Food chickenToOrder)
    {
        this.friedChicken = chickenToOrder;
    }

    public CollardGreens(){}

    public String getDescription()
    {

        return friedChicken.getDescription() + "with collard greens ";
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
