import java.util.ArrayList;

public class ApplicationOverview {
	
	// find a way to create folders/directories to load the object into
	
	// needs a constructor that uses file i/o to check if there's a user file and load the 
	// object array if it exists. 
	
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
		
		// method to quickly print info for user prompt
		for (IndividualApplication number : applications) {
			number.displayApplication();
		}
		// need something like ask user which application they wanna remove
		// applications.remove(index) where index = user selection - 1
		
		
	}
	
	public void modifyApplicationList() {
		
		// method to quickly print info for user prompt
		for (IndividualApplication number : applications) {
			number.displayApplication();
		}
		
		// need to prompt user which application they want to change.
		// applications.get(userSelection - 1).modifyApplication();
		
	}
	
	public void printArray() {
		
		for (IndividualApplication number : applications) {
			number.detailedInfo();
		}
		
	}
	
	public void saveInfo() {
		
		// should be called on the menu selection to quit the program. Writes the object array to file
		// make sure that the program outputs in the menu that it will not save until you quit
		
	}

}
