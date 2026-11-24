package mazeGame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Dimension;

/**
 * This is the main app/GUI of the game
 * @author Morgan Fidler
 */
public class mazeGameApp extends JFrame {
	
	protected static int windowWidth = 960;
	protected static int windowHeight = 540;

	protected static final long serialVersionUID = 1L;
	protected JPanel mazeGame;
	protected static JPanel mazePanel;
	
	protected static int cols = 5;
	public static int rows = 5;

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
		mazeGame.setPreferredSize(new Dimension(960, 540));
		mazeGame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mazeGame);
		mazeGame.setLayout(new BorderLayout(0, 0));
		
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
	}

	/*
	 * Initializes a maze game
	 */
	private void startMaze() {
	    Node[][] nodeMap = new Node[cols][rows];
	    Maze maze = new Maze(cols, rows, nodeMap);

	    mazeGameApp.mazePanel.add(StdDrawEmbedded.getDrawPanel(), BorderLayout.CENTER);
	    mazeGameApp.mazePanel.revalidate();
	    mazeGameApp.mazePanel.repaint();
	    StdDrawEmbedded.enableDoubleBuffering();

	    maze.draw();
	    new Thread(() -> maze.solve()).start();
	}
}
