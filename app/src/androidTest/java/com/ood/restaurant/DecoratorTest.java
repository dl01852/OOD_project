package com.ood.restaurant;

import com.ood.restaurant.Data.*;
import junit.framework.TestCase;

/**
 * Testing decorators
 * @author Michael Palmer
 */
public class DecoratorTest extends TestCase {
    public void testPizza() {
        Food pizza = new Pizza();
        assertEquals("Pizza", pizza.getDescription());
    }

    public void testCheesePizza() {
        Food pizza = new Pizza();
        pizza = new Cheese(pizza);
        assertEquals("Pizza with cheese", pizza.getDescription());
    }

    public void testSausagePepperoniPizza() {
        Food pizza = new Pizza();
        pizza = new Sausage(pizza);
        pizza = new Pepperoni(pizza);
        assertEquals("Pizza with Sausage with Pepperoni", pizza.getDescription());
    }

    public void testBurger() {
        Food burger = new Burger();
        assertEquals("Burger", burger.getDescription());
    }

    public void testCheeseburger() {
        Food burger = new Burger();
        burger = new Cheese(burger);
        assertEquals("Burger with cheese", burger.getDescription());
    }

    public void testBurgerBLT() {
        Food burger = new Burger();
        burger = new Bacon(burger);
        burger = new Lettuce(burger);
        burger = new Tomatoes(burger);
        assertEquals("Burger with bacon with lettuce with tomato", burger.getDescription());
    }
}
