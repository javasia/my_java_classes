package lesson1.checkpoint_1_2;

public class Tank {
	private String color;
	private int crew;
	private int maxSpeed;

	Tank(String color, int crew, int maxSpeed) {
		setColor(color);
		setCrew(crew);
		setMaxSpeed(maxSpeed);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCrew() {
		return crew;
	}

	public void setCrew(int crew) {
		if (crew <= 0) {
			crew = 1;
		}
		this.crew = crew;
	}

	public int getMaxSpeed() {
		if (maxSpeed > 200) {
			maxSpeed = 200;
		}
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

}
