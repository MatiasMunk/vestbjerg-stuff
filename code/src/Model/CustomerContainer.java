package Model;

import java.util.ArrayList;
import java.util.List;

public class CustomerContainer
{

	private static CustomerContainer instance;
	private List<Customer> customers;

	private CustomerContainer()
	{
		customers = new ArrayList<>();
	}

	public static CustomerContainer getInstance()
	{
		if (instance == null)
		{
			instance = new CustomerContainer();
		}
		return instance;
	}

	public void addCustomer(Customer c)
	{
		customers.add(c);
	}

	public Customer findCustomerById(int id)
	{
		for (Customer c : customers)
		{
			if (c.getId() == id)
			{
				return c;
			}
		}
		return null;
	}

	public Customer findCustomerByName(String name)
	{
		for (Customer c : customers)
		{
			if (c.getName().equalsIgnoreCase(name))
			{
				return c;
			}
		}
		return null;
	}

	public List<Customer> getAllCustomers()
	{
		return customers;
	}
}
