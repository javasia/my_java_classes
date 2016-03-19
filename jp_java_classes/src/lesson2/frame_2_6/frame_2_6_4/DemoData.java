package lesson2.frame_2_6.frame_2_6_4;

public class DemoData {

	public Product product = new Product(ProductGroups.BAKERY, "Ukrainian Bread", "11.03.2016", "13.03.2016", 1,
			"Kyivhlib Trading LLC", "Kyivhlib LLC", "48111111111", "H2E233", "A123", 3.00F, 4.25F, 0F, 100, 100, 50);

	public Product product2 = new Product(ProductGroups.BAKERY, "Wheat toast", "10.03.2016", "15.03.2016", 2,
			"Kyivhlib Trading LLC", "Kyivhlib LLC", "48111111122", "H2E233", "A124", 5.00F, 10.25F, 0F, 50, 30, 30);

	public Product product3 = new Product(ProductGroups.MEAT, "argentina beef steaks", "10.03.2016", "13.03.2016", 20,
			"Argentina meets imports LLC", "Argentina Meet Farm LLC", "111334115122", "H2A1", "A1", 500.00F, 900.00F,
			0F, 10, 10, 10);

	public Buyer buyer = new Buyer("John", "Doe", "01.01.1990", Sex.MALE, "Lesi Ukrainky blvrd 15, app. 3", "+380670000001",
			"john.doe@gmail.com", FamilyStatus.SINGLE, 0);
	public Buyer buyer2 = new Buyer("Alice", "Doe", "01.01.1995", Sex.FEMALE, "Lesi Ukrainky blvrd 16, app. 4", "+380670000005",
			"alice.doe@gmail.com", FamilyStatus.MARIED, 2);
	public Buyer buyer3 = new Buyer("Ivan", "Vodkin", "02.03.1970", Sex.MALE, "Kovsmonavtov str 5, app. 64", "+380670000012",
			"ivan.vodkin@gmail.com", FamilyStatus.MARIED, 10);

	
}
