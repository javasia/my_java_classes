package lesson4.checkpoint3.frame_4_3_10;

public class Demo {

	public static void main(String[] args) {
	  Address address1 = new Address ("Kyiv", "Avtozavods'ka str.", 5);
	  Address address2 = new Address ("Kyiv", "MATE ZALKY STR", 56);
	  Address address3 = new Address ("NY City", "Park lane ave.", 38);
	  Address address4 = new Address ("Kyiv", "Avtozavods'ka str.", 55);
	  
	   Person person1 = new Person ("Person1 Person1", 18, 1000, address1);
	   Person person2 = new Person ("Person2 Person2", 20, 2000, address2);
	   Person person3 = new Person ("Person3 Person3", 18, 100, address3);
	   Person person4 = new Person ("Person4 Person4", 18, 10000, address4);
	   
	  
	  HashMap data= new HashMap();
	  
	  data.put(person1);
	  data.put(person2);
	  data.put(person3);
	  data.put(person4);
	  
	  
	  
	}

}
