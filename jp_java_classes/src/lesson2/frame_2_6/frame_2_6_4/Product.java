package lesson2.frame_2_6.frame_2_6_4;

public class Product {
static int totalProducts;

private int id;

public void setId(int id) {
	this.id = id;
}

public int getId() {
	return id;
}



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
private int moq;
private int qtyStock;
private int qtyShowroom;

public ProductGroups getProductGroop() {
	return productGroop;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public String getDeliveryDate() {
	return deliveryDate;
}



public void setDeliveryDate(String deliveryDate) {
	this.deliveryDate = deliveryDate;
}



public String getExpiryDate() {
	return expiryDate;
}



public void setExpiryDate(String expiryDate) {
	this.expiryDate = expiryDate;
}



public int getDeliveryPeriodDays() {
	return deliveryPeriodDays;
}



public void setDeliveryPeriodDays(int deliveryPeriodDays) {
	this.deliveryPeriodDays = deliveryPeriodDays;
}



public String getSupplier() {
	return supplier;
}



public void setSupplier(String supplier) {
	this.supplier = supplier;
}



public String getManufacturer() {
	return manufacturer;
}



public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}



public String getBarcode() {
	return barcode;
}



public void setBarcode(String barcode) {
	this.barcode = barcode;
}



public String getWareHouseLocation() {
	return wareHouseLocation;
}



public void setWareHouseLocation(String wareHouseLocation) {
	this.wareHouseLocation = wareHouseLocation;
}



public String getShowroomLocation() {
	return showroomLocation;
}



public void setShowroomLocation(String showroomLocation) {
	this.showroomLocation = showroomLocation;
}



public float getPurchasePrice() {
	return purchasePrice;
}



public void setPurchasePrice(float purchasePrice) {
	this.purchasePrice = purchasePrice;
}



public float getSellPrice() {
	return sellPrice;
}



public void setSellPrice(float sellPrice) {
	this.sellPrice = sellPrice;
}



public float getDiscount() {
	return discount;
}



public void setDiscount(float discount) {
	this.discount = discount;
}



public int getMoq() {
	return moq;
}



public void setMoq(int moq) {
	this.moq = moq;
}



public int getQtyStock() {
	return qtyStock;
}



public void setQtyStock(int qtyStock) {
	this.qtyStock = qtyStock;
}



public int getQtyShowroom() {
	return qtyShowroom;
}



public void setQtyShowroom(int qtyShowroom) {
	this.qtyShowroom = qtyShowroom;
}



public Product() {
	totalProducts++;
}



public Product(ProductGroups productGroop, String name, String deliveryDate, String expiryDate,
		int deliveryPeriodDays, String supplier, String manufacturer, String barcode, String wareHouseLocation,
		String showroomLocation, float purchasePrice, float sellPrice, float discount, int moq, int qtyStock,
		int qtyShowroom) {
	++totalProducts;
	this.productGroop = productGroop;
	this.name = name;
	this.deliveryDate = deliveryDate;
	this.expiryDate = expiryDate;
	this.deliveryPeriodDays = deliveryPeriodDays;
	this.supplier = supplier;
	this.manufacturer = manufacturer;
	this.barcode = barcode;
	this.wareHouseLocation = wareHouseLocation;
	this.showroomLocation = showroomLocation;
	this.purchasePrice = purchasePrice;
	this.sellPrice = sellPrice;
	this.discount = discount;
	this.moq = moq;
	this.qtyStock = qtyStock;
	this.qtyShowroom = qtyShowroom;
}

}

