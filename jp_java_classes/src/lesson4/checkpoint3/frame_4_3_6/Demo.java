package lesson4.checkpoint3.frame_4_3_6;

public class Demo {

	public static void main(String[] args) {
		Person person1 = new Person("Person1 Person1", 18, 1000);
		Person person2 = new Person("Person2 Person2", 20, 2000);
		Person person3 = new Person("Person1 Person1", 18, 1000);

		System.out.println("Person 1 hashCode()" + person1.hashCode());
		System.out.println("Person 2 hashCode()" + person2.hashCode());
		System.out.println("Person 3 hashCode()" + person3.hashCode());

		System.out.println("person1.equals(person2):" + person1.equals(person2));
		System.out.println("person1.equals(person3)" + person1.equals(person3));

		if (person1.equals(person3) == true && person1.hashCode() == person3.hashCode()) {

			System.out.println("Okay!");

		}
	}

}
