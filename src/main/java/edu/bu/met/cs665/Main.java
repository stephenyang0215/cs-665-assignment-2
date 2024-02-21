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

/**
 * This is the Main class.
 */
public class Main {

  public static void main(String[] args) {
    Shop shop = new Shop();
    for (int i=1; i<6; i++) {
      new Driver(i, shop);
    }
    System.out.println("All the available drivers:");
    //Display the names for all the available drivers
    shop.getDriverList();
    shop.processOrder("Tim", 688392212, "Chao Mien", "Boston University", "BU102");
    Driver driver1 = shop.dropDriver();
    driver1.acceptOrder();

    shop.processOrder("Jenny", 657757838, "Pizza", "NorthEastern University", "NEU111");
    Driver driver2 = shop.dropDriver();
    driver2.acceptOrder();
  }
}
