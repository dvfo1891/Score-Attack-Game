import java.awt.Color;

public class BlueUnit extends Unit{
	
	Unit otherUnit;
	CollisionMonitor cm;
	
	public BlueUnit(int x, int y, int radius, int speed, GameFrame gf, Direction dir) {
		super(x, y, radius, speed, gf, dir);
		color = Color.BLUE;
		otherUnit = gf.mainUnit;
		cm = new CollisionMonitor(this,otherUnit);
	}
	
	public void collisionConsequence(){
		
		gf.infoMenuBar.currentScore--;
		width+=6;
		height+=6;
	}

}
