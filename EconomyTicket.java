/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airportsystem;

public class EconomyTicket extends Ticket {
	
	private static final double price = 50;
	
	public EconomyTicket(Integer ticketId) {
		super(ticketId);
		creatSeats();
	}
	
	private void creatSeats() {
		addSeat("E1");
		addSeat("E2");
		addSeat("E3");
		addSeat("E4");
		addSeat("E5");
		addSeat("E6");
		addSeat("E7");
		addSeat("E8");
		addSeat("E9");
		addSeat("E10");
		addSeat("E11");
		addSeat("E12");
		addSeat("E13");
		addSeat("E14");
		addSeat("E15");
	}
	
	@Override
	public double getPrice() {
		return price;
	}
}