package com.ood.restaurant;

import junit.framework.TestCase;
import com.ood.restaurant.Data.*;

/**
 * StaticData Testing
 * @author Michael Palmer
 */
public class StaticDataTest extends TestCase {
    public void testInstance() {
        assertNotNull(StaticData.i());
    }

    public void testTableInitialized() {
        assertEquals(15, StaticData.i().tables().size());
    }

    public void testMenuInitialized() {
        assertTrue(StaticData.i().getMenu().contains(Pizza.class));
    }

    public void testDecoratorsInitialized() {
        assertTrue(StaticData.i().getItemDecorators().containsKey(Burger.class));
    }
}
