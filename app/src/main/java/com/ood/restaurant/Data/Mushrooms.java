package src;
/**
 * Created by Nicholas on 4/16/2016.
 */
public class Mushrooms extends Decorator
{
    Food pizza;

    public Mushrooms(Food pizzaToOrder)
    {
        this.pizza = pizzaToOrder;
    }
    @Override
    public String getDescription()
    {
        return pizza.getDescription() + "with mushrooms ";
    }

    public double cost()
    {
        return pizza.cost() + 0;
    }
}
