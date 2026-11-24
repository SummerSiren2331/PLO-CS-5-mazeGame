package mazeGame;

/**
 * This class defines a character object
 * TODO: Make subclasses Player, Enemy, and Minotaur (boss battle!)
 * @author Alex Tra
 */
public class PlayerCharacter {
	private int hp = 1;
	private int stamina = 1;
	
	public PlayerCharacter(int hp, int stamina) {
		this.hp = hp;
		this.stamina = stamina;
	}
}
