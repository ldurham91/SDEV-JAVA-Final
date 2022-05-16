/**********************************************************************************************************
* Name             : Inventory Test
* Author           : Logan Durham
* Date Last Updated: 05/13/2022
* Description      : Test for Inventory Class
**********************************************************************************************************/
package finalProject;

public class InventoryTest {
	public static void main(String[] args) {
		Inventory inv = new Inventory(20);
		
		System.out.println("Max Size: " + inv.getMaxSize());
		System.out.println("Amount Held: " + inv.getAmountHeld());
		
		inv.changeMaxSize(10);
		System.out.println("New Max Size: " + inv.getMaxSize());
		
		Item item = new Item("Test", 1, 1, ItemType.WEAPON);
		try {
		inv.addItem(item);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Amount Held: " + inv.getAmountHeld());
		
		Item item2 = new Item("Test", 30, 1, ItemType.WEAPON);
		try {
		inv.addItem(item2);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Amount Held: " + inv.getAmountHeld());
		
		Item item3 = new Item("Test", 29, 1, ItemType.WEAPON);
		try {
		inv.addItem(item3);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Amount Held: " + inv.getAmountHeld());
		
		Item item4 = new Item("Test", 1, 1, ItemType.WEAPON);
		try {
		inv.addItem(item4);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Amount Held: " + inv.getAmountHeld());
		
		inv.removeItem(item3);
		
		System.out.println("Amount Held: " + inv.getAmountHeld());
		
		if(inv.hasItem(item)) {
			System.out.println("Has Item");
		}
			
	}
}
