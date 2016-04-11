package lesson3.checkpoint5.frame_3_5_8;

public class Ingredient {
	
	private String name;
	private float price;
	private float quantityPerProduct;

	public Ingredient(String name, float price) {
		this.name=name;
		this.price=price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getQuantityPerProduct() {
		return quantityPerProduct;
	}

	public void setQuantityPerProduct(float quantityPerProduct) {
		this.quantityPerProduct = quantityPerProduct;
	}
}

