package mazeGame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Dimension;

/**
 * This is the main app/GUI of the game
 * @author Morgan Fidler
 */
public class mazeGameApp extends JFrame implements KeyListener{
	
	protected static int windowWidth = 960;
	protected static int windowHeight = 540;

	protected static final long serialVersionUID = 1L;
	protected JPanel mazeGame;
	protected static JPanel mazePanel;
	
	protected static int cols = 15;
	protected static int rows = 15;
	
	protected int recordTime = 0; // update only if current time is LESS THAN record OR if record = 0.
	protected int currentTime = 0; // use nanotime and update every second
	
	Maze maze;
	int currentRow = 1;
	int currentCol = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(() -> {
	        try {
	            mazeGameApp frame = new mazeGameApp();
	            frame.setVisible(true);
	            frame.startMaze();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    });
	}

	/**
	 * Create the frame.
	 */
	public mazeGameApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, windowWidth, windowHeight);
		mazeGame = new JPanel();
		mazeGame.setLayout(new BorderLayout(0, 0));
		mazeGame.setPreferredSize(new Dimension(500, 500));
		mazeGame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mazeGame);
		
		JPanel settingsPanel = new JPanel();
		mazeGame.add(settingsPanel, BorderLayout.WEST);
		settingsPanel.setLayout(new GridLayout(4, 4, 0, 0));
		
		JPanel alg1Panel = new JPanel();
		FlowLayout fl_alg1Panel = (FlowLayout) alg1Panel.getLayout();
		fl_alg1Panel.setAlignment(FlowLayout.LEFT);
		settingsPanel.add(alg1Panel);
		
		JPanel algsPanel = new JPanel();
		FlowLayout fl_algsPanel = (FlowLayout) algsPanel.getLayout();
		fl_algsPanel.setAlignment(FlowLayout.LEFT);
		settingsPanel.add(algsPanel);
		
		JCheckBox alg1ChkBox = new JCheckBox("New check box");
		alg1ChkBox.setVerticalAlignment(SwingConstants.TOP);
		alg1ChkBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		algsPanel.add(alg1ChkBox);
		
		JCheckBox alg2ChkBox = new JCheckBox("New check box");
		alg2ChkBox.setVerticalAlignment(SwingConstants.TOP);
		alg2ChkBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		algsPanel.add(alg2ChkBox);
		
		JPanel alg3Panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) alg3Panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		settingsPanel.add(alg3Panel);
		
		JPanel alg4Panel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) alg4Panel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		settingsPanel.add(alg4Panel);
		
		mazePanel = new JPanel();
		mazePanel.setLayout(new BorderLayout());
		mazeGame.add(mazePanel, BorderLayout.CENTER);
		
		// Testing key listener inside app instead of different class
		// DELETE THIS IF THERE'S A BETTER WAY OF DOING THIS
		addKeyListener(this);
		setFocusable(true);
		setVisible(true);
	}

	/*
	 * Initializes a maze game
	 */
	private void startMaze() {
	    Node[][] nodeMap = new Node[cols][rows];
	    //Maze maze = new Maze(cols, rows, nodeMap);
	    maze = new Maze(cols, rows, nodeMap);

	    mazeGameApp.mazePanel.add(StdDrawEmbedded.getDrawPanel(), BorderLayout.CENTER);
	    mazeGameApp.mazePanel.revalidate();
	    mazeGameApp.mazePanel.repaint();
	    StdDrawEmbedded.enableDoubleBuffering();

	    maze.draw();
	    maze.solve(currentRow, currentCol);
	    //mazeGameControl.spellScrollSolve(maze); // Remove before shipping, use only to use the scroll
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			currentRow += 1;
			maze.solve(currentCol, currentRow);
			System.out.println("W key pressed.");
		}
		else if (code == KeyEvent.VK_S) {
			currentRow -= 1;
			maze.solve(currentCol, currentRow);
			System.out.println("S key pressed.");
		}
		else if (code == KeyEvent.VK_A) {
			currentCol -= 1;
			maze.solve(currentCol, currentRow);
			System.out.println("A key pressed.");
		}
		else if (code == KeyEvent.VK_D) {
			currentCol += 1;
			maze.solve(currentCol, currentRow);
			System.out.println("D key pressed.");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
