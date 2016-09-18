import java.awt.Image;

import javax.tools.JavaFileManager.Location;

public class Player extends Character {
	private int lives;
	private Location start;
	private Image playerIcon;
	public Player(){
		lives = 3;
		setPixels(playerIcon);
		setLocation(start);
	}
	public Player(Location start){
		lives = 3;
		setPixels(playerIcon);
		setLocation(start);
		
	}
	public void removeLive(){
		lives--;
	}
	public void deathAnimation(){
		//play the death animation
	}
	public void resetLocation(){
		setLocation(start);
	}
}
