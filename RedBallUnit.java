import java.awt.Color;

public class RedBallUnit extends Unit {
	
	Unit otherUnit;
	CollisionMonitor cm;

	public RedBallUnit(int x, int y, int radius, int speed, GameFrame gf, Unit.Direction dir) {
		super(x, y, radius, speed, gf, dir);
		color = Color.RED;
		otherUnit = gf.hero;
		cm = new CollisionMonitor(this,otherUnit);
	}
	
	public void collisionFantasy(){
		System.out.println("卧了个槽了");
		if(dir == Direction.U){
			gf.units.add(new RedBallUnit(x,y,width-4,2,gf,Unit.Direction.L));
			gf.units.add(new RedBallUnit(x,y,width-4,2,gf,Unit.Direction.R));
		}
		if(dir == Direction.D){
			gf.units.add(new RedBallUnit(x,y,width-4,2,gf,Unit.Direction.L));
			gf.units.add(new RedBallUnit(x,y,width-4,2,gf,Unit.Direction.R));
		}
		if(dir == Direction.L){
			gf.units.add(new RedBallUnit(x,y,width-4,2,gf,Unit.Direction.U));
			gf.units.add(new RedBallUnit(x,y,width-4,2,gf,Unit.Direction.D));
		}
		if(dir == Direction.R){
			gf.units.add(new RedBallUnit(x,y,width-4,2,gf,Unit.Direction.U));
			gf.units.add(new RedBallUnit(x,y,width-4,2,gf,Unit.Direction.D));
		}
		if(dir == Direction.LU){
			gf.units.add(new RedBallUnit(x,y,width-4,2,gf,Unit.Direction.LD));
			gf.units.add(new RedBallUnit(x,y,width-4,2,gf,Unit.Direction.RU));
		}
		if(dir == Direction.LD){
			gf.units.add(new RedBallUnit(x,y,width-4,2,gf,Unit.Direction.LU));
			gf.units.add(new RedBallUnit(x,y,width-4,2,gf,Unit.Direction.RD));
		}
		if(dir == Direction.RU){
			gf.units.add(new RedBallUnit(x,y,width-4,2,gf,Unit.Direction.LU));
			gf.units.add(new RedBallUnit(x,y,width-4,2,gf,Unit.Direction.RD));
		}
		if(dir == Direction.RD){
			gf.units.add(new RedBallUnit(x,y,width-4,2,gf,Unit.Direction.LD));
			gf.units.add(new RedBallUnit(x,y,width-4,2,gf,Unit.Direction.RU));
		}

	}
		
}
