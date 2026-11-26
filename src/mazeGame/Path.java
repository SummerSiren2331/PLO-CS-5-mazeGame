package mazeGame;

import edu.princeton.cs.algs4.Stack;

/**
 * This class keeps track of the path of a character, it would be nice but not required to also track backtracking
 * @author Alex Tra
 */
public class Path {
	
	// TODO: FIND WAY TO GET CURRENT ROW AND COLUMN TO PUSH INTO STACK
	Stack<Node[][]> path = new Stack<>();
	
	int currentRow;
	int currentCol;
}
