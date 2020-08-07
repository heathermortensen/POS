//These are importing Java classes.  Java builtLocalDate and LocalTime
//  objects inside this class.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
//wildcard import
import java.util.*;

/*
 * File: CashRegister
 * 
 *   Employees log into a Session in order to access the CashRegister.
 *   There are multiple CashRegisters.  
 * 
 *   Date is an important class variable. Other classes will have to 
 *   perform checks against this Date.
 * 
 *   Theres an output to the console on line #110
 */
public class CashRegister implements Cloneable{
	
//9 CLASS VARIABLES

	//Uniquely identifies this register
	private int registerID;
	
	//The Employee logged into the CashRegister
	private Employee e;
	
	//These arrays are size 10.
	private int sessionArraySize;
	//THIS OUGHT TO BE REMOVED!!!!!!!!!!!!!!
	private int saleArraySize;
	
	private RegisterSession[] sessionsOnThisRegisterToday;
	//private Sale[] salesOnThisRegisterToday;
	
	private LocalDate todaysDate;
	private LocalTime currentTime;
	private LocalTime loggedOn;
	private LocalTime loggedOff;
	
	
	//This is the money in the register's drawer
	private double moneyFromALLSales;
	
	//More money variables here, if needed....
	
	private int numberOfSales;
	private int numberOfCancellations;
	private int numberOfReturns;
	
//CONSTRUCTOR #1
	public CashRegister()
	{
		
		//Uniquely identifies this register
		registerID = 0;

	    sessionArraySize = 10;
		saleArraySize = 10;
		
		RegisterSession[] sessionsOnThisRegisterToday = new RegisterSession[sessionArraySize];
		// Sale[] salesOnThisRegisterToday = new Sale[saleArraySize];
		
		
		//This is the money in the register's drawer
		double moneyFromALLSales = 0.0;
		
		//More money variables if needed....
		
		int numberOfSales = 0;
		int numberOfCancellations = 0;
		int numberOfReturns = 0;
	}

	//Constructor #2.
	public CashRegister(int registerID,int sessionArraySize,int saleArraySize) 
	{
		
		//Uniquely identifies this register
		this.registerID = registerID;
		//Employee cashier; this is stored in the Session????
	    this.sessionArraySize = sessionArraySize;
		this.saleArraySize = saleArraySize;
		
		RegisterSession[] sessionsOnThisRegisterToday = new RegisterSession[sessionArraySize];
		//Sale[] salesOnThisRegisterToday = new Sale[saleArraySize];
		
		//set RegisterSession time and date to the moment when the session is created. 
		LocalDate todaysDate = null;
		todaysDate.now();
		
		LocalTime currentTime = null;
		currentTime = currentTime.now();

		
		//These two variables receive user input.
		//For instance, Four bananas might force the user to input:
		//
		//      itemBarcodeID = 213
		//      NumberOfItems = 4
		//
		//  Cash Register should then output to the console:
		//
		//        4 bananas @ $0.50 = $2.00
		//
		//int itemBarcodeID = 000;
		//int NumberOfItems = 0;
		
		//This is the money in the register's drawer
		double moneyFromALLSales = 0.0;
		
		//More money variables if needed....
		
		int numberOfSales = 0;
		int numberOfCancellations = 0;
		int numberOfReturns = 0;
	}
	
//METHODS
	  @Override
	protected CashRegister clone() throws CloneNotSupportedException
	{
		return (CashRegister) super.clone();
	}
//////////////////////////////////////////////////////
//GETTERS		
//////////////////////////////////////////////////////
		public LocalDate getTodaysDate()
		{
		return this.todaysDate;
		}
		
		//Return the time that the user logged onto register
		
		public LocalTime getLoggedOnTime()
		{
		return this.loggedOn;
		}
		public int getArraySize()
		{
			return this.sessionArraySize;
		}
		
		public int getRegisterID()
		{	
			int i = 0;
			
			i = this.registerID;	
			
		return i;
		}
		
//////////////////////////////////////////////////////
//SETTERS		
//////////////////////////////////////////////////////
		
		public void setTodaysDate()
		{
			LocalDate d  = LocalDate.now(); 
			this.todaysDate = d;
			
		}
		
		//sets loginTime to now()
		
		public LocalTime setLoginTime()
		{
			LocalTime t = LocalTime.now(); 
			this.loggedOn = t;
			
		return this.loggedOn;
		}
		
		//sets login time to someTime
		
		public LocalTime setLogoutTime()
		{
			LocalTime t = LocalTime.now(); 
			this.loggedOff = t;
			
		return this.loggedOff;
		}
	
		public void setRegisterID(int id)
		{	
			this.registerID = id;	
			
		}
		public void increaseNumSales()
		{
			this.numberOfSales ++;
		}

		
		//This is the first output to a cashier who has already logged into a 
		//    CashRegister Session.
		public RegisterSession RunRegister(Employee e)
		{
			System.out.println("");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("    CASH REGISTER #" + this.getRegisterID());
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("");	
			
			//Set and display time -> send to RegisterSession object
			LocalTime t0 = null;	
			t0 = LocalTime.now();
			
			this.setLoginTime();
			
			//set and display date ->send to RegisterSession object
			setTodaysDate();
			LocalDate d0 = getTodaysDate();
			
			int id = this.getRegisterID();
			//Create a new RegisterSession
			RegisterSession session = new RegisterSession(t0,d0, id, e);
			
			System.out.println("Login Date: " + getTodaysDate());
			System.out.println("Login Time: " + getLoggedOnTime());
			//System.out.println("Employee: " + this.getEmployeeLogin());
			//System.out.println("Employee session #: " + this.getCurrentSessionID ());
		
		return session;
		}
		
		public int displayMenu() throws IOException
		{
			
			System.out.println("--------------------------");
			System.out.println("        MENU              ");
			System.out.println("--------------------------");
			System.out.println("");
			System.out.println("PRESS 0 - Logout");
			System.out.println("PRESS 1 - Begin Customer Checkout");
			System.out.println("PRESS 5 - Print Inventory");
			System.out.println("--------------------------");	
			System.out.print(">> ");	
			
			int userMenuInput = 0;
			// deleted = null
			Scanner reader = null;
			
			//User input
//			try
//			{
			reader = new Scanner(System.in);

			userMenuInput = reader.nextInt();
			
//			}
			//finally executes every time, no matter what. This ensures 
			//    closure of the Scanner object.
//			 finally 
//			{
//				if(reader != null) reader.close();
//			}
			//reader.close();
			
		return userMenuInput;	
		}
		
		
		public int displayMenu2() throws IOException
		{
			
			System.out.println("");
			System.out.println("--------------------------");
			System.out.println("        MENU 2              ");
			System.out.println("--------------------------");
			System.out.println("");
			System.out.println("PRESS 2 - Finalize sale");
			System.out.println("PRESS 3 - Cancel sale");
			System.out.println("--------------------------");	
			
			int userMenuInput = 0;
			
			//Scanner reader = null;
			
			try( Scanner reader = new Scanner(System.in);  ){
		
			
			
			System.out.print(">> ");
			
			userMenuInput = reader.nextInt();
			
			
			if ((userMenuInput != 2) && (userMenuInput != 3) )
			{
				System.out.print(">> ");
			    userMenuInput = reader.nextInt();
			    System.out.println("" + reader.nextInt());
			}
			//reader.close();
//			BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
//			System.out.print(">> ");
//			 
//			String inputString = reader2.readLine();
//			inputString = reader2.readLine();
//			
//			userMenuInput = Integer.parseInt ( inputString );
//			 
//			while(userMenuInput != 2 || userMenuInput != 3 )
//			{
//				System.out.println("Please enter a valid input!");
//				System.out.print(">>");
//				inputString = reader2.readLine();
//				inputString = reader2.readLine();
//				userMenuInput = Integer.parseInt ( inputString );
//			}
			
			
			return userMenuInput;			
		}
		}
		//register_num_1.menuOptions(menuOptionReturn, s, saleNumber);///////////////////////////////////////
		
		
		public Sale menuOptions(int menuSelectionByUser,  Sale s, int saleNumber, Inventory i,CashierReport r, RegisterSession rs) throws IOException, CloneNotSupportedException 
		{
			
			//Inventory i = new Inventory();
			i.setInventory();
			
			if (menuSelectionByUser == 0)
			{
				System.out.println("Logout....");
				//The user has selected 'Logout'
				//Send the information from CashRegister into Session object.
				//Logout time must be stored in the instance variables of RegisterSession.
		
				//Note: There must be a new sessionID generated when an employee logs in.
				//  It should store data in the appropriate element of an array.
				//  For instance, the first time that someone logs in that day, it is 
				//  stored in sessionsOnThisRegisterToday[0].  
				// The second time, its stored in sessionsOnThisRegisterToday[1]
				
				//The time this employee logged off for RegisterSession sessionID = 0.
				
				
				   this.setLogoutTime();
			
					//Print logout time to CashierReportOutput.txt
					r.appendRegisterSessionToFile2(rs);
					
					
					//System.exit(0) or Runtime.getRuntime().exit(0)
					System.exit(0);
					
				
				return s;
				
			}
			if (menuSelectionByUser == 1)
			{
				System.out.println("Begin Customer Checkout....");
				
				//Create Sale here and index it - in reciept
				//Starts with sale #0
				int id = s.getSaleID() ;
				
				s.setSaleID(id);
				
				s = checkout(s, id, i);

				
				return s;

			}
			if (menuSelectionByUser == 2)
			{
				System.out.println("Finalize sale....");
				System.out.println("");
				
				   s.setSaleTime();
				   
				   increaseNumSales();
				   
				   System.out.println("CashRegister.java says register " + this.registerID + " has had " + this.numberOfSales + " Sale(s).");
				   System.out.println("");
				  
				   
				   //Put current sale into RegisterSession salesInThisSession[s.getSaleID]
				   rs.setSalesInThisSession2(s.getSaleID(), s);
  
				  
				   CashRegisterReport report = new CashRegisterReport();
				   
				   //Print reciept[] using the method I wrote to CashRegisterReport
				   report.printSaleInfo(this, rs);
	
				
				return s;
				
				//sent sale logout time
				
			}
			if (menuSelectionByUser == 3)
			{
				System.out.println("Canceled sale....");
		
				 this.numberOfCancellations = 1;
				 
				//reset all items in the reciept to zero.
				 
				 Sale s2 = new Sale();
				
				 s = s2.clone();
				 
				 rs.setSalesInThisSession2(s.getSaleID(), s);
				
				 CashRegisterReport report = new CashRegisterReport();
				
				//report.printEmployeeInfo();
				   
				   System.out.println("Sale was CANCELLED!");
				   System.out.println("CashRegister.java says register " + this.registerID + " has had " + this.numberOfSales + " Sale(s).");
				   System.out.println("");
				
				   report.printSaleInfo(this, rs);
			}	
			
			if (menuSelectionByUser == 4)
			{
				System.out.println("Return an item...");
			}
			
			if (menuSelectionByUser == 5)
			{
				
				System.out.println("Print Inventory...");
				System.out.println("" + i.toString(i));
				int k = this.displayMenu();
				s = this.menuOptions(k, s, saleNumber, i, r, rs);
	
			return s;
			}
			
		Sale nullSale = new Sale();
		return nullSale;

		}
	

	
		private Sale checkout(Sale s, int id, Inventory i) throws IOException
		{
		
			int inputCounter = 0;
			
			s.setSaleID(id);
			
			
			//set all the elements of s that haven't been yet
			System.out.println("");
			System.out.println("--------------------------");
			System.out.println("       Sale #" + s.getSaleID() );
			System.out.println("--------------------------");
			System.out.println("  ");
			
			String anotherSale = "Y";

			
			Scanner reader = new Scanner(System.in);
			
			//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
						

			
			while( (anotherSale.equals("Y") || (anotherSale.equals("y")) ) && (inputCounter < s.getItemArraySize()))
			{
				int barcode = 0;
				int numberOfItems = 0;
				
				
				anotherSale = "";
				
				//User inputs the items barcode number	
				
				System.out.print("Enter item Barcode # >>");
				barcode = reader.nextInt(); 
				
				while (barcode != 1 && (barcode != 2 ) && (barcode != 3 ) && (barcode != 4 ) && (barcode != 5 ) && (barcode != 6 ) && (barcode != 7 ))
				{
					System.out.println("Please enter barcode #'s 0 to 7");
					System.out.print("Enter item Barcode # >>");
				
					barcode = reader.nextInt(); 
				}
				
				//User inputs the number of items 
				
				System.out.print("Enter Number of items >>");
					
			
				numberOfItems = reader.nextInt();
						
				
							
				//print new inventory into InventoryReportOutput.txt
				
				InventoryReport report = new InventoryReport();
					
				String someString = "";
				
				//print string to inventory - this prints everything to inventory
				
				if (barcode == 1)
					someString = i.applesOrdered();
				else if (barcode == 2)
					someString = i.bananasOrdered();
				else if (barcode == 3)
					someString = i.catFoodOrdered();
				else if (barcode == 4)
					someString = i.dogFoodOrdered();
				else if (barcode == 5)
					someString = i.eggplantOrdered();
				else if (barcode == 6)
					someString = i.flowersOrdered();
				else if (barcode == 7)
					someString = i.grapesOrdered();
				else
					someString = "";
				
				i.decreaseInventory(barcode, numberOfItems);
				
				report.appendInvenotoryToFile(i,someString);
			
				
				s.addItemsToSale(barcode,numberOfItems,inputCounter);
				
				s.setNumberOfItemsOnReciept(numberOfItems);
				
				
				//s.increaseNumberOfCashierInputsOnReciept();
				
				double d  = s.getReciept(inputCounter).getSellPrice();
				
				double subtotal = d * numberOfItems;
							
				
				//////////////////////////////////////////////////////////////////////////////
					//while (!(anotherSale.equals("Y")) && !(anotherSale.equals("N"))  )
					//{
						System.out.println("Enter another item? (Y)es/(N)o >>");
			
						anotherSale = reader.next();
						
						System.out.println("");
					//}
				if (anotherSale.equals("Y")|| anotherSale.equals("y") )
				{
					s.increaseNumberOfCashierInputsOnReciept();
					inputCounter ++;
				}
				else
				{
					s.increaseNumberOfCashierInputsOnReciept();
					inputCounter ++;
				}
					
			} //end outer while()
			
			//reader.close();
			s.setSaleTime();
						
			
		return s;
		}
		
		
		void outputItemBarcode(Sale s, int position)
		{
			System.out.print("barcodeID: "  + s.getItemBarcode());

			//this outputs an address
			System.out.println("s.getReciept(i) barcode = " + s.getReciept(position).getItemBarcodeID());
			
		}
	//	public Sale setSale(Sale s, int saleNumber)
	//	{
			/**
			 * 
			 * 	//Uniquely identifies this register
	private int registerID;
	
	//The Employee logged into the CashRegister
	//private Employee e;
	
	//These arrays are size 10.
	private int sessionArraySize;
	private int saleArraySize;
	
	private RegisterSession[] sessionsOnThisRegisterToday;
	private Sale[] salesOnThisRegisterToday;
	

	
	//set at log off time when menu item is selected 
	private LocalTime loggedOff;
	

	
	
	private int numberOfCancellations;
	private int numberOfReturns;
	
			 */
			//these should already be set
			//this.loggedOn = 
//			this.todaysDate = todaysDate.now();
//			this.currentTime = currentTime.now();
	//		this.numberOfSales ++;
	//		this.moneyFromALLSales = this.moneyFromALLSales + s.getTotalPrice();
	//	}

		
		private double calculateTotalBeforeTax()
		{
			double totalBeforeTax = 0;
			
			
			return totalBeforeTax;
		}
		
		//NOTE: FOOD AND CLOTHES DO NOT HAVE TAX....????
		private double calculateTotalAfterTax(int totalBeforeTax)
		{
			double totalAfterTax = 0;
			
			totalAfterTax = totalBeforeTax * 0.65;		
			
			return totalAfterTax;
		}
		
		private void saveSaleToFile()
		{
			
		}
		

	
	
	
}
