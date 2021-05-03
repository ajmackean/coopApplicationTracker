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
				userSelection = MainDriver.input.nextInt();
				if (userSelection >= 1 && userSelection < applications.size()) {
					applications.remove(userSelection - 1);
				}
				else {
					System.out.println("Please make a valid selection");
				}
			} else {
				System.out.println("Please make a valid selection");
			}
			
		}
		
		
	}
	
	public void modifyApplicationList() {
		
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
				userSelection = MainDriver.input.nextInt();
				if (userSelection >= 1 && userSelection < applications.size()) {
					applications.get(userSelection - 1).modifyApplication();
				}
				else {
					System.out.println("Please make a valid selection");
				}
			} else {
				System.out.println("Please make a valid selection");
			}
			
		}
	
		
		
	}
	
	public void printArray() {
		
		for (IndividualApplication number : applications) {
			number.detailedInfo();
		}
		
	}

}
