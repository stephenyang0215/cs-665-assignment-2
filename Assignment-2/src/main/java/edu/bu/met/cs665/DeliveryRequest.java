/**
 * Name: Stephen Yang

 * Course: CS-665 Software Designs & Patterns

 * Date: 02/22/2024

 * File Name: DeliveryRequest.java

 * Description: The class for delivery request with its order information as attributes.

 */
package edu.bu.met.cs665;

public class DeliveryRequest {
    private String name;
    private String phoneNumber;
    private String food;
    private String destination;
    private String orderNumber;

    public DeliveryRequest(String name, String phoneNumber, String food, String destination, String orderNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.food = food;
        this.destination = destination;
        this.orderNumber = orderNumber;
    }
    /**
     * getName: fetch the name of the order.
     */
    public String getName() {
        return this.name;
    }
    /**
     * getPhoneNumber: fetch the phone number of the order.
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    /**
     * getFood: fetch the food of the order.
     */
    public String getFood() {
        return this.food;
    }
    /**
     * getDestination: fetch the destination of the order.
     */
    public String getDestination() {
        return this.destination;
    }
    /**
     * getOrderNumber: fetch the order number of the order.
     */
    public String getOrderNumber() {
        return orderNumber;
    }
}
