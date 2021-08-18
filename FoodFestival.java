	package project;

	import java.util.Scanner; //this program will use user input
	

	public class FoodFestival {
		
		//Outside of main class so they're field variables; values will change regardless of method
		//static allows them to be called inside a method
		// initialize strings so they can be changed in future; give them a value to begin with so it can change later
		
		static String response = " ";
		static String userName = " "; 
		static String orderString = " ";
		static Scanner userInput = new Scanner(System.in); 
		
		//field scanner bc input would be needed ALL throughout the whole program
		
		public static void main(String[] args) { 
			boolean orderedYet = true;  //while loop makes program repeat question until yes or no is answered
			
			
			//directs program then runs method/program depending on response
			
			System.out.println("Welcome to the food festival!\n"+ "Would you like to place an order?\n");
			response = userInput.next();    
			
			//scans for user response of yes, no or other
			
			while (orderedYet == true) {         //this boolean allows for a loop to keep asking for an order until they get yes/no
			if (response.equalsIgnoreCase("no")) {   //equals.ignoreCase makes response string case insensitive
				
				System.out.println("Thank you for stopping by, maybe next time you’ll sample our menu.");
				
				orderedYet = false; 
				
				
			} else if (response.equalsIgnoreCase("yes")) { 
				System.out.println("What is your name for the order?"); 
				userName = userInput.next(); 
				orderedYet = false;
				yesResponse();  
				
				
				//if user responds yes, separate set of instructions
				//method for yes response, or else everything would be under this if statement/branch	
		
			} else {    //anything other than yes or no
				System.out.println("Would you like to place an order?"); 
				response = userInput.next(); 
				orderedYet = true;
				
			}  } }
		
		
		public static void yesResponse() {
			boolean menuChosen = true;    //this loop allows for user to return to main menu and still read input at main menu
			
			int firstChoice; //variable for user menu selections
			int drinkChoice;  //stores user choice for drink
			int sideChoice; //nested menu, similar to toppings menu in sample
			int mainChoice;
			int dessertChoice;
			int extrasChoice;
		  
			//int variables pick the option from array below/shown in orderString
			
			
			String Drinks[] = {"Nothing","Iced Tea","Water","Orange Juice"};
			String Mains[] = {"Nothing", "Garden Burger", "Quesadilla", "Garden Salad"};  //arrays for menu choices, easier to add/store in orderString
			String Desserts[] = {"Nothing","Cheesecake", "Ice Cream", "Pie of your choice!"};
			String Sides[] = {"Nothing","French Fries","Salad","Extra Cheese"};
			String Extras[] = {"Nothing","Whip Cream","Chocolate","Fruit"};
		
			
		while (menuChosen == true ) {
			displayMenu(); // I knew I would have to constant show the menu again so I made it a method to call back
			firstChoice = userInput.nextInt();
			
			switch (firstChoice) {
				case 0:
				System.out.print("Here is your order, " +userName+ ": \n"
						+ orderString+ " \n"
						+ "Enjoy your meal!\n"
						+ "");
				menuChosen = false;   // Calls back to outer while loop to still accept input at main menu
				break;
				 
				case 1:
				System.out.print("Drinks Menu:\n"
						+ " 0 - Nothing\n"
						+ " 1 - Iced Tea\n"
						+ " 2 - Water\n"
						+ " 3 - Orange Juice\n"
						+ "Enter the number for your drink selection:");
				drinkChoice = userInput.nextInt();
				
				switch (drinkChoice) {
				case 0:
				case 1:
				case 2:
				case 3:
				menuChosen = true;
				break;
				}
				orderString = "Drink: ["+(Drinks[drinkChoice])+"]\n";   //drink selection is stored in orderString with username as well
				break;
				 
				case 2:
				System.out.print("Meatless Mains, :\n"
						+ "  0 - Nothing\n"
						+ "  1 - Garden Burger\n"
						+ "  2 - Quesadilla\n"
						+ "  3 - Garden Wrap\n"
						+ "Enter the number for your selection: ");  
				mainChoice = userInput.nextInt();      //reads for main course selection
					
					switch (mainChoice) {
					case 0:             // if user chooses 0 at main menu, it will show user's selections
					menuChosen = true;
					break;  
						
					case 1:  //if user picks a main, it asks for a side, similar to toppings (nested menu)
					case 2:
					case 3:
						System.out.print("Pick a side: \n"
						+ "   0 - Nothing\n"
						+ "   1 - French Fries\n"
						+ "   2 - Salad\n"
						+ "   3 - Extra Cheese\n"
						+ "Selection: ");
						sideChoice = userInput.nextInt();
						
					orderString = (orderString + "Main: [" + Mains[mainChoice] + ": " + Sides[sideChoice]+ "]\n");
					
					break; }
					menuChosen = true;
				break;
			 
				case 3:
				System.out.print("Desserts Menu:\n"
						+ " 0 - Nothing\n" 
						+ " 1 - Cheesecake\n" 
						+ " 2 - Ice Cream\n" 
						+ " 3 - Pie of your choice!\n"
						+ "Enter the number for your dessert selection: "); 
				dessertChoice = userInput.nextInt();
				
					switch (dessertChoice) {
					case 0:
						menuChosen = true; //returns to main menu after selection
					break;
					
					case 1:
					case 2:
					case 3:
						System.out.print("Select an Extra for your dessert:\n"  //toppings for dessert
						+ "  0 - Nothing\n"
						+ "  1 - Whip Cream\n"
						+ "  2 - Chocolate\n"
						+ "  3 - Fruit\n"
						+ "Enter number for extra selection: ");
						extrasChoice = userInput.nextInt();
						
				orderString = (orderString + "Dessert: [" +Desserts[dessertChoice]+ ": " +Extras[extrasChoice]+"]" );
						break;	}
				menuChosen = true;
				break; }  }   }     
		 
		
			
		public static void displayMenu()	{
			System.out.print("Select from menu, " +userName+ ":\n"
					+ "   0 - Nothing\n" + "   1 - Drinks\n" 
					+ "   2 - Meatless Mains\n" 
					+ "   3 - Desserts\n"
					+ "Enter the number for your selection:"); }
		
			}

