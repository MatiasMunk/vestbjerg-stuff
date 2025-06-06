package Model;

import java.util.ArrayList;
import java.util.List;

public class OrderContainer
{

	private static OrderContainer instance;
	private List<Order> orders;

	private OrderContainer()
	{
		orders = new ArrayList<>();
	}

	public static OrderContainer getInstance()
	{
		if (instance == null)
		{
			instance = new OrderContainer();
		}
		return instance;
	}

	public void addOrder(Order order)
	{
		orders.add(order);
		System.out.println("Order #" + order.getOrderId() + " saved.");
	}

	public List<Order> getAllOrders()
	{
		return orders;
	}

	public Order findOrderById(int id)
	{
		for (Order o : orders)
		{
			if (o.getOrderId() == id)
			{
				return o;
			}
		}
		return null;
	}
}
