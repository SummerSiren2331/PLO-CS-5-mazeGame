package mazeGame;

import edu.princeton.cs.algs4.StdRandom;

/**
 * TODO
 * @author Alex Tra
 */
public class Boss extends PlayerCharacter {

	public Boss(int hp, int stamina, int dmg) {
		super(hp, stamina, dmg);
	}
	
	// TODO: SPECIAL ATKS
	public int attack(int dmg) {
		int rng = StdRandom.uniformInt(0, 101);
		int atkChance = 20;
		
		// Gives boss a 20% chance to "special attack"
		if (rng <= atkChance) {
			dmg *= 3;
		}
		
		return dmg;
	}
}
