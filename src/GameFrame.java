package com.game.play;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GameFrame extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int WIDTH = 800;
	static final int HEIGHT = 500;
	Unit mainUnit = PlayerUnit.getPlayer(this);
	RedUnit redUnit1 = new RedUnit(100,100,30,1, this, Unit.Direction.RU);
	RedUnit redUnit2 = new RedUnit(500,500,30,1, this, Unit.Direction.D);
	List <Unit> units = new ArrayList<Unit>();
	GreenUnit greenUnit1 = new GreenUnit(700,700,30,1, this, Unit.Direction.LU);
	GreenUnit greenUnit2 = new GreenUnit(100,500,30,1, this, Unit.Direction.RU);
	BlueUnit blueUnit1 = new BlueUnit(600,300,30,1, this, Unit.Direction.RD);
	BlueUnit blueUnit2 = new BlueUnit(300,500,30,1, this, Unit.Direction.LD);
	InfoMenuBar infoMenuBar;
	
	
	// Constructor.
	public GameFrame(String str, int maxScore) throws HeadlessException {
		super();
		this.infoMenuBar = new InfoMenuBar(str,maxScore,this);
		startFrame();
	}
	
	@Override
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

	
	public void startFrame(){
		this.setTitle("Score-Attack Game");
		this.setLocation(300,150);
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		this.setBackground(Color.gray);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.addKeyListener(new KeyMonitor());
		new Thread(new paintThread()).start();
	}
	
	
	private class paintThread implements Runnable{
		@Override
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
		@Override
		public void keyReleased(KeyEvent e) {
			mainUnit.keyReleased(e);
		}
		@Override
		public void keyPressed(KeyEvent e) {
			mainUnit.keyPressed(e);
		}
	}
}
	







