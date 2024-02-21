package edu.bu.met.cs665;

public interface PublisherBase {
    void subscribe(Driver driver);
    void unsubscrube(Driver driver);
    void notifySubscribers(DeliveryRequest order);
}
