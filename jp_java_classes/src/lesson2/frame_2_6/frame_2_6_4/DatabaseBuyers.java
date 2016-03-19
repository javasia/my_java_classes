package lesson2.frame_2_6.frame_2_6_4;

public class DatabaseBuyers {

	private Buyer[] database;
	
	public DatabaseBuyers() {
		database = new Buyer[(int)(Buyer.totalBuyersQty*1.3)];
	}

	public Buyer[] getDatabase() {
		return database;
	}
	
	public int write(Buyer buyer) {
		for (int i = 0; i < database.length; i++) {
			if (database[i] == null) {
				buyer.setId(i);
				database[i] = buyer;
				return i;
			}
		}
		return -1;
	}
	
	public void updatePurchases(Product product, String date, int id){
		database[id].updatePurchases(product, date);
	}
	

}
