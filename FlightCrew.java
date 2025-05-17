package airportsystem;


public class FlightCrew extends Person {

	private String crewId; 
	private Hotel selectedHotel;
	
	public FlightCrew(String crewId) {
		super();
		this.crewId = crewId;
	}

	public String getCrewId() {
		return crewId;
	}

	public void setCrewId(String crewId) {
		this.crewId = crewId;
	}

	public Hotel getSelectedHotel() {
		return selectedHotel;
	}

	public void setSelectedHotel(Hotel selectedHotel) {
		this.selectedHotel = selectedHotel;
	}

	public static void printOptions() {
            System.out.println("\n\t  *-------------------------------------* ");   
            System.out.println("\n\t\tpress 1 to view flights");
            System.out.println("\t\tPress 2 to select Hotel");
            System.out.println("\t\tPress 0 to go back");
            System.out.println("\n\t  *-------------------------------------* ");  
    }

	@Override
	public String toString() {
		return "\tFlightCrew [crewId=" + crewId + "]";
	}
}