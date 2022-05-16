/**********************************************************************************************************
* Name             : Project GUI
* Author           : Logan Durham
* Date Last Updated: 05/14/2022
* Description      : GUI for the program
**********************************************************************************************************/
package finalProject;
import java.util.Vector;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ProjectGUI extends Application {
	private Button btFight = new Button("Fight");
	private Button btInv = new Button("Inventory");
	private Button btAttack = new Button("Attack");
	private Room room = null;
	private int roomNum = 1;
	
	@Override 
	public void start(Stage primaryStage) {
		Player player = new Player(new Inventory(10), 100, -10);
		BorderPane mainPane = new BorderPane();
		
		
		//Initial UI setup
		roomUI(mainPane, player, roomNum);
		
		//Action events
		btFight.setOnAction(e -> onFightPress(mainPane, player, room));
		btAttack.setOnAction(e -> onAttackPress(mainPane, player, room, roomNum));
		btInv.setOnAction(e -> onInvPress(mainPane, player, roomNum));
		
		//Window setup
		Scene scene = new Scene(mainPane);
		primaryStage.setHeight(500);
		primaryStage.setTitle("Game");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	private void onInvPress(BorderPane mainPane, Player player, int roomNum) {
		//List of buttons
		Vector<Button> buttonList = new Vector<Button>();
		
		//Create buttons for every item in the players inventory
		for (int i = 0; i < player.numItems(); i++) {
			buttonList.add(new Button(player.itemAt(i).getName()));
		}
		
		//Create a button to leave the inventory
		buttonList.add(new Button("Cancel"));
		
		//Add all the buttons to a pane
		HBox invMenu = new HBox();
		for (int i = 0; i < player.numItems() + 1; i++) {
			invMenu.getChildren().add(buttonList.elementAt(i));
		}
		
		//Display the buttons
		mainPane.setBottom(invMenu);
		
		//Loop of action events for a button press
		int i;
		for (i = 0; i < player.numItems(); i++) {
		
			if(player.itemAt(i).getType() == ItemType.ARMOR) {
				Item temp = player.itemAt(i);
				buttonList.elementAt(i).setOnAction(e -> equipArmor(mainPane, player, temp));
			}
			else if(player.itemAt(i).getType() == ItemType.WEAPON) {
				Item temp = player.itemAt(i);
				buttonList.elementAt(i).setOnAction(e -> equipWeapon(mainPane, player, temp));
			}
			else if (player.itemAt(i).getType() == ItemType.HEALTH || player.itemAt(i).getType() == ItemType.MAX_HEALTH) {
				Item temp = player.itemAt(i);
				buttonList.elementAt(i).setOnAction(e -> useItem(mainPane, player, temp));
			}
		}
		
		//Action event when cancel is pressed
		buttonList.elementAt(i).setOnAction(e -> invCancel(mainPane));
	}
	private void invCancel(BorderPane mainPane) {
		mainPane.setBottom(getRoomButtons());
	}
	private void useItem(BorderPane mainPane, Player player, Item item) {
		try {
			player.useItem(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Display the players health and the room buttons
		mainPane.setTop(new Label("HP: " + player.getHealth() + "/" + player.getMaxHealth()));
		mainPane.setBottom(getRoomButtons());
	}
	private void equipWeapon(BorderPane mainPane, Player player, Item item) {
		try {
		player.equipWeapon(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Display the room buttons
		mainPane.setBottom(getRoomButtons());
	}
	private void equipArmor(BorderPane mainPane,Player player, Item item) {
		try {
		player.equipArmor(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Display the room buttons
		mainPane.setBottom(getRoomButtons());
	}
	private void onAttackPress(BorderPane mainPane, Player player, Room room, int roomNum) {
		//Change the player and enemies health and display that new health
		room.getEnemy().changeHealth(player.getDamageOut());
		mainPane.setRight(new Label(room.getEnemy().getName() + " HP: " + room.getEnemy().getHealth()));
		player.changeHealth(room.getEnemy().getDamageOut());
		mainPane.setTop(new Label("HP: " + player.getHealth() + "/" + player.getMaxHealth()));
		
		//If the enemy was killed
		if(room.getEnemy().getHealth() <=0) {
			player.giveItem(room.getEnemy().getItem());
			room.bonusEffect(player);
			
			//Depending on what enemy was fought a different room is entered
			if (room.getEnemy().getName() == "Slime") {
				roomNum = 2;
			}
			else if (room.getEnemy().getName() == "Skeleton") {
				roomNum = 3;
			}
			else if (room.getEnemy().getName() == "Dragon") {
				roomNum = 4;
			}
			roomUI(mainPane, player, roomNum);
			return;
		}
		
		//If the player died
		if (player.getHealth() <= 0) {
			mainPane.setCenter(new Label("Game Over!"));
		}
	}
	private void onFightPress(BorderPane mainPane, Player player, Room room) {
		StackPane enemyPane = new StackPane();
		
		//Create a node for the enemy depending on the name of the enemy
		if (room.getEnemy().getName() == "Slime") {
			Circle slime = new Circle();
			slime.setCenterX(100);
			slime.setCenterY(100);
			slime.setRadius(50);
			slime.setFill(Color.GREEN);
			
			enemyPane.getChildren().add(slime);
			StackPane.setAlignment(slime, Pos.CENTER);
		}
		
		if (room.getEnemy().getName() == "Skeleton") {
			Rectangle skeleton = new Rectangle();
			skeleton.setHeight(100);
			skeleton.setWidth(100);
			skeleton.setFill(Color.BLACK);
			
			enemyPane.getChildren().add(skeleton);
			StackPane.setAlignment(skeleton, Pos.CENTER);
		}
		
		if (room.getEnemy().getName() == "Dragon") {
			Rectangle dragon = new Rectangle();
			dragon.setHeight(100);
			dragon.setWidth(200);
			dragon.setFill(Color.CADETBLUE);
			
			enemyPane.getChildren().add(dragon);
			StackPane.setAlignment(dragon, Pos.CENTER);
		}
		
		//Display the enemy, the fight buttons, and the enemies health
		mainPane.setCenter(enemyPane);
		mainPane.setBottom(getFightButtons());
		mainPane.setRight(new Label(room.getEnemy().getName() + " HP: " + room.getEnemy().getHealth()));
	}	
	private void roomUI(BorderPane mainPane, Player player, int roomNum) {
		//Create a room for the game depending on the room number
		if(roomNum == 1) {
			Enemy slime = new Enemy("Slime", 20, -2, new Item("Healing Potion", 1, 10, ItemType.HEALTH));
			room = new Room(slime, null, 0);
			room.setDescription("You wake up in a strange room. You have no idea how you ended up here."
					+ " Before you have any time to get your bearing a weird pile of goo jumps"
					+ " at your face.");
		}
		
		if (roomNum == 2) {
			Enemy skeleton = new Enemy("Skeleton", 50, -8, new Item("Sword", 5, -10, ItemType.WEAPON));
			room = new Room(skeleton, null, 2);
			room.setDescription("After beating the slime you notice a door leading out of the room."
					+ " Going through the door you see a skeleton.");
		}
		
		if (roomNum == 3) {
			Enemy dragon = new Enemy("Dragon", 100, -10, null);
			room = new Room(dragon, null, 2);
			room.setDescription("A Dragon apears");
		}
		
		if (roomNum == 4) {
			mainPane.setCenter(new Label("End of Game"));
			mainPane.setBottom(null);
			return;
		}
		
		Label label = new Label(room.getDescription());
		label.setWrapText(true);
		label.setMaxWidth(500);
		
		//Setup the room UI
		mainPane.setTop(new Label("HP: " + player.getHealth() + "/" + player.getMaxHealth()));
		mainPane.setCenter(label);
		mainPane.setBottom(getRoomButtons());
	}	
	private HBox getRoomButtons() {
		//Display the buttons for a room
		HBox roomButtons = new HBox();
		roomButtons.getChildren().add(btFight);
		roomButtons.getChildren().add(btInv);
		
		return roomButtons;
	}
	private HBox getFightButtons() {
		//Display the buttons for a fight
		HBox fightButtons = new HBox();
		fightButtons.getChildren().add(btAttack);
		
		return fightButtons;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
