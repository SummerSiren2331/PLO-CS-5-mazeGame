package mazeGame;

import java.awt.Color;

/**
 * This class contains all the helper methods used by the app/GUI. For now, leave everything public
 * @author Morgan Fidler, Alex Tra
 */
public class mazeGameControl {
	// TODO: First, plan how to control character movement
	// USE KEYLISTENER FROM SWING??
	// POTENTIALLY.
	
	// Returns color based on enum (or is there a better way to do this?)
	public Color setColor(Palette p) {
		return new Color(255, 255, 255);
	}
	
	// Uses the spell scroll item
	protected static void spellScrollSolve(Maze maze) {
		new Thread(() -> maze.solve()).start();
		// TODO: decrease item count in inventory & check eligibility
		
		// FUNCTIONALITY CAN BE FOUND IN PLAYER CLASS
		// (Player object).useInteractable(Interactables.SPELLSCROLL);
	}
	
	protected static void move() {
		
	}
}
