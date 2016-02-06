package lesson1.checkpoint_1_1;

public class GreetingService {

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println(
					"Usage: GreetingService <name> <surname> \nto print \"Hello\" + name and surname to console)");
			return;

		}
		System.out.println("Hello " + args[0] + " " + args[1]);
	}
}
