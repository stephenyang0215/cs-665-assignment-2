package edu.bu.met.cs665;

public class DeliveryRequest {
    private String destination;
    private String food;
    private String orderNumber;
    private String name;
    private Integer phoneNumber;
    public DeliveryRequest(String name, Integer phoneNumber, String food, String destination, String orderNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.food = food;
        this.destination = destination;
        this.orderNumber = orderNumber;

    }

    public String getName() {
        return this.name;
    }

    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getFood() {
        return this.food;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
}
