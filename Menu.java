import java.io.*;
import java.util.ArrayList;

// file i/o methods are written, just need to be implemented

public class Menu {
	
	ApplicationOverview myApplications = new ApplicationOverview();
	
	// constructor method
	public Menu() {
		
		readFile();
		
		System.out.println("============================================================");
		System.out.println("Welcome to the Application Tracker. Please select an option.");
		System.out.println("File will not be saved unless program is exited.");


		// sentinel control boolean 
		boolean invalid = true;
		
		while (invalid) {
			
			System.out.println("============================================================");
			System.out.println("1. View current applications\n2. Add application \n3. Modify an application \n4. Quit");
			System.out.println("============================================================");
			
			// checks for integer input
			if (MainDriver.input.hasNextInt()) {
				
				int input = MainDriver.input.nextInt();
				
				switch (input) {
				
				case 1:
					myApplications.printArray();
					break;
				case 2:
					myApplications.addApplication();
					break;
				case 3:
					// nested boolean sentinel control variable
					boolean nestedInvalid = true;
					
					System.out.println("What would you like to do? \n1. Change application details \n2. Delete application \n3. Go back");
					MainDriver.input.nextLine();
					
					while(nestedInvalid) {
						
						if (MainDriver.input.hasNextInt()) {
							

							int nestedInput = MainDriver.input.nextInt();
							
							if (nestedInput == 1) {
								myApplications.modifyApplicationList();
								nestedInvalid = false;
								MainDriver.input.nextLine();
							}
							
							else if (nestedInput ==2) {
								myApplications.removeApplication();
								nestedInvalid = false;
								MainDriver.input.nextLine();
							}
							
							else if (nestedInput == 3) {
								System.out.println("Going back");
								nestedInvalid = false;
								MainDriver.input.nextLine();
							}
							
							else {
								System.out.println("Please make a valid selection");
							}
							
						} else {
							System.out.println("Please choose from the options listed");
							MainDriver.input.nextLine();
						}
						
					}
					
					break;
				case 4:
					// this option needs to write object file
					createFile();
					invalid = false;
					break;
				default:
					System.out.println("Please make a valid selection");
				
				}
			} else {
				System.out.println("Please select from the menu provided.");
				MainDriver.input.nextLine();
			}
			
		}
		
		// lets the user know that the program was exited successfully.
		System.out.println("Saving and exiting the program. ");

	
	}


	
	public void createFile() {
		
		try {
			FileOutputStream fileOut = new FileOutputStream("object.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(myApplications);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void readFile() {
		
		try {
			FileInputStream fileIn = new FileInputStream("object.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			this.myApplications = (ApplicationOverview)in.readObject();
			in.close();
			fileIn.close();
			return;

		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			return;
		}
		

	}
	
	
}
