package Model;

public class OrderLine
{

	private Product product;
	private int quantity;

	public OrderLine(Product product, int quantity)
	{
		this.product = product;
		this.quantity = quantity;
	}

	public void addQuantity(int amount)
	{
		this.quantity += amount;
	}

	public Product getProduct()
	{
		return product;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public double getLineTotal()
	{
		return quantity * product.getSellPrice();
	}

	@Override
	public String toString()
	{
		return product.getName() + " x" + quantity + " = " + getLineTotal();
	}
}
