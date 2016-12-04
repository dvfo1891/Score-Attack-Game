package com.game.play;

public class ShrinkAndGainPointCollisionFantasy implements CollisionFantasy {

	Unit unit;
	GameFrame gf;
	
	public ShrinkAndGainPointCollisionFantasy(Unit unit) {
		
		this.unit = unit;
		this.gf = unit.gf;
		doFantasy();
	}

	@Override
	public void doFantasy() {
		gf.infoMenuBar.currentScore++;
		if(unit.width >= 3){
		unit.width-=2;
		unit.height-=2;}
	}
}
