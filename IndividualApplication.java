import java.io.Serializable;

public class IndividualApplication implements Serializable {
	
	private String organization;
	private String position;
	private String interviewStatus;
	private String applicationStatus;
	
	public void newApplication() {
		
		// very sloppy. Should consider clearning up for data input validation
		
		MainDriver.input.nextLine();
		
		System.out.println("Organization: ");
		
		this.organization = MainDriver.input.nextLine();
		
		System.out.println("Position: ");
		
		this.position = MainDriver.input.nextLine();
		
		System.out.println("Interview Offered (Y/N/M): ");
		
		this.interviewStatus = MainDriver.input.nextLine();
		
		System.out.println("Application Status: ");
		
		this.applicationStatus = MainDriver.input.nextLine();
		
		System.out.println("Application successfully added");
		
	}
	
	public void modifyApplication() {
		
		// shoul dprompt user with selection to change field
		System.out.println("What would you like to change?\n1. Organization\n2. Postion\n3. Interview Status\n4. Application Status");
		
		// sentinel boolean 
		boolean invalid = true;
		
		while (invalid) {
			
			if (MainDriver.input.hasNextInt()) {
				
				int input = MainDriver.input.nextInt();
				
				switch (input) {
				
				case 1:
					MainDriver.input.nextLine();
					System.out.println("Please enter the new Organization name");
					this.organization = MainDriver.input.nextLine();
					invalid = false;
					break;
				case 2:
					MainDriver.input.nextLine();
					System.out.println("Please enter the new Position");
					this.position = MainDriver.input.nextLine();
					invalid = false;
					break;
				case 3:
					MainDriver.input.nextLine();
					System.out.println("Please enter the Interview Status");
					this.interviewStatus = MainDriver.input.nextLine();
					invalid = false;
					break;
				case 4:
					MainDriver.input.nextLine();
					System.out.println("Please enter the Application Status");
					this.applicationStatus = MainDriver.input.nextLine();
					invalid = false;
					break;
				default:
					MainDriver.input.nextLine();
					System.out.println("Please make a valid selection");
					break;
				
				}
				
			} else {
				System.out.println("Please make a valid selection");
				MainDriver.input.nextLine();
			}
			
			
		}
		
	}
	
	// method to quickly print info for user prompt. 
	// need a more concise one for object summary option
	public void displayApplication() {
		
		System.out.println(position + " at " + organization);
		
	}
	
	public void detailedInfo() {
		
		System.out.println("------------------");
		System.out.println(organization);
		System.out.println(position);
		System.out.println(interviewStatus);
		System.out.println(applicationStatus);
		System.out.println("------------------");
		
	}
	
	

}
