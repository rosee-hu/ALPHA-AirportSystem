package airportsystem;
import java.util.ArrayList;

public class Person {

	private String name;
	private char gender;
	private String dateOfBithday;
	private String phoneNumber;
	private String email;
        
	private ArrayList<Flight> flights = new ArrayList<Flight>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getDateOfBithday() {
		return dateOfBithday;
	}

	public void setDateOfBithday(String dateOfBithday) {
		this.dateOfBithday = dateOfBithday;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}

	public boolean editBooking(Booking booking) {
		for (int index = 0; index < flights.size(); index++) {
			if (flights.get(index).getBooking().getTicket().getTicketId() == booking.getTicket().getTicketId()) {
				flights.get(index).setBooking(booking);
				return true;
			}
		}
		return false;
	}

	public boolean deleteFlight(int ticketId) {
		for (int index = 0; index < flights.size(); index++) {
			if (flights.get(index).getBooking().getTicket().getTicketId() == ticketId) {
				flights.remove(index);
				return true;
			}
		}
		return false;
	}
}