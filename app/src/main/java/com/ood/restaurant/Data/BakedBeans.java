package src;

/**
 * Created by Nicholas on 4/24/2016.
 */
public class BakedBeans extends Decorator
{
    Food ribs;

    public BakedBeans(Food ribsToOrder)
    {
        this.ribs = ribsToOrder;
    }

    @Override
    public String getDescription()
    {
        return ribs.getDescription() + "with baked beans ";
    }

    @Override
    public double cost()
    {
        return ribs.cost();
    }
}
