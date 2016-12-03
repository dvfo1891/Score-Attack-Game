package com.game.play;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Unit {
		
	// Necessary instance variables for all kinds of units.
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected int speed;
	protected Color color = Color.BLACK;
	protected GameFrame gf;
	private boolean keyU = false, keyD = false, keyL = false, keyR = false;
	enum Direction{U,D,L,R,LU,LD,RU,RD,STOP};
	protected Direction dir = Direction.STOP;
	
	// Necessary instance variables for all enemy units(red,blue) and food units(green).
	public Unit anotherUnit;
	public CollisionMonitor cm;
	public CollisionFantasy cf;
	
	// Constructor: Initialize unit's states and scale. And pass in the reference of GameFrame.
	public Unit(int x, int y, int radius, int speed, GameFrame gf, Direction dir) {
		this.x = x;
		this.y = y;
		this.width = radius;
		this.height = radius;
		this.speed = speed;
		this.gf = gf;
		this.dir = dir;
	}

	// Perform some fantasies after collision with main unit.
	// This method is for enemy units and food units.
	public void collisionConsequence() {}
	
	// Draw this unit.
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(color);
		g.fillOval(x-width/2, y-height/2, width, height);
		g.setColor(c);
		
		move();
	}
	
	// Modify unit's coordinates to make it move based on current direction.
	// If unit touches wall, modify its direction.
	public void move(){
		
		switch(dir){
		case STOP:
			break;
		case L:
			if(x<=width/2 && y<=height/2)
				dir = Direction.RD;
			else if(x<=width/2 && y>= GameFrame.HEIGHT-height/2)
				dir = Direction.RU;
			else if(x<=width/2)
				dir = Direction.R;
			else
				x -= speed;
			break;
		case R:
			if(x>= GameFrame.WIDTH-(width/2) && y<=height/2)
				dir = Direction.LD;
			else if(x>= GameFrame.WIDTH-(width/2) && y>= GameFrame.HEIGHT-height/2)
				dir = Direction.LU;
			else if(x>= GameFrame.WIDTH-(width/2))
				dir = Direction.L;
			else
				x += speed;
			break;
		case U:
			if(x<=width/2 && y<=height/2)
				dir = Direction.RD;
			else if(x>= GameFrame.WIDTH-(width/2) && y<=height/2)
				dir = Direction.LD;
			else if(y<=height/2)
				dir = Direction.D;
			else
				y -= speed;
			break;
		case D:
			if(x<=width/2 && y>= GameFrame.HEIGHT-height/2)
				dir = Direction.RU;
			else if(x>= GameFrame.WIDTH-(width/2) && y>= GameFrame.HEIGHT-height/2)
				dir = Direction.LU;
			else if(y>= GameFrame.HEIGHT-height/2)
				dir = Direction.U;
			else
				y += speed;
			break;
		case LU:
			if(x<=width/2 && y<=height/2)
				dir = Direction.RD;
			else if(x<=width/2)
				dir = Direction.RU;
			else if(y<=height/2)
				dir = Direction.LD;
			else
				x -= speed;
				y -= speed;
			break;
		case LD:
			if(x<=width/2 && y>= GameFrame.HEIGHT-height/2)
				dir = Direction.RU;
			else if(x<=width/2)
				dir = Direction.RD;
			else if(y>= GameFrame.HEIGHT-height/2)
				dir = Direction.LU;
			else
				x -= speed;
				y += speed;
			break;
		case RU:
			if(x>= GameFrame.WIDTH-(width/2) && y<=height/2)
				dir = Direction.LD;
			else if(x>= GameFrame.WIDTH-(width/2))
				dir = Direction.LU;
			else if(y<=height/2)
				dir = Direction.RD;
			else
				x += speed;
				y -= speed;
			break;
		case RD:
			if(x>= GameFrame.WIDTH-(width/2) && y>= GameFrame.HEIGHT-height/2)
				dir = Direction.LU;
			else if(x>= GameFrame.WIDTH-(width/2))
				dir = Direction.LD;
			else if(y>= GameFrame.HEIGHT-height/2)
				dir = Direction.RU;
			else
				x += speed;
				y += speed;
			break;
		}
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_LEFT:
			keyL = true;
			break;
		case KeyEvent.VK_RIGHT:
			keyR = true;
			break;
		case KeyEvent.VK_UP:
			keyU = true;
			break;
		case KeyEvent.VK_DOWN:
			keyD = true;
			break;
		}
		
		if (keyU == false && keyD == false && keyL == false && keyR == false)
			dir = Direction.STOP;
		if (keyU == true && keyD == false && keyL == false && keyR == false)
			dir = Direction.U;
		if (keyU == false && keyD == true && keyL == false && keyR == false)
			dir = Direction.D;
		if (keyU == false && keyD == false && keyL == true && keyR == false)
			dir = Direction.L;
		if (keyU == false && keyD == false && keyL == false && keyR == true)
			dir = Direction.R;
		if (keyU == true && keyD == false && keyL == true && keyR == false)
			dir = Direction.LU;
		if (keyU == false && keyD == true && keyL == true && keyR == false)
			dir = Direction.LD;
		if (keyU == true && keyD == false && keyL == false && keyR == true)
			dir = Direction.RU;
		if (keyU == false && keyD == true && keyL == false && keyR == true)
			dir = Direction.RD;
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_LEFT:
			keyL = false;
			break;
		case KeyEvent.VK_RIGHT:
			keyR = false;
			break;
		case KeyEvent.VK_UP:
			keyU = false;
			break;
		case KeyEvent.VK_DOWN:
			keyD = false;
			break;
		}
	}
		
	public void setDirectionUp(){dir = Direction.U;}
	public void setDirectionDown(){dir = Direction.D;}
	public void setDirectionLeft(){dir = Direction.L;}
	public void setDirectionRight(){dir = Direction.R;}
	public void setDirectionLU(){dir = Direction.LU;}
	public void setDirectionLD(){dir = Direction.LD;}
	public void setDirectionRU(){dir = Direction.RU;}
	public void setDirectionRD(){dir = Direction.RD;}
	public void setDirectionStop(){dir = Direction.STOP;}
	
	//Getters and Setters
	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	
	

}
