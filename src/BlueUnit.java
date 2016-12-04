package com.game.play;
import java.awt.Color;

public class BlueUnit extends Unit{
	
	public BlueUnit(int x, int y, int radius, int speed, GameFrame gf, Direction dir) {
		super(x, y, radius, speed, gf, dir);
		color = Color.BLUE;
		anotherUnit = gf.mainUnit;
		cm = new CollisionMonitor(this,anotherUnit);
	}
	
	@Override
	public void collisionConsequence(){
		cf = new ExpandAndLossPointCollisionFantasy(this);
	}

}
