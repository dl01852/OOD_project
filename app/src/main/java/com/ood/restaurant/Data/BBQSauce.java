package com.ood.restaurant.Data;

/**
 * Created by Nicholas on 4/26/2016.
 */
public class BBQSauce extends Decorator
{
    Food ribs;
    String name = "BBQSauce";
    double cost = 0;
    String decoratorDescription = "BBQ sauce";

    public BBQSauce(Food ribsToOrder)
    {
        this.ribs = ribsToOrder;
    }

    public BBQSauce(){}


    public String getDescription()
    {

        return ribs.getDescription() + " with bbq sauce";
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
        return ribs.cost() + cost;
    }
}
