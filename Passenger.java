package airportsystem;


//passeger is a peron(inhertins)
public class Passenger extends Person {
	
	private String passportNo;
	private String passengerId;
	private String nationality;
	
	public String getPassportNo() {
		return passportNo;
	}
	
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	
	public String getPassengerId() {
		return passengerId;
	}
	
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public static void printOptions() { //view list for passenger options 
        System.out.println("\n\t  *-------------------------------------* ");    
        System.out.println("\n\t\tPress 1 to book new fligt");
        System.out.println("\t\tPress 2 to edit booking");
        System.out.println("\t\tPress 3 to delete booking");
	System.out.println("\t\tpress 4 to view flights");
	System.out.println("\t\tPress 0 to go back");
        System.out.println("\n\t  *-------------------------------------* ");   
    }
        
}