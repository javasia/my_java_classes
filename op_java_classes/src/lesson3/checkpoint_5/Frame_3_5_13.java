package lesson3.checkpoint_5;

public class Frame_3_5_13 {

	static final int MAX_ITEMS = 100;

	static String[][] data = buildData();

	public static void main(String[] args) {
		writeSampleData();
		printRange(data);

		System.out.print("Sold falcons: ");
		System.out.println(returnSold("falcon"));
		System.out.print("Falcons available on stock: ");
		System.out.println(returnAvailable("falcon"));
		System.out.print("Items low in stock: ");
		printRange(returnLowStock());

		// my methods:
		System.out.println("Money on stock: " + returnMoneyOnStock());
		System.out.println("Money earned from sales: " + returnMoneyEarned());
		System.out.println();

		printRange(data);
		System.out.println("Update price...");
		updatePrice("chicken", "777");
		printRange(data);
		updatePrice("kakadoo", "500");
		System.out.println();

		printRange(data);
		System.out.println("updateQty: ");
		updateQty("chicken", "10000000");
		printRange(data);
		System.out.println();

		printRange(data);
		System.out.println("takeNewGoodsOnCharge: ");
		takeNewGoodsOnCharge("raven", "166", "100");
		printRange(data);
		System.out.println();

		printRange(data);
		System.out.println("takeNewGoodsOnCharge: ");
		takeNewGoodsOnCharge("chicken", "10000000", "100");
		printRange(data);
		System.out.println();

		printRange(data);
		double[] purgeRes = purgeData();
		System.out.println("purgeData - items deleted: " + (int) purgeRes[0] + ", sales per deleted items made up: "
				+ purgeRes[1] + ".");
		printRange(data);
		System.out.println();

	}

	static String[][] buildData() {
		String[] name = new String[MAX_ITEMS];
		String[] qty = new String[MAX_ITEMS];
		String[] price = new String[MAX_ITEMS];
		String[] sold = new String[MAX_ITEMS];

		String[][] data = new String[4][];
		data[0] = name;
		data[0] = qty;
		data[0] = price;
		data[0] = sold;

		return data;
	}

	static void writeSampleData() {
		String[] name = new String[] { "kiwi", "pinguin", null, "eagle", "chicken", "falcon", "kakadoo" };
		String[] qty = new String[] { "10", "10", null, "10", "10", "10", "0" };
		String[] price = new String[] { "10", "10", null, "10", "10", "10", "10" };
		String[] sold = new String[] { "10", "10", null, "10", "10", "10", "10" };

		String[][] sdata = new String[4][];
		sdata[0] = name;
		sdata[1] = qty;
		sdata[2] = price;
		sdata[3] = sold;

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

					if (j < data[i].length && data[i][j + 1] != null) {
						System.out.print(", ");
					} else if (j < data[i].length && data[i][j + 1] == null && data[i][j + 2] != null) {
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

		return data[3][itemIdx];
	}

	static String returnAvailable(String name) {

		int itemIdx = returnItemIdx(name);

		if (itemIdx == -1) {
			System.out.println("No such item: " + name + "!");
			return null;
		}

		return data[1][itemIdx];
	}

	static String[][] returnLowStock() {
		String[][] res = new String[2][];
		int idx = 0;

		for (int j = 0; j < data[1].length; j++) {
			if (data[1][j] != null) {
				if (Integer.parseInt(data[1][j]) < 3) {
					res[0] = new String[MAX_ITEMS];
					res[1] = new String[MAX_ITEMS];
					res[0][idx] = data[0][j];
					res[1][idx++] = data[1][j];
				}
			}
		}

		return res;
	}
	
	static int returnItemIdx(String item) {
		int idx = -1;
		for (int i = 0; i < data[0].length; i++) {
			if (data[0][i] == item) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	static void updatePrice(String name, String price) {
		if (name == null || price == null || name.length() == 0 || price.length() == 0) {
			System.out.println("updatePrice error: parameters cannot be null or empty String!");
			return;
		}
		int itemIdx = returnItemIdx(name);
		if (itemIdx >= 0) {
			data[2][itemIdx] = price;
		} else {
			System.out.println("updatePrice error: there's no such art. as \"" + name + "\"!");
		}
	}

	static double returnMoneyOnStock() {
		double res = 0;

		for (int i = 0; data != null && data[1][i] != null && i < data[1].length; i++) {
			res += (Double.parseDouble(data[1][i]) * Double.parseDouble(data[2][i]));
		}

		return res;
	}

	static double returnMoneyEarned() {
		double res = 0;

		for (int i = 0; data != null && data[1][i] != null && i < data[1].length; i++) {
			res += (Double.parseDouble(data[2][i]) * Double.parseDouble(data[3][i]));
		}

		return res;
	}

	static void takeNewGoodsOnCharge(String name, String qty, String price) {
		if (name == null || qty == null || name.length() == 0 || qty.length() == 0) {
			System.out.println("updatePrice error: parameters cannot be null or empty String!");
			return;
		}
		int itemIdx = returnItemIdx(name);

		if (itemIdx < 0) {

			for (int i = 0; i < data[0][i].length(); i++) {
				if (data[0][i + 1] == null) {
					itemIdx++;
					data[0][i + 1] = name;
					data[1][i + 1] = qty;
					data[2][i + 1] = price;
					data[3][i + 1] = "0";
					break;
				}
			}
		}

		else if (itemIdx >= 0) {
			System.out.println("rakeGoodsOnCharne error:  \"" + name + "\" item already exists!");
		}

		if (itemIdx < 0) {
			System.out.println("rakeGoodsOnCharne error: no more space in database for new item \"" + name + "\". "
					+ "Please purge database items.");
		}
	}

	static void updateQty(String name, String qty) {
		if (name == null || qty == null || name.length() == 0 || qty.length() == 0) {
			System.out.println("updateQty error: parameters cannot be null or empty String!");
			return;
		}
		int itemIdx = returnItemIdx(name);
		if (itemIdx >= 0) {
			int newqty = Integer.parseInt(data[2][itemIdx]) + Integer.parseInt(qty);
			data[2][itemIdx] = String.valueOf(newqty);
		} else {
			System.out.println("updateQty error: there's no such art. as \"" + name + "\"!");
		}
	}

	static double[] purgeData() {

		double moneyEarned = returnMoneyEarned();

		int purged = 0;
		for (int i = 0; data != null && data[0] != null && data[0][i] != null && i < data[0].length; i++) {
			if (data[1][i] == "0") {
				data[0][i] = null;
				data[1][i] = null;
				data[2][i] = null;
				data[3][i] = null;
				purged++;
			}
		}

		moneyEarned -= returnMoneyEarned();

		double[] res = { (double) purged, moneyEarned };

		return res;
	}

}