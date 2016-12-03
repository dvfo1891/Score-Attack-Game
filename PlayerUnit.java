package com.game.play;

public class PlayerUnit extends Unit{
	
	private static PlayerUnit player;
	
	private PlayerUnit(int x, int y, int radius, int speed, GameFrame gf, Direction dir){
		super(x, y, radius, speed, gf, dir);
	}
	
	public static PlayerUnit getPlayer(GameFrame gf){
		if(player == null){
			player = new PlayerUnit(30,30,30,3, gf, Unit.Direction.STOP) ;
		}
		
		return player;
	}
	
}