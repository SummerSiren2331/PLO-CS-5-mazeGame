package mazeGame;

import edu.princeton.cs.algs4.ST;

/**
 * 
 * @author Alex Tra
 */
public class Player extends PlayerCharacter {
	
	//private int[] inventory = new int[4];
	private ST<Interactables, Integer> inventory = new ST<>();
	
	/*
	// SWORD, POTION, SPELLSCROLL, HELMET, TRAP
	int swordIndex = 0;
	int potionIndex = 1;
	int spellIndex = 2;
	int helmetIndex = 3;
	int trapIndex = 4;
	*/
	

	public Player(int hp, int stamina, int dmg) {
		super(hp, stamina, dmg);
		
		// Sets player inventory to be empty upon creation
		inventory.put(Interactables.SWORD, 0);
		inventory.put(Interactables.POTION, 0);
		inventory.put(Interactables.SPELLSCROLL, 0);
		inventory.put(Interactables.HELMET, 0);
		inventory.put(Interactables.TRAP, 0);
		
		if (inventory.get(Interactables.SWORD) > 0) setCanAtk(true);
		else setCanAtk(false);
	}
	
	public void pickUpInteractable(Interactables item) {
		// TODO: FIGURE OUT HOW TO SEE IF CURRENT POSITION CONTAINS INTERACTABLE AND ADD TO INVENTORY
		
		// ARRAY CODE IF INVENTORY IS AN ARRAY
		/*
		if (inventory.length == 0) {
			throw new IllegalArgumentException("Inventory isn't set properly");
		}
		
		if (item == Interactables.SWORD) inventory[swordIndex] += 1;
		else if (item == Interactables.POTION) inventory[potionIndex] += 1;
		else if (item == Interactables.SPELLSCROLL) inventory[spellIndex] += 1;
		else if (item == Interactables.HELMET) inventory[helmetIndex] += 1;
		else inventory[trapIndex] += 1;
		*/
		
		// SYMBOL TABLE CODE IF INVENTORY IS A SYMBOL TABLE
		inventory.put(item, inventory.get(item) + 1);
		
		// might be better placed elsewhere
		if (inventory.get(Interactables.SWORD) > 0) setCanAtk(true);
		else setCanAtk(false);
	}
	
	public void useInteractable(Interactables item) {
		// Checks if any are in the inventory
		if (inventory.get(item) == 0) {
			System.out.println(String.format("Can't use item [ %s ]. None in inventory.", item));
		}
		
		// TODO: FIGURE OUT CODE FOR USING AN ITEM DEPENDING ON WHAT IT IS
		if (item == Interactables.SWORD) {
			// SHOULD THIS INCREASE DMG OR ONLY ALLOW THE PLAYER TO ATK IF THEY HAVE A SWORD IN THEIR INVENTORY???
		}
		
		if (item == Interactables.POTION) {
			setHp(getHp() + 1);
		}
		
		if (item == Interactables.SPELLSCROLL) {
			// TODO: FIGURE OUT HOW TO PASS IN MAZE FOR PLAYER
			//mazeGameControl.spellScrollSolve();
		}
		
		if (item == Interactables.HELMET) {
			// SHOULD THIS REMOVE X AMOUNT OF DMG FROM ENEMY IF ONE IS IN INVENTORY???
		}
		
		if (item == Interactables.TRAP) {
			
		}
		
		inventory.put(item, inventory.get(item) - 1);
	}

}
