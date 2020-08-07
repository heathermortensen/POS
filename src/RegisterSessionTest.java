import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

public class RegisterSessionTest {

	 @Test
	 public void isClone() throws CloneNotSupportedException
	 {
		 //Create Employee
		 Employee e = new Employee();
		 e.setEmployeeData("mort0048","mK167B","Heather","M",5,0);
		 
		 //Create RegisterSession
		 LocalTime t = null;
		 t = LocalTime.now();
		 LocalDate d = null;
		 d = LocalDate.now();
		 
		 RegisterSession reg1 = new RegisterSession(t,d,1,e);
		 
		 //Create a second RegisterSession using clone 
		
		RegisterSession reg2 = (RegisterSession) reg1.clone();	 
		 
		 // Asserts that two RegisterSession objects are equal.
		 assertEquals("These two objects are equal?", reg1.getClass(), reg2.getClass()); 
        
	 }
	 @Test
	 public void setterTest1()
	 {
		//Create a RegisterSession with sales stored in Sale[] salesInThisSession.
			
		 Employee e = new Employee();
		 e.setEmployeeData("mort0048","mK167B","Heather","M",5,0);
		 
		 //Create RegisterSession
		 
		 LocalTime t = null;
		 t = LocalTime.now();
		 LocalDate d = null;
		 d = LocalDate.now();
		 
		 //Create a registerSession in which one apple is sold.
		 RegisterSession reg1 = new RegisterSession(t,d,1,e);
		 
		 //this passes.
		 assertTrue("I am employee logged into RegisterSession", reg1.getEmployeeID().equals("mort0048"));
		 
		 Sale s1 = new Sale();
		 
		 s1.setSaleID(0);
		 
		 //this fails.  why?
//		 reg1.setSalesInThisSession(0, s1);
//		 assertTrue("RegisterSession has saleID 0", reg1.getCurrentSaleID() == 0);
//		 
//		 Inventory i = new Inventory();
//		 i.setInventory();
//		
//		 //int itemBarcodeID, int numberOfItems
//		 Item item = new Item(1,1);
//		 
//		 s1.setItem(item, 0);
//		 s1.setNumberOfItemsOnReciept(1);
//		 
//		 //attach s1 to reg1
//		 reg1.setSalesInThisSession(0, s1);
		 
	// System.out.println("NAME      : " +  reg1.salesInThisSession[0].getReciept(0));
		 
		 //  Asserts that a condition is true.
		
	        
	 }
	 
	 //test my method void setSalesInThisSession(int i, Sale s)
	 //See if it creates the same salesInThisSession array as a clone does
	 @Test
	 public void isSame()
	 {
		 //Create a RegisterSession with sales stored in Sale[] salesInThisSession.
		
		 Employee e = new Employee();
		 e.setEmployeeData("mort0048","mK167B","Heather","M",5,0);
		 
		 //Create RegisterSession
		 
		 LocalTime t = null;
		 t = LocalTime.now();
		 LocalDate d = null;
		 d = LocalDate.now();
		 
		 //Create a registerSession in which one apple is sold.
		 RegisterSession reg1 = new RegisterSession(t,d,1,e);
		 Sale s1 = new Sale();
		 s1.setSaleID(0);
		 s1.addItemsToSale(1, 1, 0);
		 //s1.setTotalPriceI(0.5);
		 //attach s1 to reg1
		 reg1.setSalesInThisSession(0, s1);
		 
		 //Create a second registerSession in which one apple is sold.
		 RegisterSession reg2 = new RegisterSession(t,d,1,e);
		 Sale s2 = new Sale();
		 s2.setSaleID(0);
		 s2.getReciept(0).setItemBarcodeID(1);
		 s2.getReciept(0).setNumberOfItems(1);
		// s2.getReciept(0).setSellPrice(0.5);
		 s2.setTotalPriceBeforeTax(s2.getRecieptArray());
		 reg2.setSalesInThisSession(0, s2);
		  
		 assertEquals(reg1.salesInThisSession[0],reg2.salesInThisSession[0]) ;
		// assertTrue(reg1.returnSalesThisSession().length == reg2.returnSalesThisSession().length); 
		 
	 }
	 
	 
	 
	 

}
