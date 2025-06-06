package Model;

import java.util.ArrayList;
import java.util.List;

public class Order
{

	private static int nextId = 1;

	private int orderId;
	private Customer customer;
	private List<OrderLine> orderLines;
	private double discount; // 0.0 = no discount, 0.1 = 10%

	public Order(Customer customer)
	{
		this.orderId = nextId++;
		this.customer = customer;
		this.orderLines = new ArrayList<>();
		this.discount = 0.0;
	}

	public boolean addProduct(Product product, int quantity)
	{
		if (product == null || quantity <= 0)
			return false;

		for (OrderLine line : orderLines)
		{
			if (line.getProduct().getId() == product.getId())
			{
				line.addQuantity(quantity);
				return true;
			}
		}

		orderLines.add(new OrderLine(product, quantity));
		return true;
	}

	public boolean removeProduct(int productId)
	{
		return orderLines.removeIf(line -> line.getProduct().getId() == productId);
	}

	public void applyDiscount(double percentage)
	{
		if (percentage >= 0 && percentage <= 1.0)
		{
			this.discount = percentage;
		}
	}

	public double calculateTotal()
	{
		double total = 0.0;
		for (OrderLine line : orderLines)
		{
			total += line.getLineTotal();
		}
		return total * (1 - discount);
	}

	public boolean isValid()
	{
		return customer != null && !orderLines.isEmpty();
	}

	public Invoice generateInvoice()
	{
		return new Invoice(this);
	}

	public int getOrderId()
	{
		return orderId;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public List<OrderLine> getOrderLines()
	{
		return orderLines;
	}

	@Override
	public String toString()
	{
		return "Order #" + orderId + " for " + customer.getName() + " with " + orderLines.size() + " items";
	}
}
