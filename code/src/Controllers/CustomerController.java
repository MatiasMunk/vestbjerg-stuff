package Controllers;

import Model.CustomerContainer;
import Model.Customer;

public class CustomerController
{
	private CustomerContainer customerContainer = CustomerContainer.getInstance();

	public Customer findCustomerById(int id)
	{
		return customerContainer.findCustomerById(id);
	}

	public Customer findCustomerByName(String name)
	{
		return customerContainer.findCustomerByName(name);
	}

	public Boolean addCustomer(Customer customer)
	{
		customerContainer.addCustomer(customer);
		System.out.println("Added customer: " + customer);

		return true;
	}
}
