package Model;

import java.util.ArrayList;
import java.util.List;

public class Location
{

	private static int nextId = 1;
	private static List<Location> locations = new ArrayList<>();

	private int locationId;
	private String city;
	private String address;
	private String phone;
	private String siteName;
	private String managerName;
	private boolean isPrimary;

	// Constructor
	public Location(String city, String address, String phone, String siteName, String managerName, boolean isPrimary)
	{
		this.locationId = nextId++;
		this.city = city;
		this.address = address;
		this.phone = phone;
		this.siteName = siteName;
		this.managerName = managerName;
		this.isPrimary = isPrimary;

		locations.add(this); // Automatically register the new location
	}

	// Getters
	public int getLocationId()
	{
		return locationId;
	}

	public String getCity()
	{
		return city;
	}

	public String getAddress()
	{
		return address;
	}

	public String getPhone()
	{
		return phone;
	}

	public String getSiteName()
	{
		return siteName;
	}

	public String getManagerName()
	{
		return managerName;
	}

	public boolean isPrimary()
	{
		return isPrimary;
	}

	// Setters / Methods
	public void updatePhone(String newPhone)
	{
		this.phone = newPhone;
	}

	public void setPrimary()
	{
		this.isPrimary = true;
	}

	public void createSite()
	{
		System.out.println("Site created: " + siteName + " (" + city + ")");
	}

	// Static Management Methods
	public static List<Location> getAllLocations()
	{
		return locations;
	}

	public static Location findById(int id)
	{
		for (Location loc : locations)
		{
			if (loc.getLocationId() == id)
			{
				return loc;
			}
		}
		return null;
	}

	public static void clearLocations()
	{
		locations.clear();
		nextId = 1;
	}

	@Override
	public String toString()
	{
		return "Location #" + locationId + ": " + siteName + ", " + city + " (Manager: " + managerName + ")";
	}
}
