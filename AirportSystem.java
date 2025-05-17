package airportsystem;
import java.util.ArrayList;

public class AirportSystem {

	private ArrayList<Manger> mangers;
	private ArrayList<FlightCrew> flightCrews;
	private ArrayList<Passenger> passengers;
	private ArrayList<Flight> flights;
	private ArrayList<Hotel> hotels;

	public AirportSystem() {
		mangers = new ArrayList<Manger>();
		flightCrews = new ArrayList<FlightCrew>();
		passengers = new ArrayList<Passenger>();
		flights = new ArrayList<Flight>();
		hotels = new ArrayList<Hotel>();
	}

	public void addManger(Manger manger) {
		mangers.add(manger);
	}

	public ArrayList<Manger> getMangers() {
		return mangers;
	}

	public void addFlightCrew(FlightCrew flightCrew) {
		flightCrews.add(flightCrew);
	}

	public ArrayList<FlightCrew> getFlightCrews() {
		return flightCrews;
	}

	public void addPassenger(Passenger passenger, int flightNo) {
		for (int index = 0; index < flights.size(); index++)
                    if (flights.get(index).getFlightNo() == flightNo) {//if statment to check wither the flight number exists
				passengers.add(passenger);
				passenger.getFlights().add(flights.get(index));
				return;
			}
		System.out.println("\tFlight not found");
	}

	public void addFlight(Flight flight) {//call method createOrUpdateFlight from Application class to add flight after creating
		flights.add(flight);
	}

	public ArrayList<Flight> getFlights() {
            //called from application for case 2 from flight crew menu from application class
		return flights;
	}

	public void addHotel(Hotel hotel) {
		hotels.add(hotel);
	}

	public ArrayList<Hotel> getHotels() {
		return hotels;
	}

	public void viewAllFlights() {
             //called from switch case 4 for manager menu
            //called from switch case 1 from flight crew menu
		System.out.print("\n\n");
		for (Flight flight : flights)//For each loop to print each flight in the flights list
			System.out.println(flight.toString());
	}

	public Flight viewFight(int flightNo) {
		for (Flight flight : flights)
			if (flight.getFlightNo() == flightNo) {
//For each loop to compare each flight in the flights list by the flight number
				System.out.println(flight.toString());
				return flight;
			}
		System.out.println("\tFlight not found");
		return null;
	}
      
	public void deleteFlight(int flightNo) {//called from deleteFligth in application class
		for (int index = 0; index < flights.size(); index++)
			if (flights.get(index).getFlightNo() == flightNo) {
                            //if statment to check if entered flight number = existing flight number 
				flights.remove(index);  //in the list of flight is equale to the entered flight number
                                System.out.println("\t  *-------------------------------------* ");
                                System.out.println("\t          Flight deleted successfully");
				System.out.println("\t  *-------------------------------------* ");        
				return;
			}
		System.out.println("\tFlight not found");
	}
      
	public void editFlight(Flight flight) {
	//called from editFlight metod from appilcation class
            for (int index = 0; index < flights.size(); index++)//valid scope
			if (flights.get(index).getFlightNo() == flight.getFlightNo()) { //compare flight num
				flights.set(index, flight);//flight number of object flight
                                System.out.println("\t  *-------------------------------------* ");
				System.out.println("\t         Flight updated successfully");
                                System.out.println("\t  *-------------------------------------* ");
				return;
			}
		System.out.println("\tFlight not found");
	}
        
        public int isFlight(int flightNo){
            int isFlight=0;
            

            for (int index = 0; index < flights.size(); index++){
                Flight flight= flights.get(index);
                if (flight.getFlightNo() == flightNo){
                    isFlight++;
                }
            }
            
            return isFlight;
            
        }
}
