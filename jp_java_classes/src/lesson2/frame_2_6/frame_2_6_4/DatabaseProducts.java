package lesson2.frame_2_6.frame_2_6_4;

public class DatabaseProducts {

	private Product[] database;
	
	public DatabaseProducts() {

	database=new Product[(int)(Product.totalProducts*1.3)];	

	}
	
	public Product[] getDatabase() {
		return database;
	}
	
	public int write(Product product) {
		for (int i = 0; i < database.length; i++) {
			if (database[i] == null) {
				product.setId(i);
				database[i] = product;
				return i;
			}
		}
		return -1;
	}
	
	public void updateStockQuantity(int id, int qty){
		int stockQty=database[id].getQtyStock();
		database[id].setQtyStock(stockQty-qty);
	}

}
