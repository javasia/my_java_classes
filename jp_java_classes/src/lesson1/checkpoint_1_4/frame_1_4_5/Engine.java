package lesson1.checkpoint_1_4.frame_1_4_5;

public class Engine {

	private int MAX_TEMPERATURE=1000;
	private boolean isRunning;
	private boolean isOkay;
	private int temperature;
	private long lastCheckTemperatureTime;
	private String system;
	private int horsePower;
	
	Engine (String system, int horsePower) {
		this.system=system;
		this.horsePower=horsePower;
		isOkay=true;
		System.out.println("Engine system: "+system);
		System.out.println("Engine HP: "+horsePower);
	}

	public int getTemperature() {
		return temperature;
	}
	
	public void updateTemperature(int tempModifier) {
		temperature+=tempModifier;
		System.out.println("Engine temperature updated. New engine temp: "+temperature);
		if (this.temperature>MAX_TEMPERATURE){
			blowUp();
		}else if (this.temperature<=0){
			stop();
		}
	}
	
	private void blowUp(){
		stop();
		isOkay=false;
		System.out.println("Engine blow up!");
	}

	public String getSystem() {
		return system;
	}

	public int getHorsePower() {
		return horsePower;
	}
	
	void start(){
		isRunning=true;
		System.out.println("Engine started...");
		lastCheckTemperatureTime = System.currentTimeMillis();
	}
	
	void stop (){
		isRunning=false;
		System.out.println("Engine stopped...");
		lastCheckTemperatureTime = System.currentTimeMillis();
	}
	
	public int returnTimeSinceLastStartStop() {
		long milis = System.currentTimeMillis() - lastCheckTemperatureTime;
		int hr = (int) (milis / (1000 * 60 * 60));
		System.out.println("Hours since last lastCheckTemperatureTime: "+ hr);
		return hr;
	}

	
}
