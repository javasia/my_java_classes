package lesson3.checkpoint5.frame_3_5_10.tanks;

import java.awt.Color;
import java.awt.Graphics;

import lesson3.checkpoint5.frame_3_5_10.interfaces.Destroyable;
import lesson3.checkpoint5.frame_3_5_10.interfaces.Drawable;

public class Bullet implements Drawable, Destroyable{
	
	private int x;
	private int y;
	private int speed=5;
	private int direction;
	private int originId;
	
	public Bullet (int x, int y, int direction, int originId){
	this.originId=originId;
	this.x=x;	
	this.y=y;	
	this.direction=direction;	
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getSpeed() {
		return speed;
	}
	public int getDirection() {
		return direction;
	}
	
	public int getOriginId() {
		return originId;
	}

	public void updateX (int modifier) {
		x+=modifier;
	}
	
	public void updateY (int modifier) {
		y+=modifier;
	}
	
	public void destroy (){
		x=-100;
		y=-100;
	}
	
	public void draw(Graphics g){
		g.setColor(new Color(255, 255, 0));
		g.fillRect(x, y, 14, 14);
	}
}


