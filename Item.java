/**********************************************************************************************************
* Name             : Item
* Author           : Logan Durham
* Date Last Updated: 05/13/2022
* Description      : Class for items
**********************************************************************************************************/
package finalProject;

public class Item {
	//Members
	private String name;
	private int size;
	private int modAmount;
	private ItemType type;
	
	//Methods
	public String getName() {
		return name;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getModAmount() {
		return modAmount;
	}
	
	public ItemType getType() {
		return type;
	}
	
	//Constructor
	public Item(String name, int size, int modAmount, ItemType type) {
		this.name = name;
		this.size = size;
		this.modAmount = modAmount;
		this.type = type;
	}
}
