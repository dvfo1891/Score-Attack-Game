package com.game.play;
import java.awt.Color;

public class RedUnit extends Unit {

	public RedUnit(int x, int y, int radius, int speed, GameFrame gf, Unit.Direction dir) {
		super(x, y, radius, speed, gf, dir);
		color = Color.RED;
		anotherUnit = gf.mainUnit;
		cm = new CollisionMonitor(this,anotherUnit);
	}
	
	@Override
	public void collisionConsequence(){
		cf = new SplitAndLossPointCollisionFantasy(this);
	}
		
}
