package mazeGame;

/**
 * This class defines a character object
 * TODO: Make subclasses Player, Enemy, and Minotaur (boss battle!)
 * @author Alex Tra
 */
public class PlayerCharacter {
	private int hp = 1;
	private int stamina = 1;
	private int dmg = 1;
	
	public PlayerCharacter(int hp, int stamina, int dmg) {
		this.hp = hp;
		this.stamina = stamina;
		this.dmg = dmg;
	}

	public int getHp() {
		return hp;
	}

	public int getStamina() {
		return stamina;
	}
	
	public int getDmg() {
		return dmg;
	}
	
	public void takeDmg(int dmg) {
		hp -= dmg;
	}
	
}
