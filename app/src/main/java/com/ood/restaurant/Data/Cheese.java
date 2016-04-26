package com.ood.restaurant.Data;
/**
 * Created by Nicholas on 4/16/2016.
 */
public class Cheese extends Decorator
{
    Food burger;
    String name = "Cheese";
    double cost = .25;
    String decoratorDescription = "cheddar cheese";

    public Cheese(Food burgerToOrder)
    {
        this.burger = burgerToOrder;
    }

    public Cheese(){}

    @Override
    public String getDescription()
    {

        return burger.getDescription() + " with cheese ";
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
        //return .25;
        return burger.cost() + cost;
        // get the cost from the burger object and then add on the cost for lettuce(if there is a cost) and return that value.
        // (don't return 0)
    }
}
