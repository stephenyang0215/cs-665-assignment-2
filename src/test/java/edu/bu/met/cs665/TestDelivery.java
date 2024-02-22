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

        Shop shop = new Shop();
        for (int i=1; i<6; i++) {
            new Driver(i, shop);
        }
        shop.processOrder("Tim", "688392212", "Chao Mien", "Boston University", "BU102");
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
    * Test the driver receiving delivery request has the correct info of the order.
     */
    public void testSolution2() {
        Shop shop = new Shop();
        for (int i=1; i<6; i++) {
            new Driver(i, shop);
        }
        DeliveryRequest order1 = shop.processOrder("Tim", "688392212", "Chao Mien", "Boston University", "BU222");
        Driver driver2 = shop.getDriverList().get(2);
        driver2.updateOrder(order1, shop);
        assertEquals(order1.getOrderNumber(), driver2.getOrder().getOrderNumber());
    }

    @Test
    /*
    * Two drivers deliver orders consecutively. Then the first driver finished delivery and
    * reverse to available. Test the number of the available drivers as expected.
     */
    public void testSolution3() {
        Shop shop = new Shop();
        for (int i=1; i<6; i++) {
            new Driver(i, shop);
        }
        System.out.println("All the available drivers:");
        //Display the names for all the available drivers
        shop.getDriverList();
        DeliveryRequest order1 = shop.processOrder("Tim", "688392212", "Chao Mien", "Boston University", "BU102");

        Driver driver1 = shop.driverList.remove(0);
        System.out.println("Driver " + driver1.getName() + " accept the order " + order1.getOrderNumber());

        DeliveryRequest order2 = shop.processOrder("Jenny", "657757838", "Pizza", "NorthEastern University", "NEU111");
        Driver driver2 = shop.driverList.remove(0);
        System.out.println("Driver " + driver2.getName() + " accept the order " + order2.getOrderNumber());
        driver2.updateOrder(order2, shop);

        driver1.finishDelivery(shop);
        assertEquals(4, shop.driverList.size());
    }
}
