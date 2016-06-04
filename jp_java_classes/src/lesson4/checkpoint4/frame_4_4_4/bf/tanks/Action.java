package lesson4.checkpoint4.frame_4_4_4.bf.tanks;

public class Action {

	private Actions action = Actions.IDLE;
	
	public Actions getAction() {
		return action;
	}
	
	public void setAction(Actions action) {
		this.action = action;
	}
	
	public Action() {
		// TODO Auto-generated constructor stub
	}
	
	public Action(Actions action) {
		this.action=action;
	}
	
	

}
