package UI;

import Controllers.OrderController;
import Controllers.CustomerController;
import Controllers.ProductController;

import Model.Customer;
import Model.Product;
import Model.Order;

public class OrderUI
{

	public static void main(String[] args)
	{
		// Instantiate Controllers (Business Layer)
		OrderController orderController = new OrderController();
		CustomerController customerController = new CustomerController();
		ProductController productController = new ProductController();

		// Example workflow: Create a new order
		Order order = orderController.createOrder();

		// Find or create a customer
		Customer customer = customerController.findCustomerByName("John Doe");
		if (customer == null)
		{
			customer = new Customer("John Doe");
			customerController.addCustomer(customer);
		}

		// Register customer to the order
		order.setCustomer(customer);

		productController.addProduct(new Product("Hammer", null, null, null, 0, 0, null, null, null, 59.95, 0, 0, 0));
		productController.addProduct(new Product("Cement Bag", null, null, null, 0, 0, null, null, null, 89.50, 0, 0, 0));
		productController.addProduct(new Product("Screw Pack", null, null, null, 0, 0, null, null, null, 25.00, 0, 0, 0));

		// Find product and register to order
		Product product = productController.findProductById(1001);
		if (product != null)
		{
			orderController.registerProduct(product.getId(), 3); // Register 3 items
		}

		// Finalize the order
		orderController.finishOrder();

		System.out.println("Order completed successfully.");
	}
}
