/**********************************************************************************************************
* Name             : Inventory
* Author           : Logan Durham
* Date Last Updated: 05/13/2022
* Description      : Inventory Class
**********************************************************************************************************/
package finalProject;

import java.util.Vector;

public class Inventory {
	//Members
	private Vector<Item> itemList = new Vector<Item>();
	private int maxSize;
	private int amountHeld = 0;
	
	//Methods
	public int getMaxSize() {
		return maxSize;
	}
	
	public int getAmountHeld() {
		return amountHeld;
	}
	
	public void changeMaxSize(int changeAmount) {
		maxSize += changeAmount;
	}
	
	public void removeItem(Item item) {
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.elementAt(i) == item) {
				itemList.remove(i);
				amountHeld -= item.getSize();
			}
		}
	}
	
	public void addItem(Item item) throws Exception{
		if (amountHeld + item.getSize() > maxSize) {
			throw new Exception("Adding the item would exceed the maxium weight");
		}
		
		amountHeld += item.getSize();
		itemList.add(item);
		
	}
	
	public boolean hasItem(Item item) {
		for (int i = 0; i < itemList.size(); i++) {
			if(itemList.elementAt(i) == item) {
				return true;
			}
		}
		
		return false;
	}
	
	public int numItems() {
		return itemList.size();
	}
	
	public Item itemAt(int i) {
		return itemList.elementAt(i);
	}
	
	//Constructor
	public Inventory(int maxSize) {
		this.maxSize = maxSize;
	}
}
