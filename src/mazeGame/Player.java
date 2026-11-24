package mazeGame;

import edu.princeton.cs.algs4.Queue;

public class Player extends PlayerCharacter {
	
	//private Interactables[] inventory = Interactables.values();
	Queue<Interactables> inventory = new Queue<>();

	public Player(int hp, int stamina, int dmg) {
		super(hp, stamina, dmg);
	}
	
	public void pickUpInteractable(Interactables item) {
		// TODO: FIGURE OUT HOW TO SEE IF CURRENT POSITION CONTAINS INTERACTABLE AND ADD TO INVENTORY
		//inventory.enqueue(item);
	}

}
