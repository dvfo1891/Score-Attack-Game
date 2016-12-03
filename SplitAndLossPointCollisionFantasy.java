package com.game.play;
import com.game.play.Unit.Direction;

public class SplitAndLossPointCollisionFantasy implements CollisionFantasy {
	
	Unit unit;
	GameFrame gf;
	int x;
	int y;
	int width;
	Unit.Direction dir;
	
	public SplitAndLossPointCollisionFantasy(Unit unit) {
		super();
		this.unit = unit;
		this.gf = unit.gf;
		this.x = unit.x;
		this.y = unit.y;
		this.width = unit.width;
		this.dir = unit.dir;
		
		doFantasy();
	}

	@Override
	public void doFantasy() {
		
		gf.infoMenuBar.currentScore--;
		
		if(dir == Direction.U){
			gf.units.add(new RedUnit(x,y,width-4,2,gf,Unit.Direction.L));
			gf.units.add(new RedUnit(x,y,width-4,2,gf,Unit.Direction.R));
		}
		if(dir == Direction.D){
			gf.units.add(new RedUnit(x,y,width-4,2,gf,Unit.Direction.L));
			gf.units.add(new RedUnit(x,y,width-4,2,gf,Unit.Direction.R));
		}
		if(dir == Direction.L){
			gf.units.add(new RedUnit(x,y,width-4,2,gf,Unit.Direction.U));
			gf.units.add(new RedUnit(x,y,width-4,2,gf,Unit.Direction.D));
		}
		if(dir == Direction.R){
			gf.units.add(new RedUnit(x,y,width-4,2,gf,Unit.Direction.U));
			gf.units.add(new RedUnit(x,y,width-4,2,gf,Unit.Direction.D));
		}
		if(dir == Direction.LU){
			gf.units.add(new RedUnit(x,y,width-4,2,gf,Unit.Direction.LD));
			gf.units.add(new RedUnit(x,y,width-4,2,gf,Unit.Direction.RU));
		}
		if(dir == Direction.LD){
			gf.units.add(new RedUnit(x,y,width-4,2,gf,Unit.Direction.LU));
			gf.units.add(new RedUnit(x,y,width-4,2,gf,Unit.Direction.RD));
		}
		if(dir == Direction.RU){
			gf.units.add(new RedUnit(x,y,width-4,2,gf,Unit.Direction.LU));
			gf.units.add(new RedUnit(x,y,width-4,2,gf,Unit.Direction.RD));
		}
		if(dir == Direction.RD){
			gf.units.add(new RedUnit(x,y,width-4,2,gf,Unit.Direction.LD));
			gf.units.add(new RedUnit(x,y,width-4,2,gf,Unit.Direction.RU));
		}
	}

}
