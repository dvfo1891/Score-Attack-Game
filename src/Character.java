
public abstract class Character extends Sprite{
	
	private int[] movements = new int[4];
	
	public int makeMovement(int direction){
		//get walls from gameboard, check if possible given direction, otherwise  
		// return 0
		return 0;
	}
	
	public void removeSprite(){
		//remove sprite from gameboard, act accordingly
		setLocation(null);
		
	}
	public int[] getMovements(){
		return movements;
	}
}
