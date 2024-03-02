package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Write the Unit tests for the program
 */

public class TestDelivery {

    /*
    *Upon receiving the order from the shop, all the available drivers should be notified the same message
     */
    @Test
    public void testSolution1() {
        //Initialize a shop
        Shop shop = new Shop();
        // Initialize 5 drivers
        for (int i=1; i<6; i++) {
            new Driver(i, shop);
        }
        // run delivery request
        shop.processOrder("Tim", "688392212", "Chao Mien", "Boston University", "BU102");
        // Iterate over each available driver and check each one has the correct information of the order
        for (Driver driver: shop.getDriverList()) {
            DeliveryRequest order = new DeliveryRequest("Tim", "688392212", "Chao Mien", "Boston University", "BU102");
            assertEquals(order.getName(), driver.getOrder().getName());
            assertEquals(order.getFood(), driver.getOrder().getFood());
            assertEquals(order.getPhoneNumber(), driver.getOrder().getPhoneNumber());
            assertEquals(order.getDestination(), driver.getOrder().getDestination());
            assertEquals(order.getOrderNumber(), driver.getOrder().getOrderNumber());
        }
    }

    @Test
    /*
    * Test the driver 2 receiving delivery request has the correct information of the order.
     */
    public void testSolution2() {
        Shop shop = new Shop(); //Initialize a shop
        // Initialize 5 drivers
        for (int i=1; i<6; i++) {
            new Driver(i, shop);
        }
        // run delivery request
        DeliveryRequest order1 = shop.processOrder("Tim", "688392212", "Chao Mien", "Boston University", "BU222");
        // Use driver 2 to accept the order
        Driver driver2 = shop.getDriverList().get(2);
        driver2.updateOrder(order1, shop);
        assertEquals(order1.getOrderNumber(), driver2.getOrder().getOrderNumber());
    }

    @Test
    /*
    * Test the number of the available drivers at the points of two drivers run orders consecutively.
     */
    public void testSolution3() {
        Shop shop = new Shop();//Initialize a shop
        // Initialize 5 drivers
        for (int i=1; i<6; i++) {
            new Driver(i, shop);
        }
        System.out.println("All the available drivers:");
        //Display the names for all the available drivers
        shop.getDriverList();
        // run delivery request
        DeliveryRequest order1 = shop.processOrder("Tim", "688392212", "Chao Mien", "Boston University", "BU102");
        // pick driver 1 to take the request
        Driver driver1 = shop.driverList.remove(0);
        System.out.println("Driver " + driver1.getName() + " accept the order " + order1.getOrderNumber());
        // Test the driver list has dropped driver 1
        assertEquals(4, shop.driverList.size());

        // run delivery request
        DeliveryRequest order2 = shop.processOrder("Jenny", "657757838", "Pizza", "NorthEastern University", "NEU111");
        // pick driver 2 to take the request
        Driver driver2 = shop.driverList.remove(0);
        System.out.println("Driver " + driver2.getName() + " accept the order " + order2.getOrderNumber());
        driver2.updateOrder(order2, shop);
        // Test the driver list has dropped driver 2
        assertEquals(3, shop.driverList.size());
        // Driver 1 has finished the request and become available again
        driver1.finishDelivery(shop);
        assertEquals(4, shop.driverList.size());
    }
}
