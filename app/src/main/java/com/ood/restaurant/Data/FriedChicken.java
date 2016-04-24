package src;

/**
 * Created by Nicholas on 4/24/2016.
 */
public class FriedChicken extends Food
{
    private double cost;

    public FriedChicken()
    {
        FoodName = "Fried Chicken ";
    }
    @Override
    public double cost()
    {
        cost = 10.99;
        return cost;
    }
}
