package lesson4.checkpoint4.frame_4_4_4.bf.tanks;

import java.awt.Color;

import lesson4.checkpoint4.frame_4_4_4.bf.BFObject;
import lesson4.checkpoint4.frame_4_4_4.bf.BattleField;

public interface Tank extends BFObject{

	public void setTowerColor(Color towerColor);

	public void setBodyColor(Color bodyColor);

	public int getX();

	public void setX(int x);

	public int getY();

	public void setY(int y);

	public void setArmor(int armor);

	public int getCrew();

	public void setCrew(int crew);

	public void setSpeed(int speed);

	public Type getType();

	public void setType(Type type);

	public BattleField getBf();

	public int getSpeed();

	public int getDirection();

	public void setDirection(int direction);

	public int getId() ;

	public void fire() throws Exception;

	public void move() throws Exception;

	public void turn(int direction);

	public void upgradeY(int modifier);

	public void upgradeX(int modifier);
	
	public void reborn() throws Exception;
		
	public Action tankSetUp();
	
	
}
