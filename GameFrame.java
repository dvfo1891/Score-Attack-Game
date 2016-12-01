package com.game.play;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class GameFrame extends Frame {

	static final int WIDTH = 800;
	static final int HEIGHT = 500;
	Unit mainUnit = new Unit(30,30,30,3, this, Unit.Direction.STOP);
	RedUnit redUnit1 = new RedUnit(100,100,30,2, this, Unit.Direction.RU);
	RedUnit redUnit2 = new RedUnit(500,500,30,2, this, Unit.Direction.D);
	List <Unit> units = new ArrayList<Unit>();
	GreenUnit greenUnit1 = new GreenUnit(700,700,30,2, this, Unit.Direction.LU);
	GreenUnit greenUnit2 = new GreenUnit(100,500,30,2, this, Unit.Direction.U);
	BlueUnit blueUnit1 = new BlueUnit(600,300,30,2, this, Unit.Direction.RD);
	BlueUnit blueUnit2 = new BlueUnit(300,500,30,2, this, Unit.Direction.LD);
	InfoMenuBar infoMenuBar;
	
	public GameFrame(String str, int maxScore) throws HeadlessException {
		super();
		this.infoMenuBar = new InfoMenuBar(str,maxScore,this);
	}
	
	public void paint(Graphics g) {
		mainUnit.draw(g);
		redUnit1.draw(g);
		redUnit2.draw(g);
		for(int i=0; i<units.size(); i++){
			Unit unit = units.get(i);
			unit.draw(g);
		}
		greenUnit1.draw(g);
		greenUnit2.draw(g);
		blueUnit1.draw(g);
		blueUnit2.draw(g);
		infoMenuBar.draw(g);
	}

	public void lauchFrame(){
		this.setTitle("嘿嘿嘿");
		this.setLocation(300,150);
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		this.setBackground(Color.gray);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.addKeyListener(new KeyMonitor());
		new Thread(new paintThread()).start();
	}
	
	private class paintThread implements Runnable{
		public void run() {
			while(true){
				repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private class KeyMonitor extends KeyAdapter{
		
		public void keyReleased(KeyEvent e) {
			mainUnit.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			mainUnit.keyPressed(e);
		}
	}
	
	public void exitGame(){
		//call database and store data.
		//exit game
		System.exit(0);
	}
	
	public static void createGame(String str, int score){
		GameFrame g = new GameFrame(str,score);
		g.lauchFrame();
	}
}







