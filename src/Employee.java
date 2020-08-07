/*	File: Employee.java
 *  Package: TeamBackRow
 * 
 *
 *   Note: I set all the class variables private and all the methods as public.
 *   Although, whoever builds this class should set as many of the the methods 
 *   back to private as possible.
 *
 */
public class Employee {   // 7 class variables
	
	//unique identifier for Employee is the login, like mort0048
	private String employeeLogin;
	private String employeePsswrd;
	
	private String employeeFirstName;
	private String employeeLastName;
	
	//This keeps track of all the Employee's Session for the day by holding
	//	all the SessionID's inside an array. Their first session of the day 
	//  will be in TodaysSessions[0], their second will be in TodaysSessions[1], etc.
	
	private int sizeOfArray;
	
	//This must be turned into an array that is size: sizeOfArray
	//It holds all the session IDs that an Employee used.
	
	private RegisterSession todaysSessions [];
	private int currentSessionID;
	
//CONSTRUCTOR #1	
//	public Employee() 
//	{
//		
//		//This constructor initializes all the Employee class variables.
//		int sizeOfArray = 10;
//		
//		String employeeLogin = "";
//		String employeePsswrd = "";
//		
//		String employeeFirstName = "";
//		String employeeLastName = "";
//		
//		//RegisterSession[] todaysSessions = new RegisterSession[sizeOfArray];
//		int currentSessionID = 0;
//	}



	//7 Setter Methods////////////////////////////////////////////////////////////////
	
	
		public void setCurrentSessionId(int id)
		{
			this.currentSessionID = id;
			
		}
		public void setSizeOfArray(int sizeOfArray)
		{
			this.sizeOfArray = sizeOfArray;
		}
		public void setEmployeeLogin(String s)
		{
			this.employeeLogin = s;
		}
		
		public void setEmployeePsswrd(String p)
		{
			this.employeeLogin = p;
		}
		
		public void setEmployeeFirstName(String n)
		{
			this.employeeFirstName = n;
		}
		
		public void setEmployeeLastName(String l)
		{
			this.employeeLastName = l;
		}
//		public void settodaysSessions(int sizeOfArray, RegisterSessions [] todaysSess)
//		{
//			for (int i = 0; i < sizeOfArray + 1; i++)
//			{
//				this.todaysSessions[i] = todaysSess[i];
//			}
//		}

		
		//Getter Methods
		public String getEmployeeLogin()
		{
			return this.employeeLogin;
		}
		
		public String getEmployeePsswrd()
		{
			return this.employeePsswrd;
		}
		
		public String getEmployeeFirstName()
		{
			return this.employeeFirstName;
		}
		
		public String getEmployeeLastName()
		{
			return this.employeeLastName;
		}

		public int getCurrentSessionID()
		{
			return this.currentSessionID;
		}
		public int getCurrentSizeOfArray()
		{
			return this.sizeOfArray;
		}
		
	public void loadData(String s)
	{
		
				if (s.equals("alm4204"))
				{
					
					this.setEmployeeData("alm4204","2468A","Meshal","A",5,0);
				
				}
				else if (s.equals("khan0033"))
				{
				
					this.setEmployeeData("khan0033","1234C","Mohammad","Khan",5,0);
					
				}
				else if (s.equals("mort0048"))
				{
					this.setEmployeeData("mort0048","mK167B","Heather","M",5,0);
					
				}
				else if (s.equals("zho1751"))
				{
					this.setEmployeeData("zho1751","135B","Kelly","Zho",5,0);
					
				}
				else
				{
					System.out.println("That userName does not exist.");	
					System.out.println("Look up your name and psswrd in File: Employee.java");
					System.out.println("   You will find it in the loadData() method.");
				}
		System.out.println(this.toString());
	}
	
	public boolean tryPassword(String s)
	{
		if (this.employeePsswrd.equals(s))
		{
			System.out.println("");
			System.out.println("Password accepted.");
			System.out.println("");
			
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
//Setter Method
	
	//This is filling in data for an Employee object, similar to a constructor, but
	//      it doesn't allocate memory, it just fills in the class variables with data.
	
	//allEmployees[0].setEmployeeData("alm4204","2468A","Meshal","A",5,0);
	public void setEmployeeData(String employeeLogin,String employeePsswrd,
			 String employeeFirstName,String employeeLastName,int sizeOfArray,
			 int currentSessionID)
	{
		//These should really use setter methods, not access the instance variables
		//   directly.
		this.employeeLogin = employeeLogin;
		this.employeePsswrd = employeePsswrd;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.sizeOfArray = sizeOfArray;
		//this.todaysSessions = todaysSessions;
			
		setCurrentSessionID(currentSessionID);
	}
	
	private void setCurrentSessionID(int id)
	{
		this.currentSessionID = id;
	}

	
	public String toString()
	{
		String s = "";
	
		
			
		s = " " + this.getEmployeeLogin() + " " + this.getEmployeePsswrd() + " " +
				 this.getEmployeeFirstName() + " " + this.getEmployeeLastName() +  " " +
				 " sessionID: " + this.currentSessionID + "  " + "sizeOfSessionsArray: " + this.sizeOfArray;
			
		return s;
	}

}
