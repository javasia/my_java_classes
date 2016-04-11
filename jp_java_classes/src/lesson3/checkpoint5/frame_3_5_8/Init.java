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
	
	private Ingredient[] writeQtyIngredientsPerProduct(int[] quantityPerProduct) {
		int j = 0;
		Ingredient[] ingredients = createIngredients();
		if (ingredients != null) {
			for (Ingredient i : ingredients) {
				if (i != null) {
					i.setQuantityPerProduct(quantityPerProduct[j++]);
				} else {
					throw new NullPointerException("i in ingredients is null");
				}
			}
			return ingredients;
		} else {
			throw new NullPointerException("ingredients is null");
		}
	}

	public Product[] createProducts() {
		
		Product[] products = new Product[8];

		String[] productList = returnProductList();

		int i = 0;
		for (Product p : products) {
		    Ingredient[] ingredients = writeQtyIngredientsPerProduct(createrecipes(productList[i]));
			products[i] = new Product(productList[i], ingredients);
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

	private int[] createrecipes(String name) {
		
		int[][] recipes = new int[8][];
		recipes = returnrecipes();
		
		String[] productList = returnProductList();

		int i = 0;
		for (String p : productList) {
			if (p.equalsIgnoreCase(name)) {
				return recipes[i];
			}
			i++;
		}
	return null;
	}
	
	private int[][] returnrecipes(){
	    int[][] recipes = new int [8][];
	    
	    recipes[0]=new int[8];
	    recipes[0][0] = 100;
		recipes[0][1] = 30;
		recipes[0][2] = 0;
		recipes[0][3] = 0;
		recipes[0][4] = 0;
		recipes[0][5] = 20;
		recipes[0][6] = 0;
		recipes[0][7] = 0;
		
		recipes[1]=new int[8];	
		recipes[1][0] = 100;
		recipes[1][1] = 30;
		recipes[1][2] = 0;
		recipes[1][3] = 0;
		recipes[1][4] = 50;
		recipes[1][5] = 20;
		recipes[1][6] = 0;
		recipes[1][7] = 0;
		
		recipes[2]=new int[8];
		recipes[2][0] = 150;
		recipes[2][1] = 30;
		recipes[2][2] = 0;
		recipes[2][3] = 0;
		recipes[2][4] = 0;
		recipes[2][5] = 20;
		recipes[2][6] = 0;
		recipes[2][7] = 0;
		
		recipes[3]=new int[8];	
		recipes[3][0] = 150;
		recipes[3][1] = 30;
		recipes[3][2] = 0;
		recipes[3][3] = 0;
		recipes[3][4] = 100;
		recipes[3][5] = 30;
		recipes[3][6] = 0;
		recipes[3][7] = 0;
		
		recipes[4]=new int[8];	
		recipes[4][0] = 150;
		recipes[4][1] = 30;
		recipes[4][2] = 0;
		recipes[4][3] = 0;
		recipes[4][4] = 100;
		recipes[4][5] = 20;
		recipes[4][6] = 10;
		recipes[4][7] = 0;
		
		recipes[5]=new int[8];
		recipes[5][0] = 150;
		recipes[5][1] = 0;
		recipes[5][2] = 5;
		recipes[5][3] = 0;
		recipes[5][4] = 0;
		recipes[5][5] = 20;
		recipes[5][6] = 0;
		recipes[5][7] = 0;
		
		recipes[6]=new int[8];	
		recipes[6][0] = 150;
		recipes[6][1] = 0;
		recipes[6][2] = 0;
		recipes[6][3] = 5;
		recipes[6][4] = 0;
		recipes[6][5] = 20;
		recipes[6][6] = 0;
		recipes[6][7] = 0;
		
		recipes[7]=new int[8];	
		recipes[7][0] = 150;
		recipes[7][1] = 0;
		recipes[7][2] = 0;
		recipes[7][3] = 0;
		recipes[7][4] = 0;
		recipes[7][5] = 20;
		recipes[7][6] = 0;
		recipes[7][7] = 5;
			
	    
	    
	    return recipes;
	}

}