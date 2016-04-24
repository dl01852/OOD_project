package src;

/**
 * Created by Nicholas on 4/24/2016.
 */
public class HouseSalad extends Food
{
    private double cost;
    public HouseSalad()
    {
        FoodName = "House Salad";
    }
    @Override
    public double cost()
    {
        cost = 4.99;

        return cost;
    }
}
