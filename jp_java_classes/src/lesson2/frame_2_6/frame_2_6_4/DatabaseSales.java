package lesson2.frame_2_6.frame_2_6_4;

import java.util.Arrays;

public class DatabaseSales {

	String[][] database;
	private final int SALES_DATE = 0;
	private final int SALES_PRODUCT_ID = 1;
	private final int SALES_PRODUCT_NAME = 2;
	private final int SALES_PRODUCT_PRICE = 3;
	private final int SALES_BUYER_ID = 4;
	private final int SALES_BUYER_NAME = 5;
	private final int SALES_QTY = 6;

	public String[][] getDatabase() {
		return database;
	}

	public DatabaseSales() {
		database = new String[500][];
	}

	public void write(String date, Product product, Buyer buyer, String qty) {
		int idx = returnIdx();
		database[idx] = new String[7];
		database[idx][SALES_DATE] = "Date: " + date;
		database[idx][SALES_PRODUCT_ID] = "Products ID: " + String.valueOf(product.getId());
		database[idx][SALES_PRODUCT_NAME] = "Prodcut name: " + product.getName();
		database[idx][SALES_PRODUCT_PRICE] = "Prodcut sales price: " + product.getSellPrice();
		database[idx][SALES_BUYER_ID] = "Buyers ID: " + String.valueOf(buyer.getId());
		database[idx][SALES_BUYER_NAME] = "Buyers name and surname: " + buyer.getName() + " " + buyer.getSurname();
		database[idx][SALES_QTY] = "Quantity sold: " + qty;
	}

	private int returnIdx() {
		for (int i = 0; i < database.length; i++) {
			if (database[i] == null) {
				return i;
			}
		}
		int res = database.length;
		increase();
		return res;
	}

	private void increase() {
		Arrays.copyOf(database, (int) (database.length * 1.3));
	}
}
