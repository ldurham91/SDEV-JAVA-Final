/**********************************************************************************************************
* Name             : Enemy
* Author           : Logan Durham
* Date Last Updated: 05/13/2022
* Description      : Enemy class
**********************************************************************************************************/
package finalProject;

public class Enemy extends Character {
	//Members
	private Item heldItem;
	private String name;
	
	//Methods
	@Override
	public int getDamageOut() {
		return damageOut;
	}
	
	@Override
	public void changeHealth(int changeAmount) {
		health += changeAmount;
	}
	
	public String getName() {
		return name;
	}
	
	public Item getItem() {
		return heldItem;
	}
	
	//Constructor
	public Enemy(String name, int health, int damageOut, Item heldItem) {
		super(health, damageOut);
		this.name = name;
		this.heldItem = heldItem;
	}
}
