/**********************************************************************************************************
* Name             : Character
* Author           : Logan Durham
* Date Last Updated: 05/13/2022
* Description      : Abstract class for characters
**********************************************************************************************************/
package finalProject;

public abstract class Character {
	//Members
	protected int health = 100;
	protected int damageOut = 5;
	
	//Methods
	public int getHealth() {
		return health;
	}
	
	public abstract void changeHealth(int changeAmount);
	public abstract int getDamageOut();
	
	//Constructors
	protected Character (int health, int damageOut) {
		this.health = health;
		this.damageOut = damageOut;
	}
	
	protected Character() {
	}
	
}
