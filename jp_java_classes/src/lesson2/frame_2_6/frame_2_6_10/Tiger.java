package lesson2.frame_2_6.frame_2_6_10;

public class Tiger extends Tank {
	
	private int armor;
	

	public Tiger(ActionField af, BattleField bf, Type type) {
		super(af, bf, type);
		setColor(Colors.YELLOW);
		setCrew(7);
		armor=1;
		}
	
	public void destroy() throws Exception{
		if (armor ==0){
			y = -100;
			x = -100;
			reborn();
		}else{
			armor--;
		}
	}
	
	private void reborn() throws Exception{
		Tiger tank = new Tiger(af, bf, this.getType());
		af.reborn(tank);
	}

}
