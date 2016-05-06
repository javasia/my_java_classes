package lesson4.checkpoint3.frame_4_3_8;

public class Demo {

	public static void main(String[] args) {
	  Address address1 = new Address ("Kyiv", "Avtozavods'ka str.", 5);
	  Address address2 = new Address ("Kyiv", "MATE ZALKY STR", 56);
	  Address address3 = new Address ("NY City", "Park lane ave.", 38);
	  Address address4 = new Address ("Kyiv", "Avtozavods'ka str.", 5);
	  
	   Person person1 = new Person ("Person1 Person1", 18, 1000, address1);
	   Person person2 = new Person ("Person2 Person2", 20, 2000, address2);
	   Person person3 = new Person ("Person1 Person1", 18, 1000, address3);
	   Person person4 = new Person ("Person1 Person1", 18, 1000, address4);
	   
	   System.out.println("Person 1 hashCode()"+person1.hashCode());
	   System.out.println("Person 2 hashCode()"+person2.hashCode());
	   System.out.println("Person 3 hashCode()"+person3.hashCode());
	   System.out.println("Person 4 hashCode()"+person4.hashCode());
	   
	   System.out.println("person1.equals(person2):"+person1.equals(person2));
	   System.out.println("person1.equals(person3)"+person1.equals(person3));
	   System.out.println("person1.equals(person4)"+person1.equals(person4));
	   

	   
	     if (person1.equals(person4)==true && person1.hashCode() == person4.hashCode()){
	       
	       System.out.println("Okay!");
	       
	   }
	}

}
