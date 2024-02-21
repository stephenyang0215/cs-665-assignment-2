package edu.bu.met.cs665;

import java.util.ArrayList;

public class Shop implements PublisherBase{
    private ArrayList<Driver> driverList;

    public Shop() {
        this.driverList = new ArrayList<>();
    }
    /**
     * processOrder method generates new order for the shop.
     * then notify all the available drivers.
     */

    public void processOrder(String name, Integer phoneNumber, String food, String destination, String orderNumber) {
        DeliveryRequest order = new DeliveryRequest(name, phoneNumber, food, destination, orderNumber);
        notifySubscribers(order);
    }

    @Override
    public void subscribe(Driver driver) {
        this.driverList.add(driver);
    }

    @Override
    public void unsubscrube(Driver driver) {
        this.driverList.remove(driver);
    }

    @Override
    public void notifySubscribers(DeliveryRequest order) {
        for (Driver driver: this.driverList) {
            driver.updateDriver(order);
        }
    }

    public ArrayList<Driver> getDriverList() {
        for (Driver driver: this.driverList) {
            System.out.println(driver.getName());
        }
        return this.driverList;
    }

    public void addDriverList(Driver driver) {
        this.driverList.add(driver);
    }

    public Driver dropDriver() {
        Driver driver = this.driverList.remove(0);
        return driver;
    }

}
