package lesson2.frame_2_6.frame_2_6_4;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.omg.IOP.TransactionService;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

//to do extends database
public class ShopOperations extends Database {

	private Product[] productDatabase;
	private Buyer[] buyerDatabase;
	private String[][] salesDatabase;

	public ShopOperations() {
		productDatabase = products.getDatabase();
		buyerDatabase = buyers.getDatabase();
		salesDatabase = sales.getDatabase();
	}

	public static float getProductPrice(int id) {

		return -1F;
	}

	public void printProductSellPrice(int id) {
		System.out.println(productDatabase[id].getSellPrice());
	}

	public void printProductStockQty(int id) {
		System.out.print(productDatabase[id].getName() + ": ");
		System.out.println(productDatabase[id].getQtyStock());
	}

	public void printProductStockQty() {
		System.out.println("All products stock: ");
		for (Product p : productDatabase) {
			if (p != null) {
				printProductStockQty(p.getId());
			}
		}
	}

	public void sell(Product product, Buyer buyer, int qty) {
		String date = returnDate();
		sell(date, product, buyer, qty);
	}

	public void sell(String date, Product product, Buyer buyer, int qty) {
		sales.write(date, product, buyer, String.valueOf(qty));
		products.updateStockQuantity(product.getId(), qty);
		buyers.updatePurchases(product, returnDate(), buyer.getId());
		
	}

	private String returnDate() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
		return ft.format(dNow);
	}

	public void printTransactions() {
		printTransactions(1);
	}

	public void printTransactions(int days) {

		if (days <= 0 || days > 7) {
			days = 7;
		}

		System.out.println("Printing quantity of transactions during the last " + days + " days...");

		int[] trasactionsDays = new int[days];
		int curDay = Integer.parseInt(returnDate().substring(0, returnDate().indexOf('.')));

		for (int i = 0; i < salesDatabase.length; i++) {
			if (salesDatabase[i] != null) {
				String curDateStr = salesDatabase[i][0];
				curDateStr=curDateStr.substring(curDateStr.lastIndexOf(' ') + 1, curDateStr.indexOf('.'));
				int date = Integer.parseInt(curDateStr);
				
				if (curDay - date < days) {
					trasactionsDays[curDay - date]++;
				}
			}
		}

		System.out.println(Arrays.toString(trasactionsDays));
	}

	public void printSalesPeriod() {
		printSalesPeriod(1);
	}

	public void printSalesPeriod(int period) {

		if (period <= 0) {
			System.out.println("Illigal period!");
			return;
		}

		System.out.println("Printing sales during last " + period + " days...");

		int curDay = Integer.parseInt(returnDate().substring(0, returnDate().indexOf('.')));

		int trasactionNumber=1;
		
		double[] res = new double[2];
		
		for (String[] str : salesDatabase) {
			if (str != null) {
				int date = Integer.parseInt(str[0].substring(str[0].lastIndexOf(' ') + 1, str[0].indexOf('.')));
				
				if (date >= curDay - (period - 1) && date <= curDay) {
					System.out.println("\nTransaction number during period: " + trasactionNumber++);
					
					double quantity = Double.parseDouble(str[6].substring(str[6].lastIndexOf(' ')+1));
					double price = Double.parseDouble(str[3].substring(str[3].lastIndexOf(' ')+1));
					res[0]+=quantity*price;
					res[1]+=quantity;
					
					for (String s : str) {
						System.out.print(s + "\n");
					}
				}
			}
		}
		printTotals(res, trasactionNumber-1);
		System.out.println();
	}
	
	private void printTotals (double[] res, int n){
		System.out.print("\nTotal: "+n+" trasactions.\t");
		System.out.print("Total amount: "+ res[0]+"\t");
		System.out.println("Total quntity: "+ (int)res[1]);
	}
	
	public void printCatalogue(){
		int i = ProductGroups.values().length;
		
		for (ProductGroups pg:ProductGroups.values()){
			for (Product product:products.getDatabase()){
				if (product!=null && product.getProductGroop().equals(pg)){
					System.out.print(pg+": ");
					System.out.println(product.getName()+"; ");
				}
			}
		}
	}

}
