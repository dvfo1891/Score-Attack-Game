package com.game.play;

public class ExpandAndLossPointCollisionFantasy implements CollisionFantasy {
	Unit unit;
	GameFrame gf;
	
	public ExpandAndLossPointCollisionFantasy(Unit unit) {
		this.unit = unit;
		this.gf = unit.gf;

		doFantasy();
	}

	@Override
	public void doFantasy() {
		gf.infoMenuBar.currentScore--;
		unit.width+=6;
		unit.height+=6;
	}
}
