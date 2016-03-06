package lesson2.checkpoint_2_4;

public class Frame_2_4_5 {

	public static void main(String[] args) {

		int monthlyPayment = 5000*24;
		double interest = 15;
		int goalAmount = 200_000*27;

		darkZone(monthlyPayment, interest, goalAmount);

	}

	private static void darkZone(int monthlyPayment, double interest, int goalAmount) {

		double curAmount = 0;
		int months = 0;

		while (curAmount < (double) goalAmount) {
			curAmount += curAmount * (interest / 100 / 12);
			curAmount += monthlyPayment;
			months++;
		}

		int years = months/12;
		months %= 12;
		
		System.out.println("Years: "+ years + ". Months: "+months);
	}
}
