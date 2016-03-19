package lesson2.frame_2_6.frame_2_6_4;

import java.util.Arrays;

public class Buyer{
static int totalBuyersQty;

private int id;

private String name; //obligatory field
private String surname;//obligatory field
private String birthday;//obligatory field
private Sex sex;
private String address;
private String phone;
private String email;
private FamilyStatus familyStatus;
private int childrenQty;

private String[][] purchases=new String[100][];
private int purchasesDate = 0;
private int purchasesProductId = 1;


public Buyer() {
	++totalBuyersQty;
}

public Buyer(String name, String surname, String birthday, Sex sex, String address, String phone, String email,
		FamilyStatus familyStatus, int childrenQty) {
	++totalBuyersQty;
	this.name = name;
	this.surname = surname;
	this.birthday = birthday;
	this.sex = sex;
	this.address = address;
	this.phone = phone;
	this.email = email;
	this.familyStatus = familyStatus;
	this.childrenQty = childrenQty;
}

public static int getTotalBuyersQty() {
	return totalBuyersQty;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public String getSurname() {
	return surname;
}

public String getBirthday() {
	return birthday;
}

public Sex getSex() {
	return sex;
}

public String getAddress() {
	return address;
}

public String getPhone() {
	return phone;
}

public String getEmail() {
	return email;
}

public FamilyStatus getFamilyStatus() {
	return familyStatus;
}

public int getChildrenQty() {
	return childrenQty;
}

public String[][] getPurchases() {
	return purchases;
}

public int getPurchasesDate() {
	return purchasesDate;
}

public void updatePurchases(Product product, String date){
	
	for (int i = 0; i < purchases.length; i++) {
		if (purchases[i] == null) {
			purchases[i]=new String[2];
			purchases[i][purchasesDate]=date;
			purchases[i][purchasesProductId] = String.valueOf(product.getId());
			return;
		}
	}
	increase();
	updatePurchases(product, date);
}

private void increase() {
	Arrays.copyOf(purchases, (int) (purchases.length * 1.3));
}

}
