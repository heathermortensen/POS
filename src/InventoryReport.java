import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//THis inherits from the Inventory class
public class InventoryReport extends Inventory{

	public InventoryReport() {
		
	}
//METHODS
	
	//Output the inventory to console 
	
	//output the inventory to the file.
	
	//Use the toString(Inventory i ) in Inventory.java to output to the file
	public void printInventory(Inventory i) throws IOException
	{
		//Make the file output Employee information: Full name, id# (login), Any Session information, etc.
		
		
		File File1 = new File("InventoryReportOutput.txt"); 
		
		
		//define the path and file location

		PrintWriter out = new PrintWriter(new FileWriter(File1)); 
		
		
		System.out.println("File canWrite()? " + File1.canWrite());
		
		//Output to  report - SOMETHING IS BROKEN HERE. It wrote before
		out.println("" + i.toString(i));
		System.out.print("InventoryReportOutput.txt was Written!");
		
		out.close();
	
	}
	
	public void appendInvenotoryToFile(Inventory i, String s) throws IOException
	{
		//https://www.youtube.com/watch?v=v-qCbMRkk-s
		
		//create file object
		File File2 = new File("InventoryReportOutput.txt");
		
		
		//create fileWriter object - the parameter 'true' allows us to append
		FileWriter writer = new FileWriter(File2, true);
		
		//BufferedWrite MUST be the parameter for PrintWriter.
		
		BufferedWriter buffered = new BufferedWriter(writer);
		PrintWriter writer2 = new PrintWriter(buffered);
		
		writer2.println("");
		writer2.println("" + s);
		writer2.println("");
		writer2.println("----------------------------------------");
		writer2.println("        Current Inventory" );
		writer2.println("----------------------------------------");
		writer2.println("" );
		
		writer2.println("" );
	
		writer2.println("" + i.toString(i));
	
		writer2.println("" );
		
		buffered.close();
		
	}

}
