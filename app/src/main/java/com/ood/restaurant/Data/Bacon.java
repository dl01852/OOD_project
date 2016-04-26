package com.ood.restaurant.Data;
/**
 * Created by Nicholas on 4/16/2016.
 */
public class Bacon extends Decorator
{
    Food burger;
    String name = "Bacon";
    double cost = .50;
    String decoratorDescription = "apple wood smoked bacon";

    public Bacon(Food burgerToOrder)
    {
        this.burger = burgerToOrder;
    }

    public Bacon(){}

    @Override
    public String getDescription()
    {

        return burger.getDescription() + "with bacon ";
        // get the description from the burger object and then add on the description from this class
        // soo for this particular class, the description you'd add is  ' with lettuce'
        // then return that(don't return null).
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
        //return .75;
        return burger.cost() + cost;
        // get the cost from the burger object and then add on the cost for lettuce(if there is a cost) and return that value.
        // (don't return 0)
    }
}