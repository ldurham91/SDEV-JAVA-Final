/**********************************************************************************************************
* Name             : Player
* Author           : Logan Durham
* Date Last Updated: 05/13/2022
* Description      : Player Class
**********************************************************************************************************/
package finalProject;

public class Player extends Character{
	//Member
	private Inventory inventory;
	private int maxHealth;
	private Item weapon;
	private Item armor;
	
	//Methods
	public void upMaxHealth(int changeAmount) {
		maxHealth += changeAmount;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	@Override
	public int getDamageOut() {
		if(weapon != null) {
			return damageOut + weapon.getModAmount();	
		}
		else {
			return damageOut;
		}
	}
	
	@Override 
	public void changeHealth(int changeAmount) {
		if (health + changeAmount > maxHealth) {
			health = maxHealth;
		}
		
		else if (changeAmount < 0) {
			if(armor != null) {
				health += changeAmount + armor.getModAmount();
			}
			else {
				health += changeAmount;
			}
		}
		else {
			health += changeAmount;
		}
	}
	
	public void changeDamageOut(int changeAmount) {
		damageOut += changeAmount;
	}
	
	public void equipWeapon(Item newItem) throws Exception{
		if (!inventory.hasItem(newItem)) {
			throw new Exception("Item not in inventory");
		}
		if(newItem.getType() != ItemType.WEAPON) {
			throw new Exception("Item must be a weapon");
		}
		
		weapon = newItem;
		inventory.removeItem(newItem);
	}
	
	public void equipArmor(Item newItem) throws Exception{
		if (!inventory.hasItem(newItem)) {
			throw new Exception("Item not in inventory");
		}
		if(newItem.getType() != ItemType.ARMOR) {
			throw new Exception("Item must be a armor");
		}
		
		armor = newItem;
		inventory.removeItem(newItem);
	}
	
	public void useItem(Item item) throws Exception {
		if (!inventory.hasItem(item)) {
			throw new Exception("Item not in inventory");
		}
		
		if(item.getType() != ItemType.HEALTH && item.getType() != ItemType.MAX_HEALTH) {
			throw new Exception("Must be a health item");
		}
		
		if(item.getType() == ItemType.HEALTH) {
			this.changeHealth(item.getModAmount());
			inventory.removeItem(item);
		}
		
		else {
			this.upMaxHealth(item.getModAmount());
			inventory.removeItem(item);
		}
	}
	
	public void giveItem(Item item) {
		try {
		inventory.addItem(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Item itemAt(int i) {
		return inventory.itemAt(i);
	}
	
	public int numItems() {
		return inventory.numItems();
	}
	
	//Constructor
	public Player(Inventory inventory, int health, int damageOut) {
		super(health, damageOut);
		this.inventory = inventory;
		this.maxHealth = health;
	}
}
