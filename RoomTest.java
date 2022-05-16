/**********************************************************************************************************
* Name             : Room Test
* Author           : Logan Durham
* Date Last Updated: 05/13/2022
* Description      : Test for Room Class
**********************************************************************************************************/
package finalProject;

public class RoomTest {
	public static void main(String[] args) {
		Item item = new Item("None", 0, 0, ItemType.NONE);
		Enemy enemy = new Enemy("Test", 100, 5, item);
		Item item2 = new Item("Test", 3, 5, ItemType.ARMOR);
		Room room = new Room(enemy, item2, 2);
		
		System.out.println("Enemy Name: " + room.getEnemy().getName());
		System.out.println("Treasure Name: " + room.getTreasure().getName());
		
		Player player = new Player(new Inventory(20), 100, 5);
		
		System.out.println("Player Max Health: " + player.getMaxHealth());
		
		room.bonusEffect(player);
		
		System.out.println("Player Max Health: " + player.getMaxHealth());
	}
}
