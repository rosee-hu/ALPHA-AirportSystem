package airportsystem;
public class Booking {

	private double luggageKg;
	private int capacityOfPlane;
	private int noOfLuggage;
	private String seatNo;
	private Ticket ticket;

	public double getLuggageKg() {
		return luggageKg;
	}

	public void setLuggageKg(double luggageKg) {
		this.luggageKg = luggageKg;
	}

	public int getCapacityOfPlane() {
		return capacityOfPlane;
	}

	public void setCapacityOfPlane(int capacityOfPlane) {
		this.capacityOfPlane = capacityOfPlane;
	}

	public int getNoOfLuggage() {
		return noOfLuggage;
	}

	public void setNoOfLuggage(int noOfLuggage) {
		this.noOfLuggage = noOfLuggage;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
}