package Controllers;

import Model.*;

import java.util.Optional;

public class OrderController
{

	private CustomerController customerController;
	private ProductController productController;
	private Order currentOrder;

	public OrderController(CustomerController customerController, ProductController productController)
	{
		this.customerController = customerController;
		this.productController = productController;
	}

	public boolean createOrder(int customerId)
	{
		Customer customer = customerController.findCustomerById(customerId);
		if (customer == null)
		{
			return false;
		}
		currentOrder = new Order(customer);
		return true;
	}

	public boolean addProduct(int productId, int quantity)
	{
		if (currentOrder == null)
			return false;

		Product product = productController.findProductById(productId);
		if (product == null || quantity <= 0)
			return false;

		return currentOrder.addProduct(product, quantity);
	}

	public boolean removeProduct(int productId)
	{
		if (currentOrder == null)
			return false;
		return currentOrder.removeProduct(productId);
	}

	public boolean registerCustomer(Customer customer)
	{
		return customerController.addCustomer(customer);
	}

	public Order getCurrentOrder()
	{
		return currentOrder;
	}

	public void applyDiscount(double percentage)
	{
		if (currentOrder != null)
		{
			currentOrder.applyDiscount(percentage);
		}
	}

	public double calculateTotal()
	{
		if (currentOrder != null)
		{
			return currentOrder.calculateTotal();
		}
		return 0.0;
	}

	public boolean validateOrder()
	{
		if (currentOrder == null)
			return false;
		return currentOrder.isValid();
	}

	public Invoice finishOrder()
	{
		if (currentOrder != null && currentOrder.isValid())
		{
			Invoice invoice = currentOrder.generateInvoice();
			// Inventory update logic could be added here
			currentOrder = null;
			return invoice;
		}
		return null;
	}

	public void cancelOrder()
	{
		currentOrder = null;
	}
}
