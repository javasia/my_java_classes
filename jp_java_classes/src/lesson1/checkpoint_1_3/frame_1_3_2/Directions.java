package lesson1.checkpoint_1_3.frame_1_3_2;

public enum Directions {

	RIGHT(0), LEFT(1), UP(2), DOWN(3);
	
	int id;
	
	Directions(int id){
		this.id=id;
		getId();
	}
	
	int getId(){
		return id;
	}
	
}
