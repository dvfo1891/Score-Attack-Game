import java.awt.Color;

public class GreenUnit extends Unit{
	
	Unit otherUnit;
	CollisionMonitor cm;
	
	public GreenUnit(int x, int y, int radius, int speed, GameFrame gf, Direction dir) {
		super(x, y, radius, speed, gf, dir);
		color = Color.GREEN;
		otherUnit = gf.mainUnit;
		cm = new CollisionMonitor(this,otherUnit);
	}
	
	public void collisionConsequence(){
		
		gf.infoMenuBar.currentScore++;
		width-=2;
		height-=2;
	}

}
