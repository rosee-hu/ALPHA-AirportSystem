/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airportsystem;


public class FirstClassTicket extends Ticket {

	private static final double price = 100; 
	
	public FirstClassTicket(Integer ticketId) {
		super(ticketId);
		creatSeats();
	}
	
	private void creatSeats() {
		addSeat("F1");
		addSeat("F2");
		addSeat("F3");
		addSeat("F4");
		addSeat("F5");
		addSeat("F6");
		addSeat("F7");
		addSeat("F8");
		addSeat("F9");
		addSeat("F10");
		addSeat("F11");
		addSeat("F12");
		addSeat("F13");
		addSeat("F14");
		addSeat("F15");
	}

	@Override
	public double getPrice() {
		return price;
	}
}