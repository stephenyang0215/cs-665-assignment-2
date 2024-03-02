/**
 * Name: Stephen Yang

 * Course: CS-665 Software Designs & Patterns

 * Date: 02/22/2024

 * File Name: PublisherBase.java

 * Description: This is the interface for publisher.
 */
package edu.bu.met.cs665;

public interface PublisherBase {
    /**
     * subscribe: Driver subscribes to delivery requests for the shop.
     */
    void subscribe(Driver driver);
    /**
     * unsubscribe: Driver unsubscribes from delivery requests for the shop.
     */
    void unsubscribe(Driver driver);
    /**
     * notifySubscribers: send notification for delivery request to the available drivers.
     */
    void notifySubscribers(DeliveryRequest order, Shop shop);
}
