package lesson2.frame_2_6.frame_2_6_2;

public class Product {
protected static int totalProducts;
protected static Product[] productsDataBase;

private final int id;

private ProductGroups productGroop;
private String name;
private String deliveryDate;
private String expiryDate;
private int deliveryPeriodDays;
private String supplier;
private String manufacturer;
private String barcode;
private String wareHouseLocation;
private String showroomLocation;
private float purchasePrice;
private float sellPrice;
private float discount;
private int MOQ;
private int qtyStock;
private int qtyShowroom;


public Product() {
	id=returnNewId();
}

private int returnNewId(){
	//code will be here
	return -1;
}

}

