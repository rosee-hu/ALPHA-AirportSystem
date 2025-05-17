package airportsystem;


public class Flight {
	
	private int flightNo;
	private String nameOfAirlines;
	private String destination;
	private String timeOfDeparture;
	private String timeOfArrival;
	private int stops;
	private String timeOfBoarding;
	private Booking booking;
	
	private static int nextFilghtNo = 1;
		
	public Flight(int flightNo, String nameOfAirlines, String destination, String timeOfDeparture, String timeOfArrival,
			int stops, String timeOfBoarding) {
		super();//to call (toString) methode in Object super-class
		this.flightNo = flightNo;
		this.nameOfAirlines = nameOfAirlines;
		this.destination = destination;
		this.timeOfDeparture = timeOfDeparture;
		this.timeOfArrival = timeOfArrival;
		this.stops = stops;
		this.timeOfBoarding = timeOfBoarding;
	}

	public Flight(String nameOfAirlines, String destination, String timeOfDeparture, String timeOfArrival, int stops,
			String timeOfBoarding) {
		super();
		this.nameOfAirlines = nameOfAirlines;
		this.destination = destination;
		this.timeOfDeparture = timeOfDeparture;
		this.timeOfArrival = timeOfArrival;
		this.stops = stops;
		this.timeOfBoarding = timeOfBoarding;
		this.flightNo = nextFilghtNo;
		nextFilghtNo++;
	}

	public int getFlightNo() {
		return flightNo;
	}
	
	public String getNameOfAirlines() {
		return nameOfAirlines;
	}
	
	public void setNameOfAirlines(String nameOfAirlines) {
		this.nameOfAirlines = nameOfAirlines;
	}
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTimeOfDeparture() {
		return timeOfDeparture;
	}
	
	public void setTimeOfDeparture(String timeOfDeparture) {
		this.timeOfDeparture = timeOfDeparture;
	}
	
	public String getTimeOfArrival() {
		return timeOfArrival;
	}
	
	public void setTimeOfArrival(String timeOfArrival) {
		this.timeOfArrival = timeOfArrival;
	}
	
	public int getStops() {
		return stops;
	}
	
	public void setStops(int stops) {
		this.stops = stops;
	}
	
	public String getTimeOfBoarding() {
		return timeOfBoarding;
	}
	
	public void setTimeOfBoarding(String timeOfBoarding) {
		this.timeOfBoarding = timeOfBoarding;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "\n\t**********************************************************" + "\n\tFlight No= " + flightNo + " Name Of Airlines= " + nameOfAirlines + " \n\tDestination= " + destination
				+ " \n\tTime Of Departure= " + timeOfDeparture + " Time Of Arrival=" + timeOfArrival + " \n\tStops=" + stops
				+ " Time Of Boarding=" + timeOfBoarding + "  \n\t**********************************************************" ;
	}
	
}
