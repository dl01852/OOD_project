package com.ood.restaurant.Data;

/**
 * This class provides the methods needed to decorate the FriedChicken object of type with a CollardGreens object
 *
 * @author Nicholas Lilly
 */
public class CollardGreens extends Decorator
{
    Food friedChicken;
    String name = "CollardGreens";
    double cost = 0;
    String decoratorDescription = "Sauteed";

    public CollardGreens(Food chickenToOrder)
    {
        this.friedChicken = chickenToOrder;
    }

    public CollardGreens(){}

    // gets the description from the FriedChicken object and then adds on the description from this class
    public String getDescription()
    {

        return friedChicken.getDescription() + " with collard greens";
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

    // gets the cost from the FriedChicken object and then adds on the cost for CollardGreens(if there is a cost) and returns that value.
    public double cost()
    {
        return friedChicken.cost() + cost;
    }
}
