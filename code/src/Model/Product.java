package Model;

public class Product
{

	private static int nextId = 1000;

	private int id;
	private String name;
	private String manufacturer;
	private String model;
	private String barcode;
	private int minStock;
	private int maxStock;
	private String description;
	private String category;
	private String stockKeepingUnit;
	private double recommendedRetailPrice;
	private int tradeAllowance;
	private double costPrice;
	private double sellPrice;

	// Constructor
	public Product(String name, String manufacturer, String model, String barcode, int minStock, int maxStock, String description, String category,
							String stockKeepingUnit, double recommendedRetailPrice, int tradeAllowance, double costPrice, double sellPrice)
	{
		this.id = nextId++;
		this.name = name;
		this.manufacturer = manufacturer;
		this.model = model;
		this.barcode = barcode;
		this.minStock = minStock;
		this.maxStock = maxStock;
		this.description = description;
		this.category = category;
		this.stockKeepingUnit = stockKeepingUnit;
		this.recommendedRetailPrice = recommendedRetailPrice;
		this.tradeAllowance = tradeAllowance;
		this.costPrice = costPrice;
		this.sellPrice = sellPrice;
	}

	// Getters

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getManufacturer()
	{
		return manufacturer;
	}

	public String getModel()
	{
		return model;
	}

	public String getBarcode()
	{
		return barcode;
	}

	public int getMinStock()
	{
		return minStock;
	}

	public int getMaxStock()
	{
		return maxStock;
	}

	public String getDescription()
	{
		return description;
	}

	public String getCategory()
	{
		return category;
	}

	public String getStockKeepingUnit()
	{
		return stockKeepingUnit;
	}

	public double getRecommendedRetailPrice()
	{
		return recommendedRetailPrice;
	}

	public int getTradeAllowance()
	{
		return tradeAllowance;
	}

	public double getCostPrice()
	{
		return costPrice;
	}

	public double getSellPrice()
	{
		return sellPrice;
	}

	@Override
	public String toString()
	{
		return "Product #" + id + ": " + name + " (" + model + "), $" + sellPrice;
	}
}
