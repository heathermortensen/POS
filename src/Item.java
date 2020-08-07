// ***** add be Meshal *****
import java.util.List;
import java.lang.reflect.Type;


public class Item implements Cloneable
{
	
//CLASS VARIABLES
	private String nameOfItem;
	private int itemBarcodeID;
	private double sellPrice;
	private int numberOfItems;
	
	//private String name;
	private int numOfItemsInInventory;
	//private double sellPrice;
	private double buyPrice;
	private String supplier;
	private int threshold;
	
	//We removed the supplier variable and put it in ItemIn
	//private String supplier;
	
	
//CONSTRUCTORS
	public Item() 
	{
		
		//CLASS VARIABLES
		this.nameOfItem.equals("");
		this.itemBarcodeID = 0;
		this.sellPrice = 0.0;
		this.numberOfItems = 0;
		this.numOfItemsInInventory = 0;
		this.buyPrice = 0.0;
		this.supplier = "";
		this.threshold = 0;
	
	
	}

	public Item(int itemBarcodeID, int numberOfItems) 
	{
		Inventory i = new Inventory();
		i.setInventory();
		//i.myInventoryMap = i.getInventory();  //return this.myInventoryMap;
		
		this.nameOfItem = i.getNameOfItem(itemBarcodeID);
		this.itemBarcodeID = itemBarcodeID;
		this.sellPrice = i.getSellPrice(itemBarcodeID);
		this.numberOfItems = numberOfItems;
		this.numOfItemsInInventory = (int) i.getNumInInventory(itemBarcodeID);
		this.buyPrice =  i.getBuyPriceOfItem(itemBarcodeID);
		this.supplier = i.getSupplier(itemBarcodeID);
		this.threshold = i.getThreshold(itemBarcodeID);
		
	
	}
	public Item(String nameOfItem,int itemBarcodeID, double sellPrice, int numberOfItems,int numOfItemsInInventory,double buyPrice, String supplier,int threshold) 
	{
		this.nameOfItem = nameOfItem;
		this.itemBarcodeID = itemBarcodeID;
		this.sellPrice = sellPrice;
		this.numberOfItems = numberOfItems;
		this.numOfItemsInInventory = numOfItemsInInventory;
		this.buyPrice = buyPrice;
		this.supplier = supplier;
		this.threshold = threshold;
		
	
	}
	
//METHODS
	  @Override
	protected Item clone() throws CloneNotSupportedException
	{
		return (Item) super.clone();
	}
	  
	public Item getItem() throws CloneNotSupportedException
	{
		return (Item) super.clone();
	}
	
	//Getter methods/////////////////////////////////////////////////////
	
	public int getItemBarcodeID()
	{
		return this.itemBarcodeID;
	}
	
	
	public String getName()
	{
		return this.nameOfItem;
	}
	
	public String getSupplier(int barcode)
	{
		Inventory i = new Inventory();
		i.setInventory();
		
		return i.getSupplier(itemBarcodeID);
	}
	
	public int getThreshold(int barcode)
	{
		Inventory i = new Inventory();
		i.setInventory();
		
		return i.getThreshold(barcode);
	}
	
	public int getThreshold()
	{
		return this.threshold;
	}
	public String getSupplier()
	{
		return this.supplier;
	}
	
	public double getSellPrice()
	{
		return this.sellPrice;
	}
	
	public double getSellPriceOfItem(int itemBarcode) 
	{
		Inventory i = new Inventory();
		i.setInventory();
		
		return i.getSellPrice(itemBarcode);
	}

	public double getBuyPrice()
	{
		return this.buyPrice;
	}

	
	// ***** add be Meshal *****
	public double getNumberOfItems()
	{
		return this.numberOfItems;
	}
	public double getNumberOfItemsInInventory()
	{
		return this.numOfItemsInInventory;
	}
	
	//Setter methods //////////////////////////////////////////////////////////////
	public void setName(String s)
	{
		this.nameOfItem = s;
	}
	public void setItemBarcodeID(int id)
	{
		this.itemBarcodeID = id;
	}
	
	public void setSellPrice(double sellPrice)
	{
		 this.sellPrice = sellPrice;
	}
	public void setBuyPrice(double buyPrice)
	{
		 this.buyPrice = buyPrice;
	}
	
	public void setNumberOfItems(int num)
	{
		this.numberOfItems = num;
	}
	public void setNumberOfItemsInInventory(int num)
	{
		this.numOfItemsInInventory = num;
	}



}
