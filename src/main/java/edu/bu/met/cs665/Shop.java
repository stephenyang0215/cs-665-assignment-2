/**
 * Name: Stephen Yang

 * Course: CS-665 Software Designs & Patterns

 * Date: 02/22/2024

 * File Name: Shop.java

 * Description: The class for the shop to organize food delivery orders and drivers .
 * The shop can send notification to all available drivers upon receiving the delivery order.

 */
package edu.bu.met.cs665;
import java.util.ArrayList;

public class Shop implements PublisherBase{
    public ArrayList<Driver> driverList;

    public Shop() {
        this.driverList = new ArrayList<>();
    }

    /**
     * processOrder: creates new order for the shop.
     * Then notify all the available drivers.
     */
    public DeliveryRequest processOrder(String name, String phoneNumber, String food, String destination, String orderNumber) {
        DeliveryRequest order = new DeliveryRequest(name, phoneNumber, food, destination, orderNumber);
        notifySubscribers(order, this);
        return order;
    }
    /**
     * subscribe: Allows observer to subscribe to the publisher.
     */
    @Override
    public void subscribe(Driver driver) {
        this.driverList.add(driver);
    }
    /**
     * unsubscribe: Allows observer to unsubscribe from the publisher.
     */
    @Override
    public void unsubscribe(Driver driver) {
        this.driverList.remove(driver);
    }
    /**
     * notifySubscribers: Send the food order notification to all the available observers.
     */
    @Override
    public void notifySubscribers(DeliveryRequest order, Shop shop) {
        for (Driver driver: this.driverList) {
            driver.updateOrder(order, shop);
        }
    }
    /**
     * getDriverList: fetch all the available drivers.
     */
    public ArrayList<Driver> getDriverList() {
        return this.driverList;
    }
    /**
     * addDriverList: Add the driver to the available driver list.
     */
    public void addDriverList(Driver driver) {
        this.driverList.add(driver);
    }

}
