/**********************************************************************************************************
* Name             : Room
* Author           : Logan Durham
* Date Last Updated: 05/13/2022
* Description      : Room Class
**********************************************************************************************************/
package finalProject;

public class Room {
	//Members
	private Enemy enemy;
	private Item treasure;
	private int bonus;
	private String roomDesc;
	
	//Methods
	public String getDescription() {
		return roomDesc;
	}
	
	public void setDescription(String string) {
		roomDesc = string;
	}
	public Enemy getEnemy() {
		return enemy;
	}
	
	public Item getTreasure() {
		return treasure;
	}
	
	public void bonusEffect(Player player) {
		if (bonus == 1) {
			player.changeHealth(player.getMaxHealth());
		}
		
		else if (bonus == 2) {
			player.upMaxHealth(10);
		}
		
		else if (bonus == 3) {
			player.giveItem(treasure);
		}
	}
	
	//Constructor
	public Room(Enemy enemy, Item treasure, int bonus) {
		this.enemy = enemy;
		this.treasure = treasure;
		this.bonus = bonus;
	}
}
