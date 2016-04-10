package lesson3.checkpoint5.frame_3_5_8;

public class Init {

	
	public Ingredient[] createIngredients() {
		Ingredient[] ingredients = new Ingredient[8];
		Ingredient water = new Ingredient("water", 1f);
		Ingredient coffee = new Ingredient("coffee", 600.0f);
		Ingredient blackTea = new Ingredient("black tea", 350.0f);
		Ingredient greenTea = new Ingredient("green tea", 350.0f);
		Ingredient milk = new Ingredient("milk", 40.5f);
		Ingredient sugar = new Ingredient("sugar", 40.0f);
		Ingredient choco = new Ingredient("chocolate", 500.50f);
		Ingredient teaBergamot = new Ingredient("Tea with bergamot", 400f);

		ingredients[0] = water;
		ingredients[1] = coffee;
		ingredients[2] = blackTea;
		ingredients[3] = greenTea;
		ingredients[4] = milk;
		ingredients[5] = sugar;
		ingredients[6] = choco;
		ingredients[7] = teaBergamot;
		
		return ingredients;
	}

	public Product[] createProducts() {
		
		Product[] products = new Product[8];

		String[] productList = returnProductList();

		int i = 0;
		for (Product p : products) {
			products[i] = new Product(productList[i], createIngredients(), createRecipe(productList[i]));
			i++;
		}
		
		return products;
	}

	private String[] returnProductList() {

		String[] productList = new String[8];

		productList[0] = "Black coffee";
		productList[1] = "Latte";
		productList[2] = "Americano";
		productList[3] = "Capuccino";
		productList[4] = "Mochaccino";
		productList[5] = "Black tea";
		productList[6] = "Green tea";
		productList[7] = "Tea with bergamot";

		return productList;
	}

	private int[] createRecipe(String name) {
		int[] recipe = new int[8];

		String[] productList = returnProductList();

		int i = 0;
		for (String p : productList) {
			if (p.equalsIgnoreCase(name)) {
				break;
			}
			i++;
		}

		switch (i) {
		case 0:
			recipe[0] = 100;
			recipe[1] = 30;
			recipe[2] = 0;
			recipe[3] = 0;
			recipe[4] = 0;
			recipe[5] = 20;
			recipe[6] = 0;
			recipe[7] = 0;
			break;
		case 1:
			recipe[0] = 100;
			recipe[1] = 30;
			recipe[2] = 0;
			recipe[3] = 0;
			recipe[4] = 50;
			recipe[5] = 20;
			recipe[6] = 0;
			recipe[7] = 0;
			break;
		case 2:
			recipe[0] = 150;
			recipe[1] = 30;
			recipe[2] = 0;
			recipe[3] = 0;
			recipe[4] = 0;
			recipe[5] = 20;
			recipe[6] = 0;
			recipe[7] = 0;
			break;
		case 3:
			recipe[0] = 150;
			recipe[1] = 30;
			recipe[2] = 0;
			recipe[3] = 0;
			recipe[4] = 100;
			recipe[5] = 30;
			recipe[6] = 0;
			recipe[7] = 0;
			break;
		case 4:
			recipe[0] = 150;
			recipe[1] = 30;
			recipe[2] = 0;
			recipe[3] = 0;
			recipe[4] = 100;
			recipe[5] = 20;
			recipe[6] = 10;
			recipe[7] = 0;
			break;
		case 5:
			recipe[0] = 150;
			recipe[1] = 0;
			recipe[2] = 5;
			recipe[3] = 0;
			recipe[4] = 0;
			recipe[5] = 20;
			recipe[6] = 0;
			recipe[7] = 0;
			break;
		case 6:
			recipe[0] = 150;
			recipe[1] = 0;
			recipe[2] = 0;
			recipe[3] = 5;
			recipe[4] = 0;
			recipe[5] = 20;
			recipe[6] = 0;
			recipe[7] = 0;
			break;
		case 7:
			recipe[0] = 150;
			recipe[1] = 0;
			recipe[2] = 0;
			recipe[3] = 0;
			recipe[4] = 0;
			recipe[5] = 20;
			recipe[6] = 0;
			recipe[7] = 5;
			break;
		}
		return recipe;
	}

}
