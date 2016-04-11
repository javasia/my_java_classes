package lesson3.checkpoint5.frame_3_5_8;

public class Product {

	private String name;
	private Ingredient[] ingredients;
	private float price;

	public Product(String name, Ingredient[] ingredients) {
		this.name = name;
		this.ingredients = ingredients;
		price = calculatePrice(this);
	}

	public Ingredient[] getIngredients() {
		return ingredients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIngredients(Ingredient[] ingredients) {
		this.ingredients = ingredients;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float calculatePrice(Product product) {
		float price = 0;
		if (ingredients != null) {
			for (Ingredient i : ingredients) {
				if (i != null) {
					price += i.getPrice() * (i.getQuantityPerProduct()/1000);
				} else {
					throw new NullPointerException("i in ingredients is null");
				}
			}
		} else {
			throw new NullPointerException("ingredients is null");
		}
		return price;
	}
}