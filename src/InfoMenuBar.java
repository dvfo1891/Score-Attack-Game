/**
 * After initialization, this class will:
 * 		Monitor Current score.
 * 		Create score bar.
 * 		Call method GameFrame.exitGame() when score turn zero.
 * */
package com.game.play;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.game.main.StartFrame;
import com.game.main.UserData;

public class InfoMenuBar {
	
	public String playerName;
	public int originalScore;
	public int currentScore;
	public int currentMaxScore;
	public final int lifeBarX = 100;
	public final int lifeBarY = 30;
	public final int lifeBarBlockLen = 20;
	public GameFrame gf;
	
	public InfoMenuBar(String playerName, int originalScore, GameFrame gf) {
		super();
		this.playerName = playerName;
		this.originalScore = originalScore;
		this.currentMaxScore = originalScore;
		currentScore = 10;
		this.gf = gf;
	}
	
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.orange);
		g.drawString("Your Score :", 20, lifeBarY+15);
		g.fillRect(lifeBarX, lifeBarY, lifeBarBlockLen*currentScore, 10+lifeBarBlockLen);
		if(currentScore > 35){
			g.setColor(Color.blue);
			g.fillRect(lifeBarX, lifeBarY, lifeBarBlockLen*(currentScore - 35), 10+lifeBarBlockLen);
		}
		if(currentScore <= 0){
			Font myFont = new Font("Courier New", 1, 40);
			g.setFont(myFont);
			g.drawString("YOU LOSS! Max score is: "+currentMaxScore, 90,200);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			UserData data = new UserData(playerName, currentMaxScore);
//			
//			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//			Session session = sessionFactory.openSession();
//			session.beginTransaction();
//			session.update(data);
//			session.getTransaction().commit();
			
			//System.exit(0);
			gf.dispose();
			
			StartFrame frame = new StartFrame();
			frame.setVisible(true);
			frame.setTitle("Start Page");
		}
		g.setColor(c);
		if(currentScore > currentMaxScore) currentMaxScore = currentScore;
	}
	
}
