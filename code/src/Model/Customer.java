package Model;

public class Customer
{
	private static int nextId = 1;

	private int id;
	private String name;
	private String email;
	private String phone;
	private String address;

	public Customer(String name)
	{
		this.id = nextId++;
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getEmail()
	{
		return email;
	}

	public String getPhone()
	{
		return phone;
	}

	public String getAddress()
	{
		return address;
	}

	@Override
	public String toString()
	{
		return "Customer #" + id + ": " + name;
	}
}
