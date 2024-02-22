/**
 * Name: Stephen Yang

 * Course: CS-665 Software Designs & Patterns

 * Date: 02/22/2024

 * File Name: Driver.java

 * Description: The class for driver. Driver has attributes as driver name, availability
 * and the order received.
 * Once the driver accepts the order, It will be unavailable and stop receiving new delivery requests.
 * Reverse its availability to true when the delivery is finished. It will start receiving new delivery requests.

 */
package edu.bu.met.cs665;

public class Driver implements SubscriberBase {
    private Integer name; // Driver Name
    private DeliveryRequest order; // delivery request for driver
    public boolean available; // Driver availability
    public Driver(Integer number, Shop shop) {
        this.name = number;
        this.available = true;
        shop.subscribe(this);
        System.out.println("Driver " + this.name);
    }
    /**
     * updateOrder: receive the notification for delivery request
     */
    @Override
    public void updateOrder(DeliveryRequest order, Shop shop) {
        this.order = order;
    }
    /**
     * getOrder: fetch the order the driver received.
     */
    public DeliveryRequest getOrder() {
        return this.order;
    }
    /**
     * getName: fetch the name of the driver.
     */
    public Integer getName() {
        return name;
    }
    /**
     * setAvailable: set the driver's availability
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }
    /**
     * finishDelivery: Finishing delivery request order. Set the availability for driver to true.
     * The driver will re-subscribe to the new notifications.
     */
    public void finishDelivery(Shop shop) {
        this.available = true;
        shop.subscribe(this);
    }
}
