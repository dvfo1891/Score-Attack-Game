import java.awt.Image;

import javax.tools.JavaFileManager.Location;

public abstract class Sprite {
	private Image pixels;
	/**
	 * @param pixels the pixels to set
	 */
	public void setPixels(Image pixels) {
		this.pixels = pixels;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(Location position) {
		this.position = position;
	}
	private Location position;
	/**
	 * @return the pixels
	 */
	
	public Image getPixels() {
		return pixels;
	}
	public Location getPosition(){
		return position;
	}
	
	public void setLocation(Location newLocation){
		position = newLocation;
	}
	abstract void removeSprite();
	
	

}
