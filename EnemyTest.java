/**********************************************************************************************************
* Name             : Enemy Test
* Author           : Logan Durham
* Date Last Updated: 05/13/2022
* Description      : Test forEnemy class
**********************************************************************************************************/
package finalProject;

public class EnemyTest {
	public static void main(String[] args) {
		Item item = new Item("None", 0, 0, ItemType.NONE);
		Enemy enemy = new Enemy("Test", 100, 5, item);
		
		System.out.println("Damage Out: " + enemy.getDamageOut());
		System.out.println("Name: " + enemy.getName());
		System.out.println("Item: " + enemy.getItem().getName());
		System.out.println("Health: " + enemy.getHealth());
		
		enemy.changeHealth(-50);
		System.out.println("Health: " + enemy.getHealth());
		
	}
}
