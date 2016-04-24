package src;
/**
 * Created by Nicholas on 4/16/2016.
 */
public class BaconBits extends Decorator
{
    Food pizza;
    public BaconBits(Food pizzaToOrder)
    {
        this.pizza = pizzaToOrder;
    }

    @Override
    public String getDescription()
    {
        return pizza.getDescription() + "with bacon bits  ";
    }

    public double cost()
    {
        return pizza.cost() + .50;
    }
}
