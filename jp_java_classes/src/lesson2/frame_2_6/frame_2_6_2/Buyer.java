package lesson2.frame_2_6.frame_2_6_2;

public class Buyer extends Product{
protected static int totalBuyersQty;
protected static Buyer[] buyerDataBase;

private final int id;

private String name; //obligatory field
private String surname;//obligatory field
private String birthday;//obligatory field

private Sex sex;
private String address;
private String phone;
private String email;
private FamilyStatus familyStatus;
private int childrenQty;

private Product[][] purchases;
private int purchasesDate = 0;

public Buyer() {
	id = 0;
	name = "Unundified";
	surname = "Customer";
}

public Buyer (String name, String surname, String birthday){//obligatory fields only;
	id=returnNewId();
	this.name=name;
	this.surname=surname;
	this.birthday=birthday;
}

private int returnNewId(){
	//code will be here
	return -1;
}


}
