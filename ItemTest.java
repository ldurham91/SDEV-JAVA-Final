/**********************************************************************************************************
* Name             : ItemTest
* Author           : Logan Durham
* Date Last Updated: 05/13/2022
* Description      : Test the item class
**********************************************************************************************************/
package finalProject;

public class ItemTest {
	public static void main(String[] args) {
		Item item = new Item("Test", 1, 1, ItemType.ARMOR);
		
		System.out.println("Name: " + item.getName());
		System.out.println("Size: " + item.getSize());
		System.out.println("Mod Amount: " + item.getModAmount());
		System.out.println("Type: " + item.getType());
	}
}
