package com.game.play;
import java.awt.Color;

public class GreenUnit extends Unit{
	
	public GreenUnit(int x, int y, int radius, int speed, GameFrame gf, Direction dir) {
		super(x, y, radius, speed, gf, dir);
		color = Color.GREEN;
		anotherUnit = gf.mainUnit;
		cm = new CollisionMonitor(this,anotherUnit);
	}
	
	@Override
	public void collisionConsequence(){
		cf = new ShrinkAndGainPointCollisionFantasy(this);
	}

}
