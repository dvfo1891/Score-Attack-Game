import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class InfoMenuBar {
	
	public String playerName;
	public int originalScore;
	public int currentScore;
	public int currentMaxScore;
	public final int lifeBarX = 100;
	public final int lifeBarY = 30;
	public final int lifeBarBlockLen = 10;
	
	public InfoMenuBar(String playerName, int originalScore) {
		super();
		this.playerName = playerName;
		this.originalScore = originalScore;
		this.currentMaxScore = originalScore;
		currentScore = 5;
	}
	
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.orange);
		g.drawString("Your Score :", 20, lifeBarY+15);
		g.fillRect(lifeBarX, lifeBarY, lifeBarBlockLen*currentScore, 10+lifeBarBlockLen);
		if(currentScore <= 0){
			Font myFont = new Font("Courier New", 1, 40);
			g.setFont(myFont);
			g.drawString("YOU LOSS! Max score is: "+currentMaxScore, 90,200);
		}
		g.setColor(c);
		if(currentScore > currentMaxScore) currentMaxScore = currentScore;
	}
	
}