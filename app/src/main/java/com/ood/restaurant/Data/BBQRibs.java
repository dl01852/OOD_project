package src;

/**
 * Created by Nicholas on 4/24/2016.
 */
public class BBQRibs extends Food
{
    private double cost;

    public BBQRibs()
    {
        FoodName = "Full rack of ribs ";
    }
    @Override
    public double cost()
    {
        cost = 19.95;
        return cost;
    }
}
