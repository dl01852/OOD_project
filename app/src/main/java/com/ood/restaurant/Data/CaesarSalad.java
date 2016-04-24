package src;

/**
 * Created by Nicholas on 4/24/2016.
 */
public class CaesarSalad extends Food
{
    private double cost;
    public CaesarSalad()
    {
        FoodName = "Caesar Salad";
    }
    @Override
    public double cost()
    {
        cost = 4.99;
        return cost;
    }
}
