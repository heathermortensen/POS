import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		
		
		int saleArraySize = 10;
		int sessionArraySize = 10;
		
		int sessionNumber = -1;
		int saleNumber = 0;
		
		//int currentSessionNumber = 0;
		//int currentSaleNumber = 0;
		
		int menuOptionReturn = 0;
		
		Sale [] sales = new Sale[saleArraySize];
		RegisterSession [] sessions = new RegisterSession[sessionArraySize];
		
		Inventory inv = new Inventory();
		inv.setInventory();
		
		//Print Inventory Report to InventoryReportOutput.txt
		
		InventoryReport iR = new InventoryReport();
		//this is printing the address
		iR.printInventory(inv);
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		
		//Create a String object called userName FOR USER TO LOG INTO THE SYSTEM////
		
		String userName = " ";
		
		String password = " ";
		
		//Create a boolean object called passwordValid
				
		boolean passwordValid = false;
		
		String sessionPrint = " ";
		
		//OBJECTS ARE DECLARED////////////////////////////////////////
		
		Driver d = new Driver();

		CashRegister register_num_1 = new CashRegister(1,10,10);
		
		
		register_num_1.setRegisterID(1);

		// Sale is declared inside RegisterSession.
		Sale s = new Sale();
		
		//WRITE A FUNCTION HERE TO ACCEPT USER INPUT ON WHICH REGISTER THEY ARE LOGGING INTO.
	
		Employee e = new Employee();
	
		
		/////////////////////////////////////////////////////////////////
		//STEP 1. USER LOGS INTO THE SYSTEM BY ENTERING NAME AND PASSWORD.
		/////////////////////////////////////////////////////////////////
		
		//Driver object prompts the user to enter their username.
		
		userName = d.login();
		
		//Employee object loads employee data.
		
		e.loadData(userName);
		
		//Driver object checks if the employee exists.
		
		d.employeeExists(userName, e);

		//Driver object prompts the user to enter their system password.
		
		password = d.getPasswordFromUser();
		
		
		//Employee object checks if user input matched a valid username and password in the system.
		
		passwordValid = e.tryPassword(password);
		
		//While the password is NOT valid, re-promt the user.
		
		while (passwordValid == false)
		{
			System.out.println("That password was incorrect !");
			
			password = d.getPasswordFromUser();
			passwordValid = e.tryPassword(password);
		}
	
		System.out.println(" ");
		System.out.println(" ");
		
		//User is now logged into the cash register system. 
		
		//print employee info to CashierReport.txt
		CashierReport cReport = new CashierReport();	
		cReport.printEmployeeInfo(e, saleNumber);
		
		//A new Session starts. A new Session object is created. sessionNumber = 0.
		sessionNumber++;
		
		RegisterSession session = new RegisterSession(register_num_1.setLoginTime(), register_num_1.getTodaysDate(), sessionNumber, e);
		
		//The register object calls method runRegister and passes the employee as a parameter.
		
		session = register_num_1.RunRegister(e);
		
		
		//sessions[sessionNumber].setSalesInThisSession(0, s);

		//Append RegisterSession info to employee info in CashierReport.txt
		
		cReport.appendRegisterSessionToFile(session, register_num_1);
		
		//File registerReport = new File("CashRegisterReport");
		
		System.out.println(" ");
		System.out.println(" ");
		
		//Session object gets returned from the RunRegister method. It is output to the console.

		sessionPrint = session.toString1();
		System.out.println(" ");
		
		System.out.println(sessionPrint);
		System.out.println(" ");
		
		//Display menu to user
		
		menuOptionReturn = register_num_1.displayMenu();
		
		//displayMenu() will return an int value. It must get passed into the 
		//menuOptions(int menuSelectionByUser) method in CashRegister.java
		
		//if menuOPtion = 0, then the user has logged out of the cash register.
				//   -->   print logout time to Cashier report
		
		//if menuOption = 1, then start checkout process. Create a Sale.
		
		//if menuOption = 3, then Output data from CashierReport to file called CashierReportOutput.txt
		
		
		//GO INTO THE METHODS HERE AND CHECK INVENTORY AND VERIFY SALE[] & RECIEPT[] & SESSION SIZE
		//Print reciept to CashRegisterReport
		//subtract Items From Inventory
		//print InventoryReport
		
		s = register_num_1.menuOptions(menuOptionReturn, s, saleNumber, inv, cReport, session);
		
		//set values inside array of objects
		

		
		
		if (s.isEmpty()== false)
		{
			session.setCurrentSaleID(1);
			//print to CashierReport.txt
			
			int k = session.getSessionID();
			int j = session.getNumberOfSalesThisSession();
			int l = session.getCurrentSaleID();
			
					
			//session.setSalesInThisSession(0, s);
			//session.toStringSalesInThisSession();
			System.out.println("");
			System.out.println("SessionID = " + k);
			System.out.println("# of sales this session = " + j);
			System.out.println("Current sales ID = " + l );

			//Print sale information into CashierReport.txt  HERE? Or in finalize sale()?
			
			
			
			System.out.println("" + s.toString());
		}
		else
		{
			System.out.println("Sale isEmpty()!!!" + s.toString());
		}
			
		
		//OPtions to finalize sale or cancel sale
		//int input = 0;
		
		int input = 0;
		input = register_num_1.displayMenu2();
		
		s = register_num_1.menuOptions(input, s, saleNumber, inv, cReport, session);
		
		//set Session data
		session.setNumberOfSalesThisSession(1);
		session.setSessID(0);
		session.setSessID(0);
		session.toString2();
		
		if (s.isEmpty()== false)
		{
			
			//print to CashierReport.txt
			
			int k = session.getSessionID();
			int j = session.getNumberOfSalesThisSession();
			int l = session.getCurrentSaleID();
					
			//session.setSalesInThisSession(0, s);
			//session.toStringSalesInThisSession();
			System.out.println("");
			System.out.println("SessionID = " + k);
			System.out.println("# of sales this session = " + j);
			System.out.println("Current sales ID = " + l);
			
			//Print sale information into CashierReport.txt  HERE? Or in finalize sale()?
			
			
			System.out.println("" );
			System.out.println("" + s.toString());
			System.out.println("" );
		}
		else
		{
			System.out.println("Sale isEmpty()!!!" + System.lineSeparator() + s.toString());
		}
		
		//Next, offer the menu, again, to the user.
		//menuOptionReturn = register_num_1.displayMenu();
		//s = register_num_1.menuOptions(menuOptionReturn, s, saleNumber, inv);
		
		//place new menu here
		
		//menuOptionReturn = register_num_1.displayMenu();
		
		
		
		
	}
    //Read from/write to a file:
	//https://www.tutorialspoint.com/java/java_files_io.htm
	

	
	public boolean employeeExists(String input, Employee emp)
	{
		
		boolean result = false;
	
		
		
				if (emp.getEmployeeLogin().equals(input))
				{
					System.out.println("");
					System.out.println("Employee Exists");
					System.out.println("");
					result = true;
				}
				else
				{
					System.out.println("Output 4. Employee DOES NOT Exist");
					System.out.println("Locate your login and password in file: Employee.java - the loadData method");
					result = false;
				}
		
	return result;
	}
	

	public String login()
	{
		
		//System.out.println("");
		System.out.println("???????????????????????????????");
		System.out.println("        Login   ");
		System.out.println("???????????????????????????????");
		System.out.println("");
	
		//User input
	
		Scanner reader = new Scanner(System.in);
		    //rest of your code
		 

			
		    System.out.print("Please enter your username >> ");		
			String userInput = reader.nextLine();
			
	return userInput;	
	}
	
	
	public String getPasswordFromUser()
	{

		//User input
		Scanner reader = new Scanner(System.in); 
		String userInput = "";

		   
			System.out.print("Please enter your password>> ");		
			userInput = reader.nextLine();
			
	return userInput;	
	}
	
	
}//end of class
