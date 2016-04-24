package com.ood.restaurant.Data;
/**
 * Created by Nicholas on 4/16/2016.
 */
public class Bacon extends BurgerDecorator
{
    Food burger;

    public Bacon(Food burgerToOrder)
    {
        this.burger = burgerToOrder;
    }

    @Override
    public String getDescription()
    {

        return burger.getDescription() + "with bacon ";
        // get the description from the burger object and then add on the description from this class
        // soo for this particular class, the description you'd add is  ' with lettuce'
        // then return that(don't return null).
    }

    @Override
    public double cost()
    {
        //return .75;
        return burger.cost() + .75;
        // get the cost from the burger object and then add on the cost for lettuce(if there is a cost) and return that value.
        // (don't return 0)
    }
}