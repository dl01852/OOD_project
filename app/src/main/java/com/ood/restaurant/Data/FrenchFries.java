package src;

/**
 * Created by Nicholas on 4/24/2016.
 */
public class FrenchFries extends Decorator
{
    Food burger;

    public FrenchFries(Food burgerToOrder)
    {
        this.burger = burgerToOrder;
    }

    @Override
    public String getDescription()
    {

        return burger.getDescription() + "and with a side of French Fries ";
    }

    public double cost()
    {
        return burger.cost();
    }
}
