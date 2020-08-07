import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CashRegisterReport extends CashRegister{

	public CashRegisterReport() {
		// TODO Auto-generated constructor stub
	}
	//Class Methods
	public void printSaleInfo(CashRegister c,RegisterSession rs) throws IOException
	{
		//Make the file output Employee information: Full name, id# (login), Any Session information, etc.
		
		
		File File3 = new File("CashRegisterReport.txt"); 
		
		
		//define the path and file location

		PrintWriter out = new PrintWriter(new FileWriter(File3)); 
		
		System.out.print("CashRegisterReport.txt was writen!!!!!!!!!!!!! " + System.lineSeparator());
		System.out.print("");
		System.out.print("It recorded sale of the following items: " + System.lineSeparator());
		
		//Output to  report - SOMETHING IS BROKEN HERE. It wrote before
		out.println("File: CashRegisterReport.txt");
		out.println("This File contains information regarding Cash Register #" + this.getRegisterID());
		out.println("");
		out.println("");
		out.println("----------------------------------------");
		out.println("     Register ID : " + c.getRegisterID());
		out.println("----------------------------------------");
		out.println("Current Register Session ID = " + rs.getSessionID());
		out.println("Number of sales this session : " + rs.getNumberOfSalesThisSession());
		
		out.println("");
		out.println("Note: These output the same data. That means that");
		out.println("   .clone() was sucessful in copying data??? Put in JUnit");
		out.println("");
		out.println("rs.getSalesInThisSession :" + rs.getSalesInThisSession(0));
		
		//out.println("" + rs.getSale(0));
		
		out.println("");
		
		//get sale -> s.toString -> print reciept
		
		out.println("");
		Sale r = new Sale();
		r = rs.getSale(0);
		
		out.println(r.recieptToString(r));
		out.println("");
		
		out.close();
	}

			//nest, write a method that states the amount in the drawer.
}
