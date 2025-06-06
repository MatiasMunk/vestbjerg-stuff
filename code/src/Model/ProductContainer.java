package Model;

import java.util.ArrayList;
import java.util.List;

public class ProductContainer
{

	private static ProductContainer instance;
	private List<Product> products;

	private ProductContainer()
	{
		products = new ArrayList<>();
	}

	public static ProductContainer getInstance()
	{
		if (instance == null)
		{
			instance = new ProductContainer();
		}
		return instance;
	}

	public void addProduct(Product p)
	{
		products.add(p);
	}

	public Product findProductById(int id)
	{
		for (Product p : products)
		{
			if (p.getId() == id)
			{
				return p;
			}
		}
		return null;
	}

	public List<Product> getAllProducts()
	{
		return products;
	}
}
