package mazeGame;

/**
 * TODO: define a Node and its fields (directions, visited, contents, etc.)
 * @author Alex Tra, Morgan Fidler
 */
public class Node {
	public int n;
	public int s;
	public int e;
	public int w;
	public PlayerCharacter contents;
	
	public Node(int n, int s, int e, int w, PlayerCharacter contents) {
		this.n = n;
		this.s = s;
		this.e = e;
		this.w = w;
		this.contents = contents;
	}
}
