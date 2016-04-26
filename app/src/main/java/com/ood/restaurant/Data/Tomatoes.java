package com.ood.restaurant.Data;
/**
 * Created by Nicholas on 4/16/2016.
 */
public class Tomatoes extends Decorator
{
    Food burger;
    String name = "Tomatoes";
    double cost = .25;

    public Tomatoes(Food burgerToOrder)
    {
        this.burger = burgerToOrder;
    }
    public Tomatoes(){}

    @Override
    public String getDescription()
    {

        return burger.getDescription() + "with tomato ";
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


    @Override
    public double cost()
    {

        return burger.cost() + cost;
        // get the cost from the burger object and then add on the cost for lettuce(if there is a cost) and return that value.
        // (don't return 0)
    }

    @Override
    public String orderMessage() {
        return "Tomatoes Added...";
    }
}