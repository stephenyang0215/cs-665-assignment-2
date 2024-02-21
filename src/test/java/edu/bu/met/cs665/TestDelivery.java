package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Write some Unit tests for your program like the examples below.
 */

public class TestDelivery {


    @Test
    public void testSolution() {

        Shop shop = new Shop();
        for (int i=1; i<6; i++) {
            new Driver(i, shop);
        }
        shop.processOrder("Tim", 688392212, "Chao Mien", "Boston University", "BU102");
        for (Driver driver: shop.getDriverList()) {
            DeliveryRequest order = new DeliveryRequest("Tim", 688392212, "Chao Mien", "Boston University", "BU102");
            assertEquals(order.getName(), driver.getOrder().getName());
            assertEquals(order.getFood(), driver.getOrder().getFood());
            assertEquals(order.getPhoneNumber(), driver.getOrder().getPhoneNumber());
            assertEquals(order.getDestination(), driver.getOrder().getDestination());
            assertEquals(order.getOrderNumber(), driver.getOrder().getOrderNumber());
        }

    }
}
