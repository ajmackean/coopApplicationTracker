import java.io.Serializable;
import java.util.ArrayList;

public class ApplicationOverview implements Serializable{
	
	// creates an object array of individual applications
	private ArrayList <IndividualApplication> applications = new ArrayList();
	
	// adds a new Applicatation to the array
	public void addApplication() {
		
		IndividualApplication job = new IndividualApplication();
		applications.add(job);
		// calls method to fill in object details by user
		job.newApplication();
		
	}
	
	public void removeApplication() {
		
		if (applications.size() == 0){
			
			System.out.println("You currently are not tracking any applications.");
			
		} else {
			
			int index = 1;
			
			int userSelection = 0;
			
			// method to quickly print info for user prompt
			for (IndividualApplication number : applications) {
				
				System.out.println("Application number " + index + ": ");
				index++;
				number.displayApplication();
			}
			
			System.out.println("Which application would you like to delete?");
			
			// boolean sentinel value
			boolean invalid = true;
			
			while (invalid) {
				
				if (MainDriver.input.hasNextInt()) {
					userSelection = MainDriver.input.nextInt() - 1;
					
					if (userSelection >= 0 && userSelection < applications.size()) {
						applications.remove(userSelection);
						invalid = false;
					} else {
						System.out.println("Please make a valid selection");

					}
								
				}  else {
					System.out.println("Please make a valid selection");
					MainDriver.input.nextLine();
				}
			}
			
		}
			
	}
	
	public void modifyApplicationList() {
		
		if (applications.size() == 0){
			
			System.out.println("You are not currently tracking any applications.");
			
		} else {
			
			int index = 1;
			
			int userSelection = 0;
			
			// method to quickly print info for user prompt
			for (IndividualApplication number : applications) {
				
				System.out.println("Application number " + index + ": ");
				index++;
				number.displayApplication();
			}
			
			System.out.println("Which application would you like to modify?");
			
			// boolean sentinel value
			boolean invalid = true;
			
			while (invalid) {
				
				if (MainDriver.input.hasNextInt()) {
					userSelection = MainDriver.input.nextInt() - 1;
					if (userSelection >= 0 && userSelection < applications.size()) {
						applications.get(userSelection).modifyApplication();
					}
					else {
						System.out.println("Please make a valid selection");
					}
				} else {
					System.out.println("Please make a valid selection");
					MainDriver.input.nextLine();
				}
				
			}
				
		}	
		
	}
	
	public void printArray() {
		
		for (IndividualApplication number : applications) {
			number.detailedInfo();
		}
		
	}

}
