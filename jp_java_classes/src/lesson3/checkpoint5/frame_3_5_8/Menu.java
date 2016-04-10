package lesson3.checkpoint5.frame_3_5_8;

public class Menu {
	Product[] products;

	public Menu(Product[] products) {
		this.products = products;
	}

	public void printMenu() {
		int j = 0;
		for (Product p : products) {
			System.out.println("\n\n"+p.getName()+":\n");
			System.out.println("Ingredients");
			System.out.println("_____________________________");
			for (Ingredient i : p.getIngredients()) {
				if (i.getQuantityPerProduct() > 0) {
					System.out.println(i.getName() + " - " + i.getQuantityPerProduct() + "gr.");
				}
			}
			System.out.println("_____________________________");
			System.out.println("Price (UAH): " + p.getPrice());
			System.out.println("_____________________________");
			j++;
		}
	}
}
