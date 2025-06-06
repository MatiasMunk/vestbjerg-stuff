package Model;

public class Invoice
{

	private Order order;

	public Invoice(Order order)
	{
		this.order = order;
		System.out.println("Invoice generated for Order #" + order.getOrderId() + " Total: $" + order.calculateTotal());
	}

	public Order getOrder()
	{
		return order;
	}
}
