/**
 * Name: Stephen Yang

 * Course: CS-665 Software Designs & Patterns

 * Date: 02/22/2024

 * File Name: Main.java

 * Description: The main class runs the implementation of the delivery request, shop and drivers.

 */
/**
 * Name: FIRST_NAME LAST_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: Main.java
 * Description: Write a description for this class
 */
/**

 * Name: Stephen Yang

 * Course: CS-665 Software Designs & Patterns

 * Date: 02/22/2024

 * File Name: Main.java

 * Description: This class instantiate the classes of Shop, Driver and DeliveryRequest.
 * It works as the notification system to receive the delivery orders from the shop and
 * notify all the available drivers about the delivery requests.
 */


package edu.bu.met.cs665;
public class Main {

  public static void main(String[] args) {
    //Display the names for all the available drivers
    System.out.println("All the available drivers:");
    Shop shop = new Shop(); // Initialize the shop
    // Initialize 5 drivers
    for (int i=1; i<6; i++) {
      new Driver(i, shop);
    }
    System.out.println("\nNew order! \nName: Tim \nPhone Number: 688392212 \nFood: Chao Mien \nDestination: Boston University \nOrder Number: BU102\n");
    DeliveryRequest order1 = shop.processOrder("Tim", "688392212", "Chao Mien", "Boston University", "BU102");
    System.out.println("Send the notification to all the available drivers! ");
    Driver driver1 = shop.driverList.remove(0);
    driver1.setAvailable(false);
    System.out.println("Driver " + driver1.getName() + " accept the order " + order1.getOrderNumber());
    System.out.println("Number of available drivers : " + shop.getDriverList().size());

    System.out.println("\nNew order! \nName: Jenny \nPhone Number: 657757838 \nFood: Pizza \nDestination: NorthEastern University \nOrder Number: NEU111\n");
    DeliveryRequest order2 = shop.processOrder("Jenny", "657757838", "Pizza", "NorthEastern University", "NEU111");
    System.out.println("Send the notification to all the available drivers ");
    Driver driver2 = shop.driverList.remove(0);
    driver2.setAvailable(false);
    System.out.println("Driver " + driver2.getName() + " accept the order " + order2.getOrderNumber());
    System.out.println("Number of available drivers : " + shop.getDriverList().size());
    driver2.updateOrder(order2, shop);

  }
}
