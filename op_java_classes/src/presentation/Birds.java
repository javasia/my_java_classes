package presentation;

import java.util.Arrays;

public class Birds {

	static final int MAX_ITEMS = 10;

	static final int NAME = 0;
	static final int QTY = 1;
	static final int PRICE = 2;
	static final int SOLD = 3;

	static int databaseLastWroteIdx = 0;

	static String[][] data = buildData();
	static String[][] sold = new String[3][];

	public static void main(String[] args) throws Exception {

		writeSampleData();

		printRange(data);

		// System.out.println("returnSold(String \"name\") returns int of sold
		// pieces of the items Name.");
		// System.out.print("Sold falcons: ");
		// System.out.println(returnSold("falcon"));

		
		// System.out.println(
		// "returnAvaiableItems(String \"name\") returns int of pieces of the
		// items Name avaiable on stock.");
		// System.out.print("Falcons available on stock: ");
		// System.out.println(returnAvailableItems("falcon"));
		//
		//
		//
		// System.out.println(
		// "returnLowStock(int number) returns String[][] containing names and
		// qty on stock of the items "
		// + "less than int number.");
		// System.out.print("Items low in stock: ");
		// printRange(returnLowStock(3));

		//
		//
		// System.out.println("returnMoneyOnStock() returns double amount of all
		// item price times qty on stock.");
		// System.out.println("Money on stock: " + returnMoneyOnStock());

		//
		//
		// System.out.println("returnTotalMoneyEarned() returns double amount of
		// all item price times qty sold.");
		// System.out.println("Money earned from sales totals: " +
		// returnTotalMoneyEarned());
		// System.out.println();
		//
		//
		//
		// System.out.println("updatePrice(String \"name\", double price) writes
		// double price of the item String name.");
		// printRange(data);
		// System.out.println("Update price...");
		// updatePrice("chicken", 16.50);
		// printRange(data);
		//
		//
		//
//		 System.out.println("sell(String \"name\", int qty) sells qty of item name. \n"
//		 + "Returns String[] of what was sold: name, qty, price.\n"
//		 + "Records sold data into sold database. Cleanes up main database if 0 stock remained.");
//		
//		 System.out.println("Sell: ");
//		 System.out.println("sell returns: "+Arrays.toString(sell("chicken", 2)));
//		 System.out.println("sell returns: "+Arrays.toString(sell("duck", 2)));
//		 System.out.println("sell returns: "+Arrays.toString(sell("pinguin", 5)));
//		 System.out.println("sell returns: "+Arrays.toString(sell("eagle", 14)));
//		 System.out.println("sell returns: "+Arrays.toString(sell("kiwi", 10)));
//		 System.out.println("Main data base: ");
//		 printRange(data);
//		 System.out.println("Sold data base: ");
//		 printRange(sold);

		
		
		 System.out.println("takeNewGoodsOnCharge(String \"name\", int qty,"+
		 "double price) takes new goods on charge.");
		 printRange(data);
		 System.out.println("takeNewGoodsOnCharge raven: ");
		 takeNewGoodsOnCharge("raven", 166, 10.50);
		 System.out.println();
		 System.out.println("takeNewGoodsOnCharge duck:");
		 takeNewGoodsOnCharge("duck", 166, 10.50);
		 System.out.println("takeNewGoodsOnCharge titmouse: ");
		 takeNewGoodsOnCharge("titmouse", 100, 11.50);
		 printRange(data);
		 System.out.println("Exceeding array.legth: ");
		 System.out.println("takeNewGoodsOnCharge pheasant,ostrich,humming-bird,seagull: ");
		 takeNewGoodsOnCharge("pheasant", 100, 11.50);
		 takeNewGoodsOnCharge("ostrich", 100, 11.50);
		 takeNewGoodsOnCharge("humming-bird", 100, 11.50);
		 takeNewGoodsOnCharge("seagull", 100, 11.50);
		 printRange(data);

	}

	static String[][] buildData() {
		String[] name = new String[MAX_ITEMS];
		String[] qty = new String[MAX_ITEMS];
		String[] price = new String[MAX_ITEMS];
		String[] sold = new String[MAX_ITEMS];

		String[][] data = new String[4][];
		data[NAME] = name;
		data[QTY] = qty;
		data[PRICE] = price;
		data[SOLD] = sold;

		return data;
	}

	static void writeSampleData() {
		String[] name = new String[] { "kiwi", "pinguin", "peacock", "eagle", "chicken", "falcon", "kakadoo" };
		String[] qty = new String[] { "10", "11", "12", "13", "14", "15", "0" };
		String[] price = new String[] { "10.00", "10.50", "1.50", "100.00", "50.00", "15.00", "25.00" };
		String[] sold = new String[] { "100", "101", "102", "103", "104", "105", "106" };

		String[][] sdata = new String[4][];
		sdata[NAME] = name;
		sdata[QTY] = qty;
		sdata[PRICE] = price;
		sdata[SOLD] = sold;

		for (int i = 0; i < sdata.length; i++) {
			int n = 0;
			for (String str : sdata[i]) {
				if (data[i] == null) {
					data[i] = new String[MAX_ITEMS];
				}
				data[i][n++] = str;
			}
		}
	}

	static void printRange(String[][] data) {
		if (data == null) {
			System.out.println("printRange error: null parameter received!");
			return;
		}
		for (int i = 0; i < data.length; i++) {
			System.out.print("[");
			for (int j = 0; data[i] != null && j < data[i].length; j++) {

				if (data[i][j] != null) {
					System.out.print(data[i][j]);

					if (j < data[i].length - 1 && data[i][j + 1] != null) {
						System.out.print(", ");
					} else if (j < data[i].length - 1 && data[i][j + 1] == null && data[i][j + 2] != null) {
						System.out.print(", ");
					}
				}

				if (j == data[i].length - 1) {
					System.out.print("]");
				}

			}
			System.out.println();
		}
	}

	static String returnSold(String name) {

		int itemIdx = returnItemIdx(name);

		if (itemIdx == -1) {
			System.out.println("No such item: " + name + "!");
			return null;
		}

		return data[SOLD][itemIdx];
	}

	static String returnAvailableItems(String name) {

		int itemIdx = returnItemIdx(name);

		if (itemIdx == -1) {
			System.out.println("No such item: " + name + "!");
			return null;
		}

		return data[QTY][itemIdx];
	}

	static String[][] returnLowStock(int lowStockQty) {
		String[][] res = new String[PRICE][];

		int idx = 0;

		for (int j = 0; j < data[QTY].length; j++) {
			if (data[QTY][j] != null) {
				if (Integer.parseInt(data[QTY][j]) <= lowStockQty) {
					res[NAME] = new String[MAX_ITEMS];
					res[QTY] = new String[MAX_ITEMS];
					res[NAME][idx] = data[NAME][j];
					res[QTY][idx++] = data[QTY][j];
				}
			}
		}

		return res;
	}

	static int returnItemIdx(String item) {
		int idx = -1;
		for (int i = 0; i < data[NAME].length; i++) {
			if (data[NAME][i] == item) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	static void updatePrice(String name, double price) {
		if (name == null || name.length() == 0) {
			System.out.println("updatePrice error: name parameter cannot be null or empty String!");
			return;
		}

		int itemIdx = returnItemIdx(name);
		if (itemIdx >= 0) {
			data[PRICE][itemIdx] = String.valueOf(price);
		} else {
			System.out.println("updatePrice error: there's no such art. as \"" + name + "\"!");
		}
	}

	static double returnMoneyOnStock() {
		double res = 0;

		for (int i = 0; data != null && data[QTY][i] != null && i < data[QTY].length; i++) {
			res += (Double.parseDouble(data[QTY][i]) * Double.parseDouble(data[PRICE][i]));
		}

		return res;
	}

	static double returnTotalMoneyEarned() {
		double res = 0;

		for (int i = 0; data != null && data[QTY][i] != null && i < data[QTY].length; i++) {
			res += (Double.parseDouble(data[PRICE][i]) * Double.parseDouble(data[SOLD][i]));
		}

		return res;
	}

	static void takeNewGoodsOnCharge(String name, int qty, double price) {
		if (name == null || name.length() == 0 ) {
			System.out.println("updatePrice error: parameters cannot be null or empty String!");
			return;
		}
		int itemIdx = -1;

		for (int i = databaseLastWroteIdx; i < data[NAME].length - 1; i++) {
			if (data[NAME][i + 1] == null) {
				itemIdx++;
				databaseLastWroteIdx = i + 1;
				data[NAME][i + 1] = name;
				data[QTY][i + 1] = String.valueOf(qty);
				data[PRICE][i + 1] = String.valueOf(price);
				data[SOLD][i + 1] = "0";
				break;
			}
		}

		if (itemIdx < 0) {
			data = increaseDataBaseSize(data);
			takeNewGoodsOnCharge(name, qty, price);
		}
	}

	static String[][] increaseDataBaseSize(String[][] data) {
		int newSize = (int) (data[NAME].length * 1.3);
		String[][] newData = new String[4][];

		for (int i = 0; i < data.length; i++) {
			newData[i] = new String[newSize];
			newData[i] = Arrays.copyOf(data[i], newSize);
		}

		return newData;

	}

	static String[] sell(String name, int qty) {
		if (name == null || name.length() == 0 && qty < 0) {
			System.out.println("updateQty error: Please check parameters.\n "
					+ "Name parameter cannot be null or empty String!\n" + "Qty must cannot be less than 0!");
			return null;
		}
		int itemIdx = returnItemIdx(name);

		if (itemIdx >= 0) {
			int newqty = Integer.parseInt(data[QTY][itemIdx]);
			if (newqty < qty) {
				System.out.println("Too few stock avaible! You can buy max of " + newqty + "pcs..");
				return null;
			}
			data[QTY][itemIdx] = String.valueOf(newqty - qty);
			data[SOLD][itemIdx] = String.valueOf(Integer.parseInt(data[SOLD][itemIdx]) + qty);

			return writeSoldData(itemIdx, qty);
		}

		System.out.println("updateQty error: there's no such art. as \"" + name + "\"!");
		return null;
	}

	static String[] writeSoldData(int dataIdx, int qty) {

		int soldIdx = -1;

		if (sold[NAME] == null) {
			initSold();
		}

		for (int i = 0; i < sold[NAME].length; i++) {
			if (sold[NAME][i + 1] == null) {
				soldIdx = ++i;
				break;
			}
		}

		if (soldIdx < 0) {
			sold=increaseDataBaseSize(sold);
			writeSoldData(dataIdx, qty);
		}

		sold[NAME][soldIdx] = data[NAME][dataIdx];
		sold[QTY][soldIdx] = String.valueOf(qty);
		sold[PRICE][soldIdx] = data[PRICE][dataIdx];

		if (Integer.parseInt(data[QTY][dataIdx]) == 0) {
			cleanUpMainDatabase(dataIdx);
		}

		return new String[] { sold[NAME][soldIdx], sold[QTY][soldIdx], sold[PRICE][soldIdx] };

	}

	static void initSold() {
		sold[NAME] = new String[10];
		sold[QTY] = new String[10];
		sold[PRICE] = new String[10];
	}

	static void cleanUpMainDatabase(int dataIdx) {

		data[NAME][dataIdx] = null;
		data[QTY][dataIdx] = null;
		data[PRICE][dataIdx] = null;
		data[SOLD][dataIdx] = null;
	}

	static void pressToContinue() throws Exception {
		System.out.println("Input ENTER into console to continue...");
		System.in.read();
	}

}