package src;

/**
 * Created by Nicholas on 4/24/2016.
 */
public class Toast extends Decorator
{
    Food ribs;

    public Toast(Food ribsToOrder)
    {
        this.ribs = ribsToOrder;
    }

    @Override
    public String getDescription()
    {
        return ribs.getDescription() + "with texas toast ";
    }

    @Override
    public double cost()
    {
        return ribs.cost();
    }
}
