import java.io.File;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

/*
 * File: CashierReport
 * 
 * This class extends File: Employee.java
 * 
 *       This Class will write the information from Employee class to a file
 *       every time that Employee logs out of a session.  Each employee will 
 *       have their own unique file holding their CashierResport. 
 *       
 *       Note: These method return types are likely to change, for instance
 *       PrintToFile() might output an object of type FileStream, or something.
 *       Meshal's looking into this. Check with him. 
 *       
 */

/*
 * 				TO APPEND:
 * 				http://alvinalexander.com/java/edu/qanda/pjqa00009.shtml
 * 
 */

public class CashierReport extends Employee
{
	int currentsaleCount;
	//int sessionCount;
	
	//Class Variables
	public CashierReport()
	{
		//unique identifier for Employee is the login, like mort0048
		String employeeLogin;
		String employeePsswrd;
		
		String employeeFirstName;
		String employeeLastName;
		
		//This keeps track of all the Employee's Session for the day by holding
		//	all the SessionID's inside an array. Their first session of the day 
		//  will be in TodaysSessions[0], their second will be in TodaysSessions[1], etc.
		
		int sizeOfArray;
		
		//This must be turned into an array that is size: sizeOfArray
		//It holds all the session IDs that an Employee used.
		
		RegisterSession todaysSessions [];
		int currentSessionID;
		
		
	}

	//Constructor
	public CashierReport(Employee e, int sessionNum, int saleNum)
	{
		//unique identifier for Employee is the login, like mort0048
		String employeeLogin = e.getEmployeeLogin();
		String employeePsswrd = e.getEmployeePsswrd();
		
		String employeeFirstName = e.getEmployeeFirstName();
		String employeeLastName = e.getEmployeeLastName();
		
		//This keeps track of all the Employee's Session for the day by holding
		//	all the SessionID's inside an array. Their first session of the day 
		//  will be in TodaysSessions[0], their second will be in TodaysSessions[1], etc.
		
		int sizeOfArray = e.getCurrentSizeOfArray();
		
		//This must be turned into an array that is size: sizeOfArray
		//It holds all the session IDs that an Employee used.
		
		//RegisterSession todaysSessions [];
		
		//send this from driver.java
		//RegisterSession todaysSessions[] = e.
		int currentSessionID = e.getCurrentSessionID();
		
	}
	
	//Class Methods
	public void printEmployeeInfo(Employee e, int sale) throws IOException
	{
		//Make the file output Employee information: Full name, id# (login), Any Session information, etc.
		
		
		File File1 = new File("CashierReportOutput.txt"); 
		
		
		//define the path and file location

		PrintWriter out = new PrintWriter(new FileWriter(File1)); 
		
		System.out.print("CashierReportOutput.txt was writen!!!!!!!!!!!!! ");
		System.out.println(File1.canWrite());
		
		//Output to  report - SOMETHING IS BROKEN HERE. It wrote before
		out.println("File: CahierReportOutput.txt");
		out.println("This File contains information regarding cashier " + e.getEmployeeFirstName() + e.getEmployeeLastName());
		out.println("");
		out.println("");
		out.println("----------------------------------------");
		out.println("Employee Name: " + e.getEmployeeFirstName() + " " + e.getEmployeeLastName());
		out.println("----------------------------------------");
		out.println("Employee login ID: " + e.getEmployeeLogin() );
		out.println("Employee Session ID: " + e.getCurrentSessionID());
		out.println("Employee Sale ID: " + sale);
		
		out.close();
		
		
	}
	public void ReadEmployeeInfo() throws IOException
	{
		//https://www.youtube.com/watch?v=v-qCbMRkk-s
		
		FileReader fileReader = new FileReader("CashierReportOutput.txt");
		BufferedReader reader = new BufferedReader(fileReader);
		
		String text = "";
		String line = reader.readLine();
		//reads line after line of the file
		while (line != null)
		{
			text += line;
			line = reader.readLine();
		
		}
		
		System.out.println(text);
		
		reader.close();
		
	}
	
	public void appendRegisterSessionToFile(RegisterSession r, CashRegister c) throws IOException
	{
		//https://www.youtube.com/watch?v=v-qCbMRkk-s
		
		//create file object
		File File1 = new File("CashierReportOutput.txt");
		//create fileWriter object - the parameter 'true' allows us to append
		FileWriter writer = new FileWriter(File1, true);
		//BufferedWrite MUST be the parameter for PrintWriter.
		BufferedWriter buffered = new BufferedWriter(writer);
		PrintWriter writer2 = new PrintWriter(buffered);
		
		writer2.println("");
		writer2.println("----------------------------------------");
		writer2.println("Register ID = " + c.getRegisterID());
		writer2.println("Register " + r.getRegisterNumber() + " has employee " + r.getEmployeeID() + " currently logged on.");
		writer2.println("Log on time: " + r.getLoggedOnTime());
		writer2.println("");
		writer2.println("Current Session ID = " + r.getSessionID() + " (Current Size of Session Array = " + c.getArraySize() + ")");
		writer2.println("Current Sale ID = " + r.getCurrentSaleID() + " (Current Size of Sales Array = " + r.getSizeOfSalesArray() + ")");

		writer2.println("----------------------------------------");
		writer2.println("");
		
		buffered.close();
		
	}
	public void appendRegisterSessionToFile2(RegisterSession r) throws IOException
	{
		//https://www.youtube.com/watch?v=v-qCbMRkk-s
		
		//create file object
		File File1 = new File("CashierReportOutput.txt");
		//create fileWriter object - the parameter 'true' allows us to append
		FileWriter writer = new FileWriter(File1, true);
		//BufferedWrite MUST be the parameter for PrintWriter.
		BufferedWriter buffered = new BufferedWriter(writer);
		PrintWriter writer2 = new PrintWriter(buffered);
		
		writer2.println("");
		writer2.println("----------------------------------------");
		writer2.println("Register ID " + r.getRegisterNumber() + " has employee " + r.getEmployeeID() + " currently logged off.");
		writer2.println("Logged off time: " + r.getLoggedOffTime());
		writer2.println("");
		writer2.println("Current Session ID = " + r.getSessionID() );
		writer2.println("Current Sale ID = " + r.getCurrentSaleID() + " (Current Size of Sales Array = " + r.getSizeOfSalesArray() + ")");
		writer2.println("----------------------------------------");
		writer2.println("");
	
		
		buffered.close();
		
	}
	
//	public void printEmployeeSessionInfo(Employee e,  RegisterSession s) throws IOException
//	{
//		//Make the file output Employee information: Full name, id# (login), Any Session information, etc.
//		
//		
//		File exportedFile = new File("CashierReportOutput.txt"); 
//		
//		
//		//define the path and file location
//
//		PrintWriter out = new PrintWriter(new FileWriter(exportedFile)); 
//		
//		System.out.print("CashierReportOutput.txt can output session info? ");
//		System.out.println(exportedFile.canWrite());
//		
//		
//		System.out.println(s);
//		
//		out.close();
//		
//		
//	}
	
//	public void printEmployeeSaleInfo(Employee e,  int saleNum) throws IOException
//	{
//		//Make the file output Employee information: Full name, id# (login), Any Session information, etc.
//		
//		
//		File exportedFile = new File("CashierReportOutput.txt"); 
//		
//		
//		//define the path and file location
//
//		PrintWriter out = new PrintWriter(new FileWriter(exportedFile)); 
//		
//		System.out.print("CashierReportOutput.txt can Write? ");
//		System.out.println(exportedFile.canWrite());
//		
//		//Output to  report - SOMETHING IS BROKEN HERE. It wrote before
//		out.println("File: CahierReportOutput.txt");
//		out.println("This File contains information about a cashier.");
//		out.println("");
//		out.println("Employee Name: " + e.getEmployeeFirstName() + " " + e.getEmployeeLastName());
//		out.println("Employee login ID: " + e.getEmployeeLogin());
//		out.println("Employee Session ID: " );
//		out.println("Employee Sale ID: " + i);
//		
//		out.close();
//		
//		
//	}
	
	
//	public void printToFile() throws IOException
//	{
		

		
		
//	}
	
	public void readFromFile()
	{
		//Read from a txt file contained within the project 
		//  (dragged and dropped inside)
		File importedFile = new File("ImportCahierReport.txt"); 
		
		//In inRef = new In(importedFile);
		
		System.out.println("importedFile: " + importedFile);
		
		
		
	}
	

}
