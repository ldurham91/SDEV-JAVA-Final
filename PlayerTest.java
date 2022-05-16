/**********************************************************************************************************
* Name             : Player Test
* Author           : Logan Durham
* Date Last Updated: 05/13/2022
* Description      : Test for Player Class
**********************************************************************************************************/
package finalProject;

public class PlayerTest {
	public static void main(String[] args) {
		Player player = new Player(new Inventory(20), 100, 5);
		
		System.out.println("Max Health: " + player.getMaxHealth());
		System.out.println("Health: " + player.getHealth());
		System.out.println("Damage: " + player.getDamageOut());
		
		player.changeHealth(-50);
		System.out.println("Health: " + player.getHealth());
		
		Item armor = new Item("Armor", 1, 5, ItemType.ARMOR);
		Item weapon = new Item("Weaponr", 1, 5, ItemType.WEAPON);
		
		player.giveItem(armor);
		player.giveItem(weapon);
		
		try {
			player.equipArmor(armor);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			player.equipWeapon(weapon);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		player.changeHealth(-50);
		System.out.println("Health: " + player.getHealth());
		System.out.println("Damage: " + player.getDamageOut());
		
		Item heal = new Item("Heal", 1, 10, ItemType.HEALTH);
		Item maxHealth = new Item("Max Health", 5, 100, ItemType.MAX_HEALTH);
		
		player.giveItem(heal);
		player.giveItem(maxHealth);
		
		try {
			player.useItem(heal);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			player.useItem(maxHealth);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Max Health: " + player.getMaxHealth());
		System.out.println("Health: " + player.getHealth());
		
	}
}
