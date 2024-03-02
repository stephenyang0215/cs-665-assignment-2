/**
 * Name: Stephen Yang

 * Course: CS-665 Software Designs & Patterns

 * Date: 02/22/2024

 * File Name: SubscriberBase.java

 * Description: This is the interface for subscribers.
 */
package edu.bu.met.cs665;

public interface SubscriberBase {
    /**
     * updateOrder: receive the notification for delivery request.
     */
    void updateOrder(DeliveryRequest order, Shop shop);
}
