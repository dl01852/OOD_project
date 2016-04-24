package src;

/**
 * Created by Nicholas on 4/24/2016.
 */
public class FriedOkra extends Decorator
{
    Food friedChicken;

    public FriedOkra(Food chickenToOrder)
    {
        this.friedChicken = chickenToOrder;
    }

    @Override
    public String getDescription()
    {
        return friedChicken.getDescription() + "with fried okra ";
    }

    @Override
    public double cost()
    {
        return friedChicken.cost();
    }
}
