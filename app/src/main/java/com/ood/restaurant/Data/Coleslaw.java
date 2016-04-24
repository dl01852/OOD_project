package src;

/**
 * Created by Nicholas on 4/24/2016.
 */
public class Coleslaw extends Decorator
{
    Food ribs;

    public Coleslaw(Food ribsToOrder)
    {
        this.ribs = ribsToOrder;
    }

    @Override
    public String getDescription()
    {
        return ribs.getDescription() + "with coleslaw ";
    }

    @Override
    public double cost()
    {
        return ribs.cost();
    }
}
