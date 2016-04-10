package lesson3.checkpoint5.frame_3_5_10.service;

import java.util.Arrays;

import lesson3.checkpoint5.frame_3_5_10.tanks.AbstractTank;

public class Logic {
	
	protected BattleField bf;
	protected AbstractTank abstractTank;
	private final int DIRECTION_UP =1, DIRECTION_DOWN=2, DIRECTION_LEFT=3, DIRECTION_RIGHT=4;
	
	public Logic(BattleField bf) {
		this.bf=bf;
	}
	
	public int[] getBrickQuadrant() {

		int[][] brickQuadrants = new int[(bf.getDimentionY()) * (bf.getDimentionX())][];

		if (!bf.returnAllBrickQuadrants(brickQuadrants, "B")) {
			return null;
		}

		int[] nearestBrickQuad = null;
		int[] curTankQuad = getQuadrant(abstractTank.getX(), abstractTank.getY());
		int distanceToTankTemp = 100;

		for (int i = 0; brickQuadrants[i] != null && i < brickQuadrants.length; i++) {
			int distanceToTankY = curTankQuad[0] - brickQuadrants[i][0];
			int distanceToTankX = curTankQuad[1] - brickQuadrants[i][1];

			if (distanceToTankY < 0) {
				distanceToTankY *= -1;
			}
			if (distanceToTankX < 0) {
				distanceToTankX *= -1;
			}

			int distanceToTank = distanceToTankX + distanceToTankY;

			if (distanceToTank < distanceToTankTemp) {
				distanceToTankTemp = distanceToTank;
				nearestBrickQuad = brickQuadrants[i];
			}
		}

		System.out.println("nearestBrickQuad:" + Arrays.toString(nearestBrickQuad));
		return nearestBrickQuad;
	}
	
	public void goKillNext(int v, int h) throws Exception {

		int newX = h * bf.getCELL_SIZE();
		int newY = v * bf.getCELL_SIZE();
		int x=abstractTank.getX();
		int y=abstractTank.getY();
		
//to do -- check distance then fire or move (bullet speed / tank speed x cells)
// to do mistake due to move getHorVerdirection
		while (newX != x || newY != y) { 
			if (newX != x) {
				abstractTank.turn(getHorDirection(newX));
				if (checkBrick(getHorDirection(newX),"B")) {
					abstractTank.fire();
					return;
				}
				abstractTank.move();
			}
			if (newY != y) {
				abstractTank.turn(getVertDirection(newY));
				if (checkBrick(getVertDirection(newY),"B")) {
					abstractTank.fire();
					return;
				}
				abstractTank.move();
			}
		}
	}
	
	private boolean checkBrick(int newDirection, String object) throws Exception {
		int quadX = getQuadrant(abstractTank.getX(), abstractTank.getY())[1];
		int quadY = getQuadrant(abstractTank.getX(), abstractTank.getY())[0];

		int[][] modifier = returnDirModifier();

		int horModifier = modifier[newDirection - 1][1];
		int verModifier = modifier[newDirection - 1][0];

		if (bf.scanQuadrant(quadY + verModifier, quadX + horModifier).equals(object)) {
			System.out.println("found brick at Y:" + (quadY + verModifier) + "X:" + (quadX + horModifier));
			return true;
		}

		return false;
	}
	
	private int[][] returnDirModifier() {
		int[][] dirModifier = new int[4][];
		dirModifier[0] = new int[] { -1, 0 };
		dirModifier[1] = new int[] { 1, 0 };
		dirModifier[2] = new int[] { 0, -1 };
		dirModifier[3] = new int[] { 0, 1 };
		return dirModifier;
	}
	
	private int getHorDirection(int tankCoordXPix) {
		if (tankCoordXPix > abstractTank.getX()) {
			return DIRECTION_RIGHT;
		}else if(tankCoordXPix < abstractTank.getX()){
			return DIRECTION_LEFT;
		}
		return abstractTank.getDirection();
	}

	private int getVertDirection(int tankCoordYPix) {
		if (tankCoordYPix > abstractTank.getY()) {
			return DIRECTION_DOWN;
		}else if (tankCoordYPix < abstractTank.getY()){
			return DIRECTION_UP;
		}
		return abstractTank.getDirection();
	}
	
	private int[] getQuadrant(int x, int y) {
		int[] res = { y / bf.getCELL_SIZE(), x / bf.getCELL_SIZE() };
		return res;
	}
	
	public int returnShotDirection(String object) {

		int y = getQuadrant(abstractTank.getX(), abstractTank.getY())[0];
		int x = getQuadrant(abstractTank.getX(), abstractTank.getY())[1];

		int[][] dirModifier = returnDirModifier();
		
		int maxFieldDimetion;
		
		if (bf.getDimentionX()>=bf.getDimentionY()){
			maxFieldDimetion=bf.getDimentionX();
		}else{
			maxFieldDimetion=bf.getDimentionY();			
		}

		for (int step = 0; step < maxFieldDimetion; step++) {
			for (int i = 0; i <= 3; i++) {
				int stepY = checkStepBoundary(y, step, dirModifier[i][0], bf.getDimentionY()-1);
				int stepX = checkStepBoundary(x, step, dirModifier[i][1], bf.getDimentionX()-1);
				if (bf.scanQuadrant(stepY, stepX).equals(object)) {
					return i + 1;
				}
			}
		}
		return -1;
	}
	
	private int checkStepBoundary(int coord, int step, int modifier, int maxDimentionQuadrants) {
		int res = coord + (modifier * step);
		if (res < 0) {
			return 0;
		}
		if (res > maxDimentionQuadrants) {
			return maxDimentionQuadrants;
		}
		return res;
	}
	
	public void putTankInCenter() {
		bf.updateQuadrant(4, 4, "");;
		abstractTank.setX(4 * bf.getCELL_SIZE()); 
		abstractTank.setY(abstractTank.getX());
	}
	public void putTankToRndAttackerPos() {
		
		int [][] pos = new int [3][];
		pos[0]= new int[]{0,0};
		pos[1]= new int[]{0,8};
//		pos[0]= new int[]{0,4};
//		pos[1]= new int[]{0,4};
		pos[2]= new int[]{0,4};
		
		int rndPos=0;
		while (rndPos<=0 || rndPos>3){
		rndPos = (int) (Math.random()*10);
		}
		
		int y = pos[rndPos-1][0];
		int x = pos[rndPos-1][1];
		
		bf.updateQuadrant(y, x, "");;
		abstractTank.setX(x * bf.getCELL_SIZE()); 
		abstractTank.setY(y * bf.getCELL_SIZE());
	
	}
	public void putTankToRndDefenderPos() {
		
		int [][] pos = new int [3][];
		pos[0]= new int[]{8,0};
		pos[1]= new int[]{8,8};
//		pos[0]= new int[]{8,4};
//		pos[1]= new int[]{8,4};
		pos[2]= new int[]{8,4};
		
		int rndPos=0;
		while (rndPos<=0 || rndPos>3){
			rndPos = (int) (Math.random()*10);
		}
		
		int y = pos[rndPos-1][0];
		int x = pos[rndPos-1][1];
		
		bf.updateQuadrant(y, x, "");;
		abstractTank.setX(x * bf.getCELL_SIZE()); 
		abstractTank.setY(y * bf.getCELL_SIZE());
		
	}

}
