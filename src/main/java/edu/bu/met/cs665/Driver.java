package edu.bu.met.cs665;

public class Driver implements SubscriberBase {
    private String name;
    private DeliveryRequest order;
    private boolean available;
    public Driver(Integer number, Shop shop) {
        this.name = "Driver " + number;
        this.available = true;
        shop.subscribe(this);
    }

    @Override
    public void updateDriver(DeliveryRequest order) {
        this.order = order;
    }

    public DeliveryRequest getOrder() {
        return this.order;
    }

    public String getName() {
        return name;
    }

    public void acceptOrder() {
        this.available = false;
        System.out.println(this.name + " accept the order " + this.order.getOrderNumber());
    }

    public void finishDelivery(Shop shop) {
        this.available = true;
        shop.addDriverList(this);
    }
}
