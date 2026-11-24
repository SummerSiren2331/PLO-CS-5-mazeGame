package mazeGame;

/**
 * TODO: define a Node and its fields (directions, visited, contents, etc.)
 * @author Alex Tra, Morgan Fidler
 */
public class Node {
	public PlayerCharacter contents;
	public Palette color = Palette.WHITE;
	
	public Node(PlayerCharacter contents, Palette color) {
		this.contents = contents;
		this.color = color;
	}
}
