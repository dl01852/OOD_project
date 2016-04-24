package src;

/**
 * Created by Nicholas on 4/24/2016.
 */
public class CollardGreens extends Decorator
{
    Food friedChicken;

    public CollardGreens(Food chickenToOrder)
    {
        this.friedChicken = chickenToOrder;
    }

    @Override
    public String getDescription()
    {

        return friedChicken.getDescription() + "with collard greens ";
        // get the description from the burger object and then add on the description from this class
        // soo for this particular class, the description you'd add is  ' with lettuce'
        // then return that(don't return null).
    }

    public double cost()
    {
        return friedChicken.cost();
        // get the cost from the burger object and then add on the cost for lettuce(if there is a cost) and return that value.
        // (don't return 0)
    }
}
