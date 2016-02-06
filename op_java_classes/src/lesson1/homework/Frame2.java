package lesson1.homework;

public class Frame2 {

	public static void main(String[] args) {
		
		int ms_sec = 1000;
		int ms_min = ms_sec*60;
		int ms_hour = ms_min*60;
		int ms_day = ms_hour*24;

		long days=System.currentTimeMillis()/ms_day;
		long hours=(System.currentTimeMillis()-days*ms_day)/ms_hour;
		long mins=(System.currentTimeMillis()-days*ms_day-hours*ms_hour)/ms_min;
		long secs=(System.currentTimeMillis()-days*ms_day-hours*ms_hour-mins*ms_min)/ms_sec;

		System.out.println(days+":"+hours+":"+mins+":"+secs);


	}
	
}
