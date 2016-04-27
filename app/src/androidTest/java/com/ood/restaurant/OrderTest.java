package com.ood.restaurant;

import com.ood.restaurant.Data.Burger;
import com.ood.restaurant.Data.Food;
import junit.framework.TestCase;

/**
 * Created by Archer on 4/27/16.
 */
public class OrderTest extends TestCase {
    public void testID() throws Exception {
        Order order = new Order();
        order.setID(1);
        assertEquals(true, order.getId() == 1);
    }

    public void testDescription() throws Exception {
        Order order = new Order();
        order.setOrderDescription("Pizza");
        assertEquals(true, order.getOrderDescription().equals("Pizza"));
    }

    public void testFood() throws Exception {
        Order order = new Order();
        Burger burger = new Burger();
        order.setFood(burger);
        assertEquals(true, order.getFood() == burger);
    }
}