import java.awt.Color;

public class RedUnit extends Unit {
	
	Unit otherUnit;
	CollisionMonitor cm;

	public RedUnit(int x, int y, int radius, int speed, GameFrame gf, Unit.Direction dir) {
		super(x, y, radius, speed, gf, dir);
		color = Color.RED;
		otherUnit = gf.mainUnit;
		cm = new CollisionMonitor(this,otherUnit);
	}
	
	public void collisionConsequence(){
		
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
