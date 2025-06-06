package Controllers;

import Model.ProductContainer;
import Model.Product;

public class ProductController
{
	private ProductContainer productContainer = ProductContainer.getInstance();

	public Product findProductById(int id)
	{
		return productContainer.findProductById(id);
	}

	public void addProduct(Product product)
	{
		productContainer.addProduct(product);
		System.out.println("Added product: " + product);
	}
}
