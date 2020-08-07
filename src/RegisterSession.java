import java.time.LocalDate;
import java.time.LocalTime;

//File: RegisterSession
/*
 * Methods need to be declared private where possible.
 */
public class RegisterSession implements Cloneable{
	
//10 CLASS VARIABLES
	
	//unique id to each RegisterSession
	private int sessionID;
	private String employeeLoggedIn;
	private int registerID;
	
	private LocalDate today;
	private LocalTime loggedOn;
	private LocalTime loggedOff;
	

	//Everytime a new sale is made, this value increments up.
	//If there have been three sales, then there should exist:
	//sales[0], sales[1], and sales[2]
	
	private int numberOfSalesThisSession;
	private int currentSaleID;
	private int sizeOfSalesArray = 10;
	
	public Sale[] salesInThisSession = new Sale[sizeOfSalesArray];



//CONSTRUCTOR
	RegisterSession(LocalTime t, LocalDate d, int id, Employee e)
	{
	//CLASS VARIABLES
	
		//unique id to each RegisterSession
		sessionID = 0;
		employeeLoggedIn = e.getEmployeeLogin();
		registerID = id;
		
//		LocalTime time = null;
//		LocalDate date = null;
//		time = time.now();
//		date = date.now();
		today = d;
		loggedOn = t;
		loggedOff = null;
		
		
		numberOfSalesThisSession = -1;
		currentSaleID = 0;
		sizeOfSalesArray = 10;

		Sale[] salesInThisSession = new Sale[sizeOfSalesArray];
		
	
		
		//set this when cashier logs off
		//LocalTime loggedOff;

	}
	  @Override
	protected RegisterSession clone() throws CloneNotSupportedException
	{
		return (RegisterSession) super.clone();
	}

	//METHODS
	  public void setSaleInThisSession(int i , Sale s) throws CloneNotSupportedException
	  {
		 
		  this.numberOfSalesThisSession ++;
		  
		  this.salesInThisSession[i] = s.clone();
	  }
	  public void setSessID(int id)
	  {
		  this.sessionID = id;
	  }
	  public void setCurrentSaleID(int id)
	  {
		  this.currentSaleID= id;
	  }
	  
		public void startSale(Sale s, int saleCount)
		{
			int i = getNumberOfSalesThisSession();
			
			i++;
			
			// numberOfSalesThisSession = 1
			this.setNumberOfSalesThisSession(i);
			//this.setCurrentSaleID = 
			
			//check capacity of arrays:  HERE!!!!!!!!!!
			
			
			
			//set the sale Id 
			//this.SaleIDsInThisSession[i] = i;
			//this.sales[i];
			

		}
		Sale[] returnSalesThisSession()
		{
			return this.salesInThisSession;
		}
		
		void setNumberOfSalesThisSession(int i)
		{
			this.numberOfSalesThisSession = i;
		}
		
//		void increaseNumberOfSalesThisSession()
//		{
//			int biggerSize = this.sizeOfSalesArray;
//			biggerSize = biggerSize * 2;
//			
//			Sale [] sales = new Sale[biggerSize]; 
//			
//			
//			
//			//copy old array into new, bigger one
//			
//			/*
//			 * 
//			 * numberOfSalesThisSession = 0;
//			sizeOfSalesArray = 10;
//		private int saleID;
//		
//		private int sizeOfItemArray;
//		
//		private Item[] reciept;
//
//		private int currentIndexOfReciept;
//		
//		private int numberOfItemsOnReciept;
//		
//		//JUST CHANGED THIS TO LOWER CASE!!!!!!!!!!!!!!!!!!!!!!!!!
//		private int numberOfCashierInputsOnReciept;
//		////////////////////////////////////////////////////////
//		
//		//note: CashRegister will calculate PriceAfterTax????
//		private double totalPriceBeforeTax;
//		
//		private LocalTime saleTime;
//			 */
//			
//			
//			for (int i = 0; i < this.sales.length; i++)
//			{
//				for (int j = 0 ; j < this.sales[i]. )
//				sales[i].reciept = this.sales[i]
//			}
//			
//			
//			
//		}
//	
	//Getter Methods////////////////////////////////////////////////////////////////
	
	//Getter Methods
		//This session will have a logged in employee. 
		//Return their employeeLogin.
		int getCurrentSaleID()
		{
			return this.currentSaleID;
		}

		int getSizeOfSalesArray()
		{
			return this.sizeOfSalesArray;
		}
		
		String getEmployeeID()
		{
			return this.employeeLoggedIn;
		}
		
		//unique id to each register
		int getRegisterNumber()
		{
			return this.registerID;
		}
		
		//This session number is unique to this register today.
		int getSessionID()
		{
			return this.sessionID;
		}
		Sale getSale(int i )
		{
			return this.salesInThisSession[i];
		}
		
		//is this counter necessary
		int getNumberOfSalesThisSession()
		{
			return this.numberOfSalesThisSession;
		}

		LocalDate getDate()
		{
			return this.today;
		}
		
		LocalTime getLoggedOnTime()
		{
			return this.loggedOn;
		}
		
		LocalTime getLoggedOffTime()
		{
			return this.loggedOff;
		}
		Sale getSalesInThisSession(int i)
		{
			return this.salesInThisSession[i];
		}
		
	//SETTERS////////////////////////////////////////////////////////////////////////////
	void setSalesInThisSession2(int i, Sale s) throws CloneNotSupportedException
	{
		
		Sale s2 = s.clone();

		
		this.salesInThisSession[i] = s2;
		
	}
		
		
	void setSalesInThisSession(int i, Sale s)
	{
	//set up sale object in session......
	
		//loop this
		System.out.println("Reciept: " + s.getReciept(i));
		
		//set saleID
		this.salesInThisSession[i].setSaleID(s.getSaleID());
		
		//set sizeOfItemArray
		this.salesInThisSession[i].setSizeOfItemArray(s.getItemArraySize());
		
		//this.salesInThisSession[i].setCurrentIndexOfReciept(s.g);
		
		//this.salesInThisSession[i].setNumberOfItemsOnReciept(s.getNumOnReciept());
			
		int num = s.getNumberOfCashierInputsOnReciept();
		
		this.salesInThisSession[i].setNumberOfCashierInputsOnReciept(num);
		
		double price = 0.0;
		
		price = s.getTotalPrice();
		
		this.salesInThisSession[i].setTotalPriceI(price);
		
		this.salesInThisSession[i].setSaleTime();
		
		/* Variables in Sale that need to be set
		 * 		DONE saleID = 0; 
		        DONE sizeOfItemArray = 25;	
				DONE reciept = new Item[sizeOfItemArray];
				DONE currentIndexOfReciept = 0;
				DONE numberOfItemsOnReciept = 0;
				DONE numberOfCashierInputsOnReciept = 0;
				DONE totalPriceBeforeTax = 0.0;
				DONE saleTime.now();
		 * 
		 * 
		 */
		
		/* Variables in Item that must be set:
		 * 
		 * 	DONE nameOfItem;
			DONE itemBarcodeID;
			DONE sellPrice;
			DONE numberOfItems;
			DONE private int numOfItemsInInventory;
			DONE private double buyPrice;
			DONE private String supplier;
			private int threshold;
		 * 
		 * 
		 */
		
		//set Item[] reciept
		for (int j = 0; j < this.salesInThisSession[i].getItemArraySize(); j++ )
		{
			//Item item = new Item(s.getItemBarcode(), s.getNumOnReciept());
		
			//set name
			this.salesInThisSession[i].getReciept(j).setName(s.returnNameFromInventory(j));
			
			//set first item barcode number
			this.salesInThisSession[i].getReciept(j).setItemBarcodeID(s.getItemBarcode());
			
			//set sell price
			this.salesInThisSession[i].getReciept(j).setSellPrice(s.getReciept(j).getSellPriceOfItem(s.getItemBarcode()));
			
			//set number of items
			this.salesInThisSession[i].getReciept(j).setNumberOfItemsInInventory((int)s.getReciept(j).getNumberOfItemsInInventory());
			
			this.salesInThisSession[i].getReciept(j).setBuyPrice(s.getReciept(j).getBuyPrice());
			
			
			//Look at this method in Item.java.  This ought to work.  Others may not
			this.salesInThisSession[i].getReciept(j).getSupplier(s.getItemBarcode());
			this.salesInThisSession[i].getReciept(j).getThreshold(s.getItemBarcode());
		}
		
		
	}
	

//	String toStringSalesInThisSession()
//	{
//		String s = " ";
//		
//		for (int i = 0; i < this.sizeOfSalesArray ; i++)
//		{
//			s = s.concat(" Sale [" + i + "] /n " + 
//					"---------------------------------" + 
//					"Barcode: " + this.salesInThisSession[i].getItemBarcode() + "  Price: " + this.salesInThisSession[i].getSubsale(i)+ " " );
//		}
//		 s = s.concat("Array size: " + this.salesInThisSession.length + "/n" );
//		return s;
//	}
	public String toString1()
	{
		String s = "";
		
	s =	"\n This RegisterSession contains:" +
		"\nsessionID: " + this.sessionID +
		"\nregisterID: " + this.registerID +
		"\nEmployee thats logged in : " + this.employeeLoggedIn +
		"\nnumberOfSalesThisSession: " + this.numberOfSalesThisSession +
		"\nsizeOfSalesArray: " + this.sizeOfSalesArray +
		"\nTodays date: " + this.today +
	    "\nThe time this employee logged on: " + this.loggedOn +
		"\nThe time this employee logged off: " + this.loggedOff;

		return s;
	}
	
	public String toString2()
	{
		String s = "";
		String saleIDs = "";
		int count = 0;
		
//		//Be cautious after deletion - MUST delete that index!
//		while(this.salesInThisSession[count].getItemBarcode() != 0)
//		{
//			saleIDs = saleIDs + " " + this.salesInThisSession[count].getSaleID() + " ";
//			count ++;
//		}
	
		s = "This RegisterSession contains: " + "\n sessionID:"  + this.getSessionID() + " "  +
			"\n registerID: " + this.getRegisterNumber()+ " " + 
			"\n employee Logged in: " + this.getEmployeeID() + " " +
		    "\n numberOfSalesThisSession: " + this.getNumberOfSalesThisSession() + " " +
		    "\n sizeOfSalesArray: " + this.getSizeOfSalesArray() + " " +
		    "\n Date: " + this.getDate() + " " + 
		    "\n Time Logged on: " + this.getLoggedOnTime() + " " +
		    "\n Time Logged off: " + this.getLoggedOffTime() + 
		    "\n All the SaleIDsInThisSession: " ;
		
		s.concat(saleIDs);

	return s;			
	}




}
