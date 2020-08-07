import java.util.HashMap;

//Hashmap here holding ItemIn's

public class Inventory {
	
	
	//HashMap declaration
	 HashMap<String, Item> myInventoryMap;

	public Inventory() {
		
		//This Map should really read in from a data File, but here is some sample data.
		//   
		
		myInventoryMap = new HashMap<String, Item>();
		setInventory();
		
		//Data - put stuff into the HashMap
		
//Item Holds: 
//Item(String nameOfItem,int itemBarcodeID, double sellPrice, int numberOfItems,int numOfItemsInInventory,double buyPrice, String supplier,int threshold) 
		
		
	}
	public void setInventory()
	{

		this.myInventoryMap.put("1", new Item("apples",   01,  0.50,0,  44, 00.20, "Sysco" ,   10));
		this.myInventoryMap.put("2", new Item("bananas",  02,  0.10,0,  44, 00.05, "Sysco" ,   10));
		this.myInventoryMap.put("3", new Item("CatFood",  03, 12.95,0,  20, 06.25, "SuperValu", 5));
		this.myInventoryMap.put("4", new Item("DogFood",  04, 15.50,0,   7, 10.00, "SuperValu", 5));
		
		this.myInventoryMap.put("5", new Item("Eggplant", 05,  2.50,0, 44, 00.20, "Sysco" ,    5));
		this.myInventoryMap.put("6", new Item("Flowers",  06,  4.50,0,  44, 00.05, "Sysco" ,    5));
		this.myInventoryMap.put("7", new Item("Grapes",   07,  4.95,0,  20, 06.25, "SuperValu", 5));
		
	}

	HashMap<String, Item> getInventory()
	{
		return this.myInventoryMap;
	}
	
	
	
	public int getBarcode(int barcode)
	{
		String s = String.valueOf(barcode);
		
		System.out.println("" + this.myInventoryMap.get(s));
		
		return this.myInventoryMap.get(s).getItemBarcodeID();
	}
	
	
	public String getNameOfItem(int barcode)
	{
		//Turn the int value barcode into a String that matches the key in the HashMap.
		
		//This has something to do with the strange addres output!
		String s = String.valueOf(barcode);
		
		//System.out.println("s = " + s);
		
		//HashMap h = this.myInventoryMap;
		
		// System.out.println("h.get(s) =" + h.get(s));
		 
		//This is the condition to verify barcode input by user.
	    // h.containsKey("" + s));
		//System.out.println(" " );
		System.out.println("|----" + this.myInventoryMap.get(s).getName() + "-------------------------");
		//System.out.println(" " );
		
		return (this.myInventoryMap.get(s).getName());
	}
	
	public String getItemName(int barcode)
	{
		String s = String.valueOf(barcode);
		String s2 = this.myInventoryMap.get(s).getName();
		
	return s2;
	}
	
	public int getThreshold(int barcode)
	{

		String s = String.valueOf(barcode);
		
		Item element = this.myInventoryMap.get(s);
	
		int thresh = element.getThreshold();
	
		return thresh;
	}
	
	public double getSellPrice(int barcode)
	{
		String s = String.valueOf(barcode);
		
		Item element = this.myInventoryMap.get(s);
	
		double price = element.getSellPrice();
		
		return price;
	}
	// note : this should be int
	public double getNumInInventory(int barcode)
	{
		String s = String.valueOf(barcode);
		
		Item element = this.myInventoryMap.get(s);
	
		int num = (int) element.getNumberOfItemsInInventory();
		
		return num;
	}
	
	public double getNumItems(int barcode)
	{
		String s = String.valueOf(barcode);
		
		Item element = this.myInventoryMap.get(s);
	
		int num = (int) element.getNumberOfItems();
		
		return num;
	}
	
	public String getSupplier(int barcode)
	{
		String s = String.valueOf(barcode);
		
		Item element = this.myInventoryMap.get(s);
	
		String supplier = element.getSupplier();
		
		return supplier;
	}

	public double getBuyPriceOfItem(int barcode)
	{

		String s = String.valueOf(barcode);
		
		Item element = this.myInventoryMap.get(s);
		
		double price = element.getBuyPrice();
		
		return price;
	}
	
	public Inventory decreaseInventory(int barcode, int numOfItems)
	{
		//Get number in inventory
		
		String s1 = String.valueOf(barcode);
		
		Item element1 = this.myInventoryMap.get(s1);
	
		int numInInventory = (int) element1.getNumberOfItemsInInventory();
		
		System.out.println("");
		System.out.println("numInInventory = " + numInInventory );
		
	
		//Get threshhold
		
		String s3 = String.valueOf(barcode);
		
		Item element3 = this.myInventoryMap.get(s3);
	
		int thresh = element3.getThreshold();
		
		System.out.println("");
		System.out.println("Threshold = " + thresh );
		System.out.println("barcode = " + barcode );
		
		//Increase the threshold

	
	//Case 1 is tested and functional!!!!!!!!!!!!!!!!!!!
		switch(barcode) {
		   case 1 :
			 //Item(String nameOfItem,int itemBarcodeID, double sellPrice, int numberOfItems,int numOfItemsInInventory,double buyPrice, String supplier,int threshold) 
			  
			   
				  if ((numOfItems > numInInventory) || (( numInInventory - numOfItems) == thresh) || (( numInInventory - numOfItems ) < thresh) )
				  {
						//this.increaseInventory(numInInventory, numOfItems, thresh, barcode);
					  this.myInventoryMap.put("1", new Item("apples",  02,  0.50, numOfItems,   (numInInventory - numOfItems + 50), 00.20, "Sysco" , thresh));
								    
				  }
				  else
				  {
					  this.myInventoryMap.put("1", new Item("apples",  02,  0.50, numOfItems, (numInInventory - numOfItems), 00.20, "Sysco" , thresh));
				  }
				  
				break;
			   
			    
	//Case 2 is tested and functional!!!!!!!!!!!!!!!!!!! 
		   case 2 :
			   
			  if ((numOfItems > numInInventory) || (( numInInventory - numOfItems) == thresh) || (( numInInventory - numOfItems ) < thresh) )
			  {
					//this.increaseInventory(numInInventory, numOfItems, thresh, barcode);
				  this.myInventoryMap.put("2", new Item("bananas",  02,  0.10, numOfItems, (numInInventory - numOfItems + 50), 00.05, "Sysco" , thresh));
							    
			  }
			  else
			  {
				  this.myInventoryMap.put("2", new Item("bananas",  02,  0.10, numOfItems,   (numInInventory - numOfItems) , 00.05, "Sysco" ,  thresh));
			  }
			  
			  break;
		
		      
		   case 3 :
			   
				
			   
				
				if ((numOfItems > numInInventory) || ( (numInInventory - numOfItems) == thresh) || ( (numInInventory - numOfItems) < thresh) )
				{
					//this.increaseInventory(numInInventory, numOfItems, thresh, barcode);
					this.myInventoryMap.put("3", new Item("CatFood",  03, 12.95,numOfItems, (numInInventory - numOfItems + 50), 06.25, "SuperValu", 5));
					    
				}
				else
				{
					this.myInventoryMap.put("3", new Item("CatFood",  03, 12.95,numOfItems, (numInInventory - numOfItems), 06.25, "SuperValu", 5));
				}
				
				break;
				//return this;
			    
		   case 4 :
			   
				if ((numOfItems > numInInventory) || ( (numInInventory - numOfItems) == thresh) || ( (numInInventory - numOfItems) < thresh) )
				{
					//this.increaseInventory(numInInventory, numOfItems, thresh, barcode);
					this.myInventoryMap.put("4", new Item("DogFood",  04, 15.50, numOfItems, (numInInventory - numOfItems + 50), 10.00, "SuperValu", 5));
					    
				}
				else
				{
					this.myInventoryMap.put("4", new Item("DogFood",  04, 15.50, numOfItems, (numInInventory - numOfItems), 10.00, "SuperValu", 5));
				}
			   break;
			   //return this;
			   
		   case 5 :
			   
				if ((numOfItems > numInInventory) || ( (numInInventory - numOfItems) == thresh) || ( (numInInventory - numOfItems) < thresh) )
				{
					//this.increaseInventory(numInInventory, numOfItems, thresh, barcode);
					 this.myInventoryMap.put("5", new Item("Eggplant", 05,  2.50, numOfItems,  (numInInventory - numOfItems + 50), 00.20, "Sysco" , 5));
					    
				}
				else
				{
					this.myInventoryMap.put("5", new Item("Eggplant", 05,  2.50, numOfItems,  (numInInventory - numOfItems), 00.20, "Sysco" , 5));
				}
			   break;
			
			   
		   case 6 : 
			   
				if ((numOfItems > numInInventory) || ( (numInInventory - numOfItems) == thresh) || ( (numInInventory - numOfItems) < thresh) )
				{
					//this.increaseInventory(numInInventory, numOfItems, thresh, barcode);
					this.myInventoryMap.put("6", new Item("Flowers",  06,  4.50, numOfItems,  (numInInventory - numOfItems + 50), 00.05, "Sysco" , 5));
					    
				}
				else
				{
					this.myInventoryMap.put("6", new Item("Flowers",  06,  4.50, numOfItems,  numInInventory - numOfItems, 00.05, "Sysco" , 5));
				}
			   break;
			   //return this;
			   
		   case 7:
			   
				if ((numOfItems > numInInventory) || ((numInInventory - numOfItems) == thresh) || ( (numInInventory - numOfItems) < thresh) )
				{
					//this.increaseInventory(numInInventory, numOfItems, thresh, barcode);
					this.myInventoryMap.put("7", new Item("Grapes",   07,  4.95, numOfItems, (numInInventory - numOfItems + 50), 06.25, "SuperValu", 5));
					    
				}
				else
				{
					this.myInventoryMap.put("7", new Item("Grapes",   07,  4.95, numOfItems,   numInInventory - numOfItems, 06.25, "SuperValu", 5));
				}
				break;
				//return this;
		}
		
		return this;

	}
	
	private void increaseInventory(int numInInventory, int numItems, int thresh, int barcode)
	{
		String s = "";
		
		String barcodeString = Integer.toString(barcode);
		
		String name = getNameOfItem(barcode);
		double sellPrice = getSellPrice(barcode);
		
		//Increase inventory by 50
		//THis line is broken!!!!!!!!!!!!!!!!!!!!!!!
		//int inventoryIncrease = 
		
		double buyPrice = getBuyPriceOfItem(barcode);
		
		
		
		String sup = getSupplier(barcode);
		int threshold = getThreshold(barcode);
		
		int amount = 0;
		amount = (int)this.getNumInInventory(barcode);
		
	
		
		//Increase inventory by 50 Items
	
		//Item				(String nameOfItem,				int itemBarcodeID, double sellPrice, int numberOfItems,int numOfItemsInInventory,double buyPrice, String supplier,int threshold) 
		//this.myInventoryMap.put(barcodeString, new Item(name, barcode, sellPrice, numItems, inventoryIncrease, buyPrice, sup, threshold));		

		// this.myInventoryMap.put(barcodeString, new Item(name, barcode, sellPrice, numItems, amount + 50, buyPrice, sup, threshold));		
		
		switch(barcode) {
		
		   case 1 :
			   
			 //Item(String nameOfItem,int itemBarcodeID, double sellPrice, int numberOfItems,int numOfItemsInInventory,double buyPrice, String supplier,int threshold) 
			// "1", new Item("apples",  01,  0.50, numOfItems,  44, 00.20, "Sysco" ,   10));
			  // this.myInventoryMap.put("1", new Item("apples",  02,  0.50, numItems,   (amount + 50), 00.2, "Sysco" ,   thresh));
			   
			 System.out.println(" ");
			 System.out.println("         /\\");
			 System.out.println("        /  \\");
			 System.out.println("        \\  /");
			 System.out.println("         \\/");
			 System.out.println("    _____|_____ ");
			 System.out.println("   /           \\");
			 System.out.println("  /  50 APPLES  \\");
			 System.out.println(" |   ORDERED    |");
			 System.out.println(" |    FROM      |");
			 System.out.println(" |    Sysco     |");
			 System.out.println(" \\             /");
			 System.out.println("  \\           /");
			 System.out.println("   \\         /");
			 System.out.println("    --------");
			 
			 break;
			

			   case 2 :
				   
					System.out.println("");
					System.out.println("    ---");
					System.out.println("   /   \\");
					System.out.println("  /     \\                                   -----");
					System.out.println("||       \\                               //      \\");
					System.out.println(" \\         \\                            //       //");
					System.out.println("  \\          \\-------------------------//       //");
					System.out.println("    \\                                         //");
					System.out.println("      \\         50 BANANAS ORDERED          //");
					System.out.println("       \\              FROM Sysco         //");
					System.out.println("         \\                            //");
					System.out.println("           ---------------------------     ");
				   
				 
				 break;  
			
				
			   case 3:
				   
					System.out.println("");
					System.out.println("    ---------------------");
					System.out.println("   |                     |");
					System.out.println("   |                     | ");
					System.out.println("   |                     |");
					System.out.println("   |                     |");
					System.out.println("   |                     |");
					System.out.println("   |      50 Cans        |");
					System.out.println("   |      Cat FOOD       |");
					System.out.println("   |  ORDERED FROM Sysco |");
					System.out.println("   |                     |");
					System.out.println("    ---------------------     ");
					
					
					break;
				
			   case 4:
				   
					System.out.println("");
					System.out.println("    ---------------------");
					System.out.println("   |                     |");
					System.out.println("   |                     | ");
					System.out.println("   |                     |");
					System.out.println("   |                     |");
					System.out.println("   |                     |");
					System.out.println("   |      50 Cans        |");
					System.out.println("   |      DOG FOOD       |");
					System.out.println("   |  ORDERED supervalu  |");
					System.out.println("   |                     |");
					System.out.println("    ---------------------     ");
					
				
					break;
			
					
			   case 5:
				   
					System.out.println("");
					System.out.println("    ---");
					System.out.println("   /   \\");
					System.out.println("  /     \\                                   -----");
					System.out.println("||       \\                               //      \\");
					System.out.println(" \\         \\                            //       //");
					System.out.println("  \\          \\-------------------------//       //");
					System.out.println("    \\                                         //");
					System.out.println("      \\         50 Eggplant ORDERED          //");
					System.out.println("       \\              FROM Sysco         //");
					System.out.println("         \\                            //");
					System.out.println("           ---------------------------     ");
					
					break;
					
			   case 6:
				   
				   System.out.println("            ---");
				   System.out.println("          //    \\");
				   System.out.println("         ||     || ");
				   System.out.println("          \\    // ");
				   System.out.println("    ___    \\  //   ___  ");
				   System.out.println("   //   \\  \\//  //   \\");
				   System.out.println("  //      \\    //       \\");
				   System.out.println(" ||                      ||  ");
				   System.out.println("  \\      //  || \\      //  ");
				   System.out.println("   \\    //   ||  \\    //");
				   System.out.println("     ----     ||    ----");
				   System.out.println("              ||");
				   System.out.println("  FLOWERS ORDERED from Sysco   ");
				   System.out.println("");
			
				   break;
				   
			   case 7:
				   
					 
				   System.out.println("             ---");
				   System.out.println("           //     \\");
				   System.out.println("          ||      || ");
				   System.out.println("           \\     // ");
				   System.out.println("     ___    \\   //    ___  ");
				   System.out.println("   //    \\   ---    //    \\");
				   System.out.println("  //      \\        //      \\");
				   System.out.println(" ||        ||       ||       ||  ");
				   System.out.println("  \\      //        \\       //  ");
				   System.out.println("   \\    //          \\     //");
				   System.out.println("     ----              ----");
				   System.out.println("              ");
				   System.out.println("  GRAPES ORDERED from SuperValu   ");
				   System.out.println("");
				   
				 break;
				   
		 
		}
	
	
	}
	
	public String applesOrdered()
	{
		String s = "";
		
		if ((this.getNumItems(1) > this.getNumInInventory(1)) || ( this.getNumInInventory(1) - this.getNumItems(1) == this.getThreshold(1)) || ( this.getNumInInventory(1) -  this.getNumItems(1) < this.getThreshold(1)) )
		{
		
		    s = s.concat(" " +  System.lineSeparator());
		    s = s.concat("         /\\" +  System.lineSeparator());
		    s = s.concat("        /  \\" +  System.lineSeparator());
		    s = s.concat("        \\  /" +  System.lineSeparator());
		    s = s.concat("         \\/" +  System.lineSeparator());
		    s = s.concat("    _____|_____ " +  System.lineSeparator());
		    s = s.concat("   /           \\" +  System.lineSeparator());
		    s = s.concat("  /  50 APPLES  \\" +  System.lineSeparator());
		    s = s.concat(" |   ORDERED    |" +  System.lineSeparator());
		    s = s.concat(" |    FROM      |" +  System.lineSeparator());
		    s = s.concat(" |    Sysco     |" +  System.lineSeparator());
		    s = s.concat(" \\             /" +  System.lineSeparator());
		    s = s.concat("  \\           /" +  System.lineSeparator());
		    s = s.concat("   \\         /" +  System.lineSeparator());
		    s = s.concat("    --------" +  System.lineSeparator());
		
		return s;
		}
		else 
			return s;
	}
	public String bananasOrdered()
	{
		String s = "";
		
		if ((this.getNumItems(2) > this.getNumInInventory(2)) || ( this.getNumInInventory(2) - this.getNumItems(2) == this.getThreshold(2)) || ( this.getNumInInventory(2) -  this.getNumItems(2) < this.getThreshold(2)) )
		{
		
		 s = s.concat("    ---"  +  System.lineSeparator());
		 s = s.concat("   /   \\" +  System.lineSeparator());
		 s = s.concat("  /     \\                                   -----" +  System.lineSeparator());
		 s = s.concat(" ||       \\                               //      \\" +  System.lineSeparator());
		 s = s.concat(" \\         \\                            //       //" +  System.lineSeparator());
		 s = s.concat("  \\          \\-------------------------//       //" +  System.lineSeparator());
		 s = s.concat("    \\                                         //" +  System.lineSeparator());
		 s = s.concat("      \\         50 BANANAS ORDERED          //" +  System.lineSeparator());
		 s = s.concat("       \\              FROM Sysco         //" +  System.lineSeparator());
		 s = s.concat("         \\                            //" +  System.lineSeparator());
		 s = s.concat("           ---------------------------     " +  System.lineSeparator());
		
		 return s;
		}
		else
			return s;
	}
	
	public String catFoodOrdered()
	{
		String s = "";
		
		if ((this.getNumItems(3) > this.getNumInInventory(3)) || ( this.getNumInInventory(3) - this.getNumItems(3) == this.getThreshold(3)) || ( this.getNumInInventory(3) -  this.getNumItems(3) < this.getThreshold(3)) )
		{
		s = s.concat("    ---------------------" +  System.lineSeparator());
		s = s.concat("   |                     |" +  System.lineSeparator());
		s = s.concat("   |                     | " +  System.lineSeparator());
		s = s.concat("   |                     |" +  System.lineSeparator());
		s = s.concat("   |                     |" +  System.lineSeparator());
		s = s.concat("   |                     |" +  System.lineSeparator());
		s = s.concat("   |      50 Cans        |" +  System.lineSeparator());
		s = s.concat("   |      Cat FOOD       |" +  System.lineSeparator());
		s = s.concat("   |  ORDERED FROM Sysco |" +  System.lineSeparator());
		s = s.concat("   |                     |" +  System.lineSeparator());
		s = s.concat("    ---------------------" +  System.lineSeparator());
		
			return s;
		}
		else
			return s;
	}
	
	public String dogFoodOrdered()
	{
		String s = "";
		
		if ((this.getNumItems(4) > this.getNumInInventory(4)) || ( this.getNumInInventory(4) - this.getNumItems(4) == this.getThreshold(4)) || ( this.getNumInInventory(4) -  this.getNumItems(4) < this.getThreshold(4)) )
		{
		s = s.concat("    ---------------------" +  System.lineSeparator());
		s = s.concat("   |                     |" +  System.lineSeparator());
		s = s.concat("   |                     | " +  System.lineSeparator());
		s = s.concat("   |                     |" +  System.lineSeparator());
		s = s.concat("   |                     |" +  System.lineSeparator());
		s = s.concat("   |                     |" +  System.lineSeparator());
		s = s.concat("   |      50 Cans        |" +  System.lineSeparator());
		s = s.concat("   |      Dog FOOD       |" +  System.lineSeparator());
		s = s.concat("   |  ORDERED FROM Sysco |" +  System.lineSeparator());
		s = s.concat("   |                     |" +  System.lineSeparator());
		s = s.concat("    ---------------------" +  System.lineSeparator());
		
		return s;
		}
		else
			return s;
	
		}
	
	public String eggplantOrdered()
	{
		String s = "";
		
		if ((this.getNumItems(5) > this.getNumInInventory(5)) || ( this.getNumInInventory(5) - this.getNumItems(5) == this.getThreshold(5)) || ( this.getNumInInventory(5) -  this.getNumItems(5) < this.getThreshold(5)) )
		{
		
		 s = s.concat("    ---");
		 s = s.concat("   /   \\");
		 s = s.concat("  /     \\                                   -----" +  System.lineSeparator());
		 s = s.concat(" ||       \\                               //      \\" +  System.lineSeparator());
		 s = s.concat(" \\         \\                            //       //" +  System.lineSeparator());
		 s = s.concat("  \\          \\-------------------------//       //" +  System.lineSeparator());
		 s = s.concat("    \\                                         //" +  System.lineSeparator());
		 s = s.concat("      \\         50 Eggplant ORDERED          //" +  System.lineSeparator());
		 s = s.concat("       \\              FROM Sysco         //" +  System.lineSeparator());
		 s = s.concat("         \\                            //" +  System.lineSeparator());
		 s = s.concat("           ---------------------------     " +  System.lineSeparator());
		
		return s;
		}
		else
			return s;
	}
	
	public String flowersOrdered()
	{
		 String s = "";
		 
		 if ((this.getNumItems(6) > this.getNumInInventory(6)) || ( this.getNumInInventory(6) - this.getNumItems(6) == this.getThreshold(6)) || ( this.getNumInInventory(6) -  this.getNumItems(6) < this.getThreshold(6)) )
		{
			 
		
		 s = s.concat("            ---" +  System.lineSeparator());
		 s = s.concat("          //    \\" +  System.lineSeparator());
		 s = s.concat("         ||     || " +  System.lineSeparator());
		 s = s.concat("          \\    // " +  System.lineSeparator());
		 s = s.concat("    ___    \\  //   ___  " +  System.lineSeparator());
		 s = s.concat("   //   \\  \\//  //   \\" +  System.lineSeparator());
		 s = s.concat("  //      \\    //       \\" +  System.lineSeparator());
		 s = s.concat(" ||                      ||  " +  System.lineSeparator());
		 s = s.concat("  \\      //  || \\      //  " +  System.lineSeparator());
		 s = s.concat("   \\    //   ||  \\    //" +  System.lineSeparator());
		 s = s.concat("     ----     ||    ----" +  System.lineSeparator());
		 s = s.concat("              ||" +  System.lineSeparator());
		 s = s.concat("  FLOWERS ORDERED from Sysco   " +  System.lineSeparator());
		 s = s.concat("");
		
		return s;
		}
		 else
			 return s;
	}
	
	public String grapesOrdered()
	{
		 String s = "";
		 
		 if ((this.getNumItems(7) > this.getNumInInventory(7)) || ( this.getNumInInventory(7) - this.getNumItems(7) == this.getThreshold(7)) || ( this.getNumInInventory(7) -  this.getNumItems(7) < this.getThreshold(2)) )
		{
		 
		 s = s.concat("                ---" +  System.lineSeparator());
		 s = s.concat("              //     \\" +  System.lineSeparator());
		 s = s.concat("             ||      || " +  System.lineSeparator());
		 s = s.concat("              \\     // " +  System.lineSeparator());
		 s = s.concat("     ___       \\   //    ___  " +  System.lineSeparator());
		 s = s.concat("   //    \\      ---    //    \\" +  System.lineSeparator());
		 s = s.concat("  //      \\           //      \\" +  System.lineSeparator());
		 s = s.concat(" ||        ||          ||       ||  " +  System.lineSeparator());
		 s = s.concat("  \\      //           \\       //  " +  System.lineSeparator());
		 s = s.concat("   \\    //             \\     //" +  System.lineSeparator());
		 s = s.concat("     ----                 ----" +  System.lineSeparator());
		 s = s.concat("              " +  System.lineSeparator());
		 s = s.concat("  GRAPES ORDERED from SuperValu   " +  System.lineSeparator());
		 s = s.concat("");
		
		return s;
		}
		 else
			 return s;
	}
	
	public String toString(Inventory i)
	{
		String s;
		
		s = "" + System.lineSeparator() + "INVENTORY " + System.lineSeparator() + "-------------- " + System.lineSeparator() + "ItemName  BarcodeID  SellPrice  NumItemsInInventory  buyPrice  supplier threshold " + System.lineSeparator() +
		                                       "   " + i.getNameOfItem(1) + "    " + i.getBarcode(1) + "          " + i.getSellPrice(1) + "       " + i.getNumInInventory(1) + "                  " + i.getBuyPriceOfItem(1) + "      " + i.getSupplier(1) + "       " + i.getThreshold(1)+ System.lineSeparator() +
		                                       "   " + i.getNameOfItem(2) + "   " + i.getBarcode(2) + "          " + i.getSellPrice(2) + "       " + i.getNumInInventory(2) + "                  " + i.getBuyPriceOfItem(2) + "     " + i.getSupplier(2) + "       " + i.getThreshold(2)+  System.lineSeparator() +	
		                                       "   " + i.getNameOfItem(3) + "   " + i.getBarcode(3) + "         " + i.getSellPrice(3) + "      " + i.getNumInInventory(3) + "                  " + i.getBuyPriceOfItem(3) + "     " + i.getSupplier(3) + "    " + i.getThreshold(3)+  System.lineSeparator() +
		                                       "   " + i.getNameOfItem(4) + "   " + i.getBarcode(4) + "         " + i.getSellPrice(4) + "        " + i.getNumInInventory(4) + "                 " + i.getBuyPriceOfItem(4) + "      " + i.getSupplier(4) + "    " + i.getThreshold(4)+  System.lineSeparator() +
		                                       "   " + i.getNameOfItem(5) + "  " + i.getBarcode(5) + "          " + i.getSellPrice(5) + "       " + i.getNumInInventory(5) + "                  " + i.getBuyPriceOfItem(5) + "      " + i.getSupplier(5) + "        " + i.getThreshold(5)+   System.lineSeparator() +
		                                       "   " + i.getNameOfItem(6) + "   " + i.getBarcode(6) + "          " + i.getSellPrice(6) + "       " + i.getNumInInventory(6) + "                  " + i.getBuyPriceOfItem(6) + "     " + i.getSupplier(6) + "        " + i.getThreshold(6)+  System.lineSeparator() +
		                                       "   " + i.getNameOfItem(7) + "    " + i.getBarcode(7) + "          " + i.getSellPrice(7) + "      " + i.getNumInInventory(7) + "                  " + i.getBuyPriceOfItem(7) + "     " + i.getSupplier(7) + "    " + i.getThreshold(7);
		return s;
	}

	

	}


