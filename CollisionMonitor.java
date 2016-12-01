package com.game.play;
/* Detect the collision of two Unit objects.
 * Input : references of two Unit objects in instantiation.
 * When collision happens, call collisionConsequence() of the first Unit object.
 * */
class CollisionMonitor{
		
	int collisionTimes = 0;
	Unit unit1;
	Unit unit2;
	double unit1X;
	double unit1Y;
	double unit1Radius;
	double unit2X;
	double unit2Y;
	double unit2Radius;
	
	public CollisionMonitor(Unit unit1, Unit unit2) {
		this.unit1 = unit1;
		this.unit2 = unit2;
		new Thread(new CollisionMoniterThread()).start();
	}
	
	private double centerDistance(){
		unit1X = unit1.x;
		unit1Y = unit1.y;
		unit2X = unit2.x;
		unit2Y = unit2.y;
		double centerDistance = Math.sqrt((unit1X-unit2X)*(unit1X-unit2X)+(unit1Y-unit2Y)*(unit1Y-unit2Y));
		return centerDistance;
	}
		
	private boolean touch(){
		unit1Radius = unit1.width;
		unit2Radius = unit2.width;
		boolean touch = (centerDistance() < (unit2Radius/2)+(unit1Radius/2));
		System.out.print("");
		return touch;
	}
		
	private boolean seperate(){
		unit1Radius = unit1.width;
		unit2Radius = unit2.width;
		double unit1Radius = unit1.width;
		boolean seperate = (centerDistance() > (unit2Radius/2)+(unit1Radius/2)+3);
		System.out.print("");
		return seperate;
	}
		
	public boolean isHit(){
		if(touch()){
			while(!seperate()){}
			collisionTimes ++;
			//System.out.println("第"+collisionTimes+"次碰撞");
			unit1.collisionConsequence();
			return true;
			}
		return false;
	}
	
	public class CollisionMoniterThread implements Runnable{

		public void run() {
			while(true){
				isHit();
			}
		}
		
	}
		
}