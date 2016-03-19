package lesson2.frame_2_6.frame_2_6_4;

public class Database {
	
	protected DatabaseProducts products;
	protected DatabaseBuyers buyers;
	protected DatabaseSales sales;

	public Database() {
		products = new DatabaseProducts();
		buyers = new DatabaseBuyers();
		sales = new DatabaseSales();
	}
}
