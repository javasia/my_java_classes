package lesson2.frame_2_6.frame_2_6_4;

import java.util.Arrays;

public class Launcher {

	public static void main(String[] args) {


		DemoData demoData = new DemoData();
		ShopOperations shop = new ShopOperations();
		

		int productId = shop.products.write(demoData.product);
		int productId2 = shop.products.write(demoData.product2);
		shop.products.write(demoData.product3);

		int buyerId = shop.buyers.write(demoData.buyer);
		int buyerId2 = shop.buyers.write(demoData.buyer2);
		shop.buyers.write(demoData.buyer3);
		
		
		shop.printProductSellPrice(productId);
		shop.printProductSellPrice(productId2);
		shop.printProductStockQty(productId);
		shop.printProductStockQty(productId2);
		shop.printProductStockQty();
		shop.sell("15.03.2016", demoData.product, demoData.buyer, 2);
		shop.sell("16.03.2016", demoData.product2, demoData.buyer2, 3);
		shop.sell("17.03.2016", demoData.product3, demoData.buyer3, 4);
		shop.sell("18.03.2016", demoData.product, demoData.buyer, 2);
		shop.sell("18.03.2016", demoData.product2, demoData.buyer2, 3);
		shop.sell("18.03.2016", demoData.product3, demoData.buyer3, 4);
		shop.sell("18.03.2016", demoData.product, demoData.buyer, 2);
		shop.sell(demoData.product2, demoData.buyer2, 3);
		shop.sell(demoData.product3, demoData.buyer3, 4);
		shop.printTransactions(3);
		shop.printTransactions(2);
		shop.printTransactions(10);
		shop.printTransactions();
		shop.printSalesPeriod(4);
		shop.printSalesPeriod(2);
		shop.printSalesPeriod();
		shop.printCatalogue();

	}

}
