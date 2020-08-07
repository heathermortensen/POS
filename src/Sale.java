import java.text.DecimalFormat;
import java.math.*;
import java.text.*;
import java.time.LocalTime;
import java.util.HashMap;

public class Sale implements Cloneable{
	
// 8 CLASS VARIABLES

	
	private int saleID;
	
	//An array that holds all the items that are purchased.  Each
		//  element in the array has a itemBarcodeID, NumberOfItems,
		//  and, a price.
	
	private Item [] reciept;
	
	private LocalTime saleTime;
	
	//note: This is whats added to Drawer
	private double totalPriceBeforeTax;
	
	private int sizeOfItemArray;
	
	private int currentIndexOfReciept;
	
	private int numberOfItemsOnReciept;
	
	private int numberOfCashierInputsOnReciept;
	////////////////////////////////////////////////////////
	
	
	


//CONSTRUCTOR
	public Sale() {
		
		saleID = 0;
		
		sizeOfItemArray = 25;	
		
		//Create an array of 25 Items that represents the customer receipt.
		reciept = new Item[sizeOfItemArray];
		
		currentIndexOfReciept = 0;
		
		numberOfItemsOnReciept = 0;
		
		numberOfCashierInputsOnReciept = 0;
		
		totalPriceBeforeTax = 0.0;
		
		//reset this time when  checkout is complete
		
		saleTime = LocalTime.now();
	}
	
//METHODS
	  @Override
	protected Sale clone() throws CloneNotSupportedException
	{
		return (Sale) super.clone();
	}
	  public void setRecieptItem(Item i, int index) throws CloneNotSupportedException
	  {
		  this.reciept[index] = (Item) i.clone();
	  }
	  
	public boolean isEmpty() throws CloneNotSupportedException
	{
		if (this.reciept[this.currentIndexOfReciept]==null)
		{
			
			//make it not a null pointer
			this.setCurrentIndexOfReciept(0);
			
			//create an empty Item
			//	public Item(int numOfItemsInInventory,double buyPrice, String supplier,int thr
			Item i = new Item("",0,0.0,0,0,0.0,"",0);
			
			this.reciept[this.currentIndexOfReciept] = (Item) i.clone();
			
//			this.reciept[this.currentIndexOfReciept].setBuyPrice(0.0);
//			this.reciept[this.currentIndexOfReciept].setSellPrice(0.0);
//			this.reciept[this.currentIndexOfReciept].setName("");
//			this.reciept[this.currentIndexOfReciept].setItemBarcodeID(0);
//			this.reciept[this.currentIndexOfReciept].setNumberOfItems(0);
//	
			
			return true;
		}
		if (this.reciept[0].getItemBarcodeID() == 0)
		{
			System.out.println("reciept[0] barcode = 0");
			return true;
		}
		else
			return false;
	}
	
	//Getters
	public int getSaleID()
	{
		return this.saleID;
	}
	public double getNumOnReciept()
	{
		double count = 0.0;
		
		for (int i=0 ; i <reciept.length; i++)
		{
			count = count + reciept[i].getNumberOfItems();
			
		}
		return count;
	}
	public void setItem(Item i , int recieptIndex)
	{
		this.reciept[recieptIndex] = i;
		
	}
	//JUnit test this method
	public Item[] getRecieptArray()
	{
		return this.reciept;
	}
	public Item getReciept(int i)
	{
		return this.reciept[i];
	}
	public int getItemArraySize()
	{
		return this.reciept.length;
	}
	public int getCurrentIndexOfReciept()
	{
		return this.currentIndexOfReciept;
	}
	public int getNumberOfCashierInputsOnReciept()
	{
		return this.numberOfCashierInputsOnReciept;
	}
	public double getTotalPrice()
	{
		return this.totalPriceBeforeTax;
	}
	public LocalTime getTime()
	{
		return this.saleTime;
	}

	
	//JUNIT test this method
	public int getItemBarcode()
	{
		return this.reciept[this.currentIndexOfReciept].getItemBarcodeID();
	}
	
//	public double getNumItems()
//	{
//		return this.reciept[this.currentIndexOfReciept].getNumberOfItems();
//	}
	
	//Setter Methods
	
	public void setSaleTime()
	{
		LocalTime t = null;
		t = LocalTime.now();
		this.saleTime = t;
	}
	
//	public void setReciept(int num, int barcodeID)
//	{
//		int i = this.currentIndexOfReciept;
//		
//		//Error is here...................................
//		this.reciept[i].setNumberOfItems(num);
//		this.reciept[i].setItemBarcodeID(barcodeID);
//		
//		this.increaseRecieptCounter();
//		
//	}
	
	public void setSaleID(int id) 
	{
		this.saleID = id;
		
	}
	public void setSizeOfItemArray(int i) 
	{
		this.sizeOfItemArray = i;
		
	}
	public void setCurrentIndexOfReciept(int i) 
	{
		this.currentIndexOfReciept = i;
		
	}
	
	public void setNumberOfItemsOnReciept(double d) 
	{
		this.numberOfItemsOnReciept = (int) (this.numberOfItemsOnReciept + d);
		
	}
	public void increaseNumberOfCashierInputsOnReciept() 
	{
		this.numberOfCashierInputsOnReciept ++;
		
	}
	public void setNumberOfCashierInputsOnReciept(int i) 
	{
		this.numberOfCashierInputsOnReciept = i;
		
	}
	public double setTotalPriceBeforeTax(Item[] reciept)
	{
		//this method has NOT been implemented
		return 0;
	}
	public void setTotalPriceI(double totalPrice)
	{
		this.totalPriceBeforeTax = totalPrice;
	}
	public void setTotalPriceII(double subPrice)
	{
		this.totalPriceBeforeTax = this.totalPriceBeforeTax + subPrice;
	}
	
	public void increaseRecieptCounter()
	{
		this.currentIndexOfReciept++;
		
	}
	
	void cancelItem(int itemBarcodeID, int numberOfItems, int subSaleCounter)
	{
		
	}
	
	void cancelSale(Sale s)
	{
		
		/*
		 * 
		myInventoryMap.put("1", new Item("apples",   01,  0.50, 15,  44, 00.20, "Sysco" ,   10));
		myInventoryMap.put("2", new Item("bananas",  02,  0.10, 15,  44, 00.05, "Sysco" ,   10));
		myInventoryMap.put("3", new Item("CatFood",  03, 12.95, 25,  20, 06.25, "SuperValu", 5));
		myInventoryMap.put("4", new Item("DogFood",  04, 15.50, 30,   7, 10.00, "SuperValu", 5));
		
		myInventoryMap.put("5", new Item("Eggplant", 05,  2.50, 15,  44, 00.20, "Sysco" ,    5));
		myInventoryMap.put("6", new Item("Flowers",  06,  4.50, 15,  44, 00.05, "Sysco" ,    5));
		myInventoryMap.put("7", new Item("Grapes",   07,  4.95, 25,  20, 06.25, "SuperValu", 5));
		 */
		//Item(String nameOfItem,int itemBarcodeID, double sellPrice, int numberOfItems,int numOfItemsInInventory,double buyPrice, String supplier,int threshold) 
		Inventory inv = new Inventory();
		HashMap h = new HashMap<String, Item>();
		h = inv.getInventory();
		

		//private int numOfItemsInInventory;
		
		//return items to inventory
		for (int i = 0; i < reciept.length; i++)
		{
			//String s = String.valueOf(barcode);
			String barcode;
			int barcodeInt = (this.reciept[i].getItemBarcodeID());
			barcode = String.valueOf(barcodeInt);
			
			double numItems = this.reciept[i].getNumberOfItems();
			
			double d = 0.0;
			d = inv.getNumInInventory(barcodeInt);
			int addToInv = 0;
			addToInv = (int) (d + numItems);
		
			if ((boolean)barcode.equals("1"))
			{
				h.put("1", new Item("apples",   01,  0.50, addToInv,  44, 00.20, "Sysco" ,   10));
			     
			}
		}
		
		//set all the Items on reciept to 0
		for (int i = 0; i < reciept.length; i++)
		{
			this.reciept[i].setName("");
			this.reciept[i].setItemBarcodeID(0);
			this.reciept[i].setNumberOfItems(0);
			this.reciept[i].setSellPrice(0.0);
			
			
		}
		

	
		
		
	}
	
	//Mutator Method
	//////////////////////////this is where it breaks///////////////////////////////////////
	public Item addItemsToSale(int itemBarcodeID, int numberOfItems, int subSaleCounter)
	{
		
		
		/*  INCREASE:
		 * 
			currentIndexOfReciept = 0;
			numberOfItemsOnReciept = 0;
			numberOfCashierInputsOnReciept = 0;
		 * 
		 */
			
		System.out.println("" );
			System.out.println("Current reciept index = " + this.currentIndexOfReciept);
			
			//this.numberOfItemsOnReciept = this.numberOfItemsOnReciept + numberOfItems;
			System.out.println("Items on reciept = " + this.numberOfItemsOnReciept );
			
			//this.numberOfCashierInputsOnReciept ++;
			System.out.println("Cashier inputs= " + this.numberOfCashierInputsOnReciept );
			
			System.out.println("subsalecounter= " + subSaleCounter);
			System.out.println("Prior to adding last Item, " );
		
		//setNumberOfItemsOnReciept(numberOfItems); 
		
		Inventory i = new Inventory();
		i.myInventoryMap = i.getInventory();
		
		Item a = new Item(itemBarcodeID, numberOfItems);
		
		double d = a.getBuyPrice();
		//System.out.println("" + d);
		
		//Receipt can hold 25 items. 
		
		
		this.reciept[subSaleCounter] = a;
		 
		//if array is too small, double its size here.
		
		//set reciept index
		this.currentIndexOfReciept = subSaleCounter;
		
		///////////OUTPUT HERE TO PRINT RECIEPT in sale.java?///////////////////////////////
		PrintReciept(this.currentIndexOfReciept);
		

		//Decrease the Inventory by the numberOfItems in a method that Finalizes the Sale
		
	   return a;
	}
	public String toString()
	{
		String s = "";
		
		s = "" + System.lineSeparator() + "------------------------------------------------" +  System.lineSeparator() + "          SaleID = " + this.saleID   + "   Time: " + this.saleTime + System.lineSeparator() +
				 "------------------------------------------------" + System.lineSeparator() +
				 "Reciept index: " + this.currentIndexOfReciept + System.lineSeparator() +
				 "Size of ItemArray =  " + this.sizeOfItemArray + System.lineSeparator() +
                 "Number of Items on reciept: " + this.numberOfItemsOnReciept	+ System.lineSeparator() +
                 "Number of Cashier inputs on Reciept: " + this.numberOfCashierInputsOnReciept + System.lineSeparator() +	
                 "Total Price/Drawer amount: $" + this.totalPriceBeforeTax;
		
		//String f = 	"" + this.totalPriceBeforeTax;

		//String strDouble = String.format("%.2f", "" + f);
		
		//s = s.concat(strDouble);
		
		 return s;
	}
	
	void addItemsToTotalItemCount(int numberOfItems)
	{
	
		
	}
	
	Sale finalizeSale(Sale s)
	{
		//ensure that Sale var reciept[item] actually hold the data
		
		//Decrease the Inventory by the numberOfItems when Sale is finalized
		
		//check size of Item array is large enough, otherwise increase
		
		//Insert this Sale object into CashRegister's array salesOnThisRegisterToday[].
		
		//Insert this Sale object into the RegisterSession for this Employee, called saleIDsThisSession.
		
		//set any sale variables that havn't been set yet, like time of sale.
		
		//make the sale data get passed back into driver, where driver prints to Cashier report and  invenotry report and registr report
		
	return s;	
	}
	public double returnCount(int count)
	{
		return count;
	}
	
	public String returnNameFromInventory(int j)
	{
		Inventory i = new Inventory();
		i.getInventory();
		
		double subsale = (this.reciept[j].getSellPrice() * this.reciept[j].getNumberOfItems());
		
		//i.getBarcode(this.reciept[j].getItemBarcodeID());
		String s = i.getNameOfItem(this.reciept[j].getItemBarcodeID());
		s = ""+ s + "'s ";
	
		return s;
	}
	
	public double getSubsale(int j)
	{
		Inventory i = new Inventory();
		i.getInventory();
		
		double subsale = (this.reciept[j].getSellPrice() * this.reciept[j].getNumberOfItems());

	
		return subsale;
	}
	
	//This outputs the subtotals ////////////////////////////////////////////////////////////
	public double printItemInfo(int j)
	{
		Inventory i = new Inventory();
		i.getInventory();
		
		double subsale = (this.reciept[j].getSellPrice() * this.reciept[j].getNumberOfItems());
	
		//i.getBarcode(this.reciept[j].getItemBarcodeID());
		String s = i.getNameOfItem(this.reciept[j].getItemBarcodeID());
		double t = this.reciept[j].getSellPrice();
		double k = this.reciept[j].getNumberOfItems();
		
		System.out.print("| " + k + " " + s + "(s) @ " + t + " = $" );
		System.out.printf("%.2f",subsale);
		System.out.println("");
		
		return subsale;
	}
	
	
	public void PrintReciept(int numSubSales)
	{
		/*Item variables:
		 * 
		 * 	private String nameOfItem;
			private int itemBarcodeID;
			private double sellPrice;
			private int numberOfItems;
		 */
		
		int h = numSubSales + 1;
		double subsale = 0.0;
	//	int runningTotal = 0;
		
		int i = this.saleID;
		
		System.out.println("ENTER Sale. java, void PrintReciept(int numSubSales)" );
		System.out.println("" );
		//System.out.println("--- SALE #" + i + " RECIEPT ---");
		System.out.println("|--- SALE #" + i + " RECIEPT --------------|");
		
		//If reciept is empty, sale was cancelled.
		if (h == 0)
		{
			//System.out.println("" + "Sale.java says reciept is empty");
			saleWasCancelled();
		}
		else
		{
		for(int j = 0; j < h; j++)
		{
			//double subSale;	
			
			System.out.println("|                                  |" );
			subsale = subsale + printItemInfo(j);
			System.out.print("| SubTotal = $" );
			System.out.printf("%.2f",subsale);
			System.out.println("" );
			System.out.println("|----------------------------------|" );
			
			//set this.totalPrice
			this.totalPriceBeforeTax = subsale;
		}
		}
	}
		private String saleWasCancelled() {
		
			String string = "This sale has NO reciept because it was cancelled.";
		return string;
	}

		public String recieptToString(Sale s)
		{
			/*Item variables:
			 * 
			 * 	private String nameOfItem;
				private int itemBarcodeID;
				private double sellPrice;
				private int numberOfItems;
			 */
			
			
			double subsale = 0.0;
			int runningTotal = 0;
			
			int a = this.saleID;
			
			Inventory i = new Inventory();
			i.getInventory();
			
			
			String string = "";
			
			String t = "";
			t = "" + System.lineSeparator() + "|                                         |"  /*+ System.lineSeparator()*/;
			
			string = "-------------------------------------------" + System.lineSeparator() +
					 "|   FOOD MART                             |" + System.lineSeparator() +
					 "|--- SALE #" + s.saleID + " RECIEPT ---------------------|" + System.lineSeparator() +
					 "|      time of sale : " + this.saleTime +"        |" ;
			string = string.concat(t);
			double v;
			double u;
			String r;
			String w = "| SubTotal = $" ;	
			String x;
			String y ="" + System.lineSeparator();
			String z = "|-----------------------------------------|" ;
			
			//If reciept is empty, sale was cancelled.
			if (s.numberOfCashierInputsOnReciept == 0)
			{
				System.out.println("" + "Sale.java says reciept is empty");
				string = saleWasCancelled();
			}
			else
			{
			for(int j = 0; j < s.numberOfCashierInputsOnReciept ; j++)
			{
				r = i.getNameOfItem(s.reciept[j].getItemBarcodeID());
				v = this.reciept[j].getSellPrice();
				u = this.reciept[j].getNumberOfItems();
				DecimalFormat format = new DecimalFormat("0.00");
				String product = String.format("%5s", format.format(u*v));
				String b = String.format("%5s", format.format(subsale));
				
				string = string.concat(t);
				string = string.concat("" + System.lineSeparator() + "|  " + u + " " + r + " @ $" + v + " = " + product + System.lineSeparator());
				double cal = (v * u);
				subsale = subsale + cal;
				//String b = "" + subsale;
				//string = string.concat("" + b + System.lineSeparator());
				string = string.concat(w);
				x = "" + subsale;
				string = string.concat(x);
				string = string.concat(y);
				string = string.concat(z);
				
				if (j == s.numberOfCashierInputsOnReciept - 1)
				{
					string = string.concat(System.lineSeparator() + "|-----------------------------------------|"+ System.lineSeparator());
					string = string.concat("|                                         |"+ System.lineSeparator());
					string = string.concat("|     Total = $" + x + "                     "+ System.lineSeparator());
					string = string.concat("|                                         |"+ System.lineSeparator());
					string = string.concat("|-----------------------------------------|"+ System.lineSeparator());
					
				}
			}
			}
			return string;
		
		//Decrease the Inventory by the numberOfItems when Sale is finalized
		//Insert this Sale object into CashRegister's array salesOnThisRegisterToday[].
		//Insert this Sale object into the RegisterSession for this Employee, called saleIDsThisSession.
	}




}
