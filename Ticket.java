package airportsystem;
import java.util.ArrayList;
//abstract class does NOT have an object, so to use it correctly we will inheret a sub-class form it
abstract public class Ticket {

	private final double TAX = 20;
	private int ticketId;
	private String gateNo;
	private String typeOfTicket;
	private ArrayList<String> availableSeats = new ArrayList<>();
	
	private static int nextTicketId = 1; 
	
	public Ticket(Integer ticketId) {
		if (ticketId == null) { //reserve a new ticke
			this.ticketId = nextTicketId;//Give a number to the ticket(initially=0)
			nextTicketId++;//increament
		} else {// update the booking
			this.ticketId = ticketId;
		}	
	}

	public abstract double getPrice();//abstract methode does NOT have a body inside theabstract class, it's in the sub-class

	public int getTicketId() {
		return ticketId;
	}

	public String getGateNo() {
		return gateNo;
	}

	public void setGateNo(String gateNo) {
		this.gateNo = gateNo;
	}

	public String getTypeOfTicket() {
		return typeOfTicket;
	}

	public void setTypeOfTicket(String typeOfTicket) {
		this.typeOfTicket = typeOfTicket;
	}

	public double getTAX() {
		return TAX;
	}
	
	public void addSeat(String seatNo) {
		availableSeats.add(seatNo);
	}
	
	public void showAvailableSeats() {// To view the available seats that are not reserved yet
		System.out.println();
		for (int index = 0; index < availableSeats.size(); index++) {
			System.out.print("[" + availableSeats.get(index) + "]\t");
			if ((index + 1) % 3 == 0) {
                            //To print 3 seats numbers in one line then go to next line
				System.out.println();
			}
		}
		System.out.println();
	}
	
	public ArrayList<String> getAvailableSeats() {//To return the list of seats
		return availableSeats;
	}

	@Override
	public String toString() {
		return "T\ticket [Tax=" + TAX + ", ticket id=" + ticketId + ", gate no=" + gateNo
				+ ", type of ticket=" + typeOfTicket + "]";
	}
}