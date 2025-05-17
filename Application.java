package airportsystem;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

public class Application {

	private static AirportSystem airportSystem = new AirportSystem();
	private static Scanner sc = new Scanner(System.in);
        static boolean notDigit=true; 
	public static void main(String[] args) {
            //Display First Menu for either manager, flight crew, or passenger 
        boolean isNumber=false; //checks id its integer 
        int choice=0;//choise selected by the user from the menu
        System.out.println("\t\t ---------------- ");
        System.out.println("\t\t |Welcome To Alpha| \n\t\t | AIRPORT SYSTEM | ");
        System.out.println("\t\t ---------------- ");
       do
       {
       
        createData(); //automatic data is called 
        System.out.println("\t  ------------------------------------- ");
        System.out.println("\n\t  * Press 1 to show manger options      *");
        System.out.println("\n\t  * Press 2 to show flight crew options *");
        System.out.println("\n\t  * Press 3 to show passenger options   *");
        System.out.println("\n\t  * Press 0 to exit                     *");
        System.out.println("\n\t  ------------------------------------- "); 
        System.out.print("\n\t Choice: ");
        do {
        if(sc.hasNextInt()){
            choice =sc.nextInt();
            isNumber=true;
        }
        else {
          System.out.print("\n\tInvalid choice. Please enter an integer.\n");
          
          isNumber=false; 
          System.out.print("\n\t Choice: ");
          sc.next();
        }
        } while(!(isNumber));
           switch (choice)
           {
               case 0:
                System.out.println("\t--------------------------------\n\t Thank you for using the system!\n\t--------------------------------");  
                   break;

               case 1:
                   selectManger();
                   break;
               case 2:
                   selectFlightCrew();
                   break;
               case 3:
                     showPassengerOptions();
                   break;
               default: 
                    System.out.println("\n\tInvalid choice. Please try again.\n");
                    break;                     
           
        }
           }
       while (choice!=0);}
     
         
	private static void createData() {

		airportSystem.addManger(new Manger("manager_1", "123"));
		airportSystem.addManger(new Manger("manager_2", "456"));
		airportSystem.addManger(new Manger("manager_3", "789"));

		airportSystem.addHotel(new Hotel("hotel_1"));
		airportSystem.addHotel(new Hotel("hotel_2"));
		airportSystem.addHotel(new Hotel("hotel_3"));

		airportSystem.addFlightCrew(new FlightCrew("crew_1"));
		airportSystem.addFlightCrew(new FlightCrew("crew_2"));
		airportSystem.addFlightCrew(new FlightCrew("crew_3"));

		airportSystem.addFlight(new Flight("Saudia", "Jeddah", "4:00 pm", "5:30 pm", 2,
				"3:30 pm"));
		airportSystem.addFlight(new Flight("Fly Adeal", "Dammam", "10:30 pm", "11:30 pm", 1,
				"10:00 pm"));
		airportSystem.addFlight(new Flight("Saudia", "Abha", "9:20 am", "10:50 am", 2,
				"8:50 am"));
	}

	private static void selectManger() {
         //gets called if choice is 1 from the menu        
		System.out.print("\n\tAdd manager Id: ");
		String mangerId = sc.next();
		Manger selectedManger = null;
		for (Manger manger : airportSystem.getMangers()) {
			if (manger.getWorkId().equals(mangerId)) { //get manger names from createData
			//return the ID of the manager to check it with entered ID 	
                            selectedManger = manger;
				break;
			}
		}
		if (selectedManger != null) {
			checkPassword(selectedManger);
		} else {
                        System.out.println("\t  *-------------------------------------* ");
			System.out.println("\t      Invalid Id. Please try again.");
                        
			selectManger();
		}
	}
        
	private static void checkPassword(Manger manger) {
	//the method is to check the password
            System.out.print("\tAdd password : ");
		String password = sc.next();
		if (manger.getPassword().equals(password)) {
                        System.out.println("\t  *-------------------------------------* ");
                        System.out.println("\t  *  Dear Manager Welcome to The System  * ");
                        java.util.Date date = new java.util.Date();
                        System.out.println("\t  *  The Date Today Is:                 *  "); 
                        System.out.println("\t  * "+ date +         "*");      
                        System.out.println("\t  *-------------------------------------* ");
			showMangerOptions();//manger acceiable menu only
		} else {
                        System.out.println("\t  *-------------------------------------* ");
			System.out.println("\t    Wrong password. Please try again.");
			checkPassword(manger);
		}
	}

	private static void showMangerOptions() {
           int Choice = 0;
           
           boolean isNumber=false; 
            do {
			Manger.printOptions();
			System.out.print("\n\tChoice: ");
                     
                     
                      do{
                        if(sc.hasNextInt()){
                        Choice =sc.nextInt();
                        isNumber=true;
        }
        else {
          System.out.print("\n\tInvalid choice. Please enter an integer.\n");
          
          isNumber=false; 
          System.out.print("\n\t Choice: ");
          sc.next();
        }}
         while(!(isNumber));
                     
			switch (Choice) {
			case 1: {
				addNewFlight();
                                System.out.println("\t  *-------------------------------------* ");
				System.out.println("\t         Flight added successfully");
                                System.out.println("\t  *-------------------------------------* ");

				break;
			}
			case 2: {
				editFlight();
                                break;
			}
			case 3: {
				deleteFlight();
				break;
			}
			case 4: {
				airportSystem.viewAllFlights();
				break;
			}
                        case 0: {
				
				break;
			}
			default:
                                System.out.println("\t  *-------------------------------------* ");
				System.out.println("\t    Invalid choice. Please try again.");
                                System.out.println("\t  *-------------------------------------* ");
				break;
			}
		}
	while(Choice!=0);
            }
        

	private static void addNewFlight() {
            		airportSystem.addFlight(createOrUpdateFlight(null));
        }
        
        private static void editFlight() {
		System.out.print("\tAdd flight No: ");
		int flightNo = sc.nextInt();
                if(airportSystem.isFlight(flightNo)>0){
                    airportSystem.editFlight(createOrUpdateFlight(flightNo));
                }
                else
                    System.out.println("\tFlight Not Found..");
	}
    
	private static Flight createOrUpdateFlight(Integer flightNo) {
		String nameOfAirlines = getFieldValue(" Name of airlines");
		String destination = getFieldValue("Destination");
		String timeOfDeparture = getFieldValue("Time of departure");
		String timeOfArrival = getFieldValue("Time of arrival");
                //////Error handling
                int stops = Integer.valueOf(getFieldValue("Stops"));
		String timeOfBoarding = getFieldValue("Time of boarding");
		if (flightNo == null)
                    //call constructer in flight class to creat New flight
			return new Flight(nameOfAirlines, destination, timeOfDeparture, timeOfArrival, stops, timeOfBoarding);
		  //go back to switch case 1 after finishing executing 
                else
			return new Flight(flightNo, nameOfAirlines, destination, timeOfDeparture, timeOfArrival, stops,
					timeOfBoarding);
                //call a constructer in flight class to update an existing flight 
	}

	private static void deleteFlight() {
            // method for case 3 in switch statment 
		System.out.print("\tAdd flight No: ");//prompting for flight number to be deleted
		int flightNo = sc.nextInt();
		airportSystem.deleteFlight(flightNo);
                
                
	}
//login
	private static void selectFlightCrew() {
		System.out.print("\n\tAdd crew Id: ");//prompting user for crew ID
		String crewId = sc.next();
		FlightCrew selectedFlightCrew = null;
		for (FlightCrew flightCrew : airportSystem.getFlightCrews()) {//search for all flightcrew Ids 
			if (flightCrew.getCrewId().equals(crewId)) { //if it matches an ID from createData
				selectedFlightCrew = flightCrew;
				break;
			}
		}
		if (selectedFlightCrew != null) {//if it exists 
			showFlightCrewOptions(selectedFlightCrew);//show flight crew menu
		} else {
                        System.out.println("\t  *-------------------------------------* ");
			System.out.println("\t     Invalid Id. Please try again.");
			System.out.println("\t  *-------------------------------------* ");
                        selectFlightCrew();// call the function again to input a valid flight crew ID 
		}
	}

	private static void showFlightCrewOptions(FlightCrew flightCrew) {
            int Choice = 0;
           boolean isNumber=false; 
            do {
			FlightCrew.printOptions();
			System.out.print("\n\tChoice: ");
                     
                     
                      do{
                        if(sc.hasNextInt()){
                        Choice =sc.nextInt();
                        isNumber=true;
        }
        else {
          System.out.print("\n\tInvalid choice. Please enter a valid option .\n");
          
          isNumber=false; 
          System.out.print("\n\t Choice: ");
          sc.next();
        }}
         while(!(isNumber));
                      {
			switch (Choice) {
			case 1: {
				airportSystem.viewAllFlights();
				break;
			}
			case 2: {
				selectHotel(flightCrew);
				System.out.println("\t  *-------------------------------------* ");
                                System.out.println("\t        Hotel selected successfully");
                                System.out.println("\t  *-------------------------------------* ");
				break;
			}
			default:
                                System.out.println("\t  *-------------------------------------* ");
				System.out.println("\n   Invalid choice. Please try again.");
				System.out.println("\t  *-------------------------------------* ");
                                break;
			}
		}
                      }
	while(Choice!=0);
            }
        
	
	private static void selectHotel(FlightCrew flightCrew) {
		System.out.print("\n\n");
		ArrayList<Hotel> hotels = airportSystem.getHotels();//called from airportsystem class
		for (int index = 0; index < hotels.size(); index++) {
			System.out.println("\tPress " + index + " to select hotel " + hotels.get(index).getName());
		   //press (number of index) to select hotel hotel(number of index) (name of hotel)
                }
                		while (true) {
			System.out.print("\n\tChoice: ");
			int selectedChoice = sc.nextInt();
			if (selectedChoice >= 0 && selectedChoice < hotels.size()) {
				Hotel selectedHotel = hotels.get(selectedChoice);
				System.out.print("\n\tAdd date: ");
				flightCrew.setSelectedHotel(new Hotel(selectedHotel.getName(), sc.next()));
			  //return name of selected hotel 

                                break;
			} else {
                                System.out.println("\t  *-------------------------------------* ");
				System.out.println("\t     Invalid choice. Please try again.");
                                System.out.println("\t  *-------------------------------------* ");
			}
		}
	}

	private static void showPassengerOptions() {
	Passenger passenger = null;
		int choice = 0;
           boolean isNumber=false; 
            do {
			Passenger.printOptions();	
			System.out.print("\n\tChoice: ");
                     
                     
                      do{
                        if(sc.hasNextInt()){
                        choice =sc.nextInt();
                        isNumber=true;
        }
        else {
          System.out.print("\n\tInvalid choice. Please enter a valid option .\n");
          
          isNumber=false; 
          System.out.print("\n\t Choice: ");
          sc.next();
        }}
         while(!(isNumber));
                      {
			switch (choice) {
			case 1: {
				if (passenger == null)
					passenger = addNewPassengers();
				bookNewFlight(passenger);
				break;
			}
			case 2: {
				if (passenger == null){
				System.out.println("\t  *     no bookings added yet           * ");}
                                else{
                                editPassengerFlight(passenger);
                                }
				break;
			}
			case 3: {
				if (passenger == null){
				System.out.println("\t  *       no bookings added yet         * ");}	
				else
                                deletePassengerFlight(passenger);{

                        }
				break;
			}
			case 4: {
				airportSystem.viewAllFlights();
				break;
			}
			default:
                                System.out.println("\t  *-------------------------------------* ");
				System.out.println("\t    Invalid choice. Please try again.\t");
                                System.out.println("\t  *-------------------------------------* ");
				break;
			}
		}
	}                      
	while(choice!=0);
            }

	private static Passenger addNewPassengers() {
		Passenger passenger = new Passenger();
                System.out.print("\n\t ********************************************************\n");
		System.out.print("\t   Dear Passenger Please Add your Information: \n");
                System.out.print("\t ********************************************************\n");
		passenger.setName(getFieldValue("Name"));
		while (true) {
		//error handeling for gender	
                    String gender = getFieldValue("Gender (f/m)");
			if (gender.length() == 1 && (gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("m"))) {
				passenger.setGender(gender.toLowerCase().charAt(0));
				//convert to lower case
                                break;
			} else {
                            
				System.out.println("\tInvalid input pleas try (f/m)");
			}
		}
		System.out.println("\tAdd date of birth:");
		int day = 0;
		while (true) {
			System.out.println("\tAdd day (1-31):");
                        System.out.print("\t");
                        day = sc.nextInt();
                        
			if (day >= 1 && day <= 31) {//valid scope 
				break;
			} else {
				System.out.println("\tInvalid input");
			}
		}
		int month = 0;
		while (true) {
			System.out.println("\tAdd month (1-12):");   
                        System.out.print("\t");
			month = sc.nextInt();
			if (month >= 1 && month <= 12) {//valid scope 
				break;
			} else {
				System.out.println("\tInvalid input");
			}
		}
		int year = 0;
             		while (true) {
			System.out.println("\tAdd year (1900-2022):");
                        System.out.print("\t");
			year = sc.nextInt();
			if (year >= 1900 && year <= 2022) {//valid scope 
				break;
			} else {
				System.out.println("\tInvalid input");
			}
		}
                         //setting passenger information 
                passenger.setDateOfBithday(day + "/" + month + "/" + year);
		passenger.setPhoneNumber(getFieldValue("phone number"));
		passenger.setEmail(getFieldValue("email"));
		passenger.setNationality(getFieldValue("nationality"));
		passenger.setPassengerId(getFieldValue("passenger id"));
		passenger.setPassportNo(getFieldValue("passport no"));
		return passenger;
                }

private static void bookNewFlight(Passenger passenger) {
		while (true) {
                    
			System.out.print("\tAdd flight No: ");
			int flightNo = sc.nextInt(); 
			Flight flight = airportSystem.viewFight(flightNo);
			passenger.getFlights().add(flight);
			if (flight != null) {
				Booking booking = createOrUpdateBooking(null);
				flight.setBooking(booking);
                                System.out.println("\t  ------------------------------------- ");
				System.out.println("\t      Ticket added successfully");
       				System.out.print("\t        Your ticket id is: " + flight.getBooking().getTicket().getTicketId());
				System.out.print("\t\n           Total price in $ is: " + flight.getBooking().getTicket().getPrice() + "$");
                                break;
			}
		}
}
			
        
	private static Booking createOrUpdateBooking(Integer ticketId) {
		Booking booking = new Booking();
		booking.setNoOfLuggage(Integer.valueOf(getFieldValue("Number of of luggage")));
		while (true) {
			String ticketType = getFieldValue("Ticket (f: First Class / e: Economy)");
			//length=1 means it's a letter 
                        if (ticketType.length() == 1 && ticketType.equalsIgnoreCase("f")) {
				booking.setTicket(new FirstClassTicket(ticketId));
				break;
			} else if (ticketType.length() == 1 && ticketType.equalsIgnoreCase("e")) {
				booking.setTicket(new EconomyTicket(ticketId));
				break;
			} else {
				System.out.println("\tInvalid input");
			}
		}
		booking.getTicket().showAvailableSeats();
		boolean seatFound = false;
		while (!seatFound) {//seats are available 
			String seatNo = getFieldValue("Seat number");
			//For Each loop take each seat num then compare it with seat entered by passenger
                        for (String seat : booking.getTicket().getAvailableSeats()) { //book new seat 
				if (seat.equalsIgnoreCase(seatNo)) {
					booking.setSeatNo(seat);
					seatFound = true;
					break;
				}
			}
			if (!seatFound) //not available 
				System.out.println("\tInvalid input");
		}
		return booking;
	}

	private static void editPassengerFlight(Passenger passenger) {
		while (true) {
			System.out.print("\n\tAdd Ticket id: ");//prompting for ticket ID
			int ticketId = sc.nextInt();
			if (passenger.editBooking(createOrUpdateBooking(ticketId))) {               
                                System.out.println("\t  *-------------------------------------* ");
				System.out.println("\t        Ticket Edited Successfully");
                                System.out.println("\t  *-------------------------------------* ");
				break;
			} else {
				System.out.println("\n\tInvalid Ticket id. Please try again.\n");
			}
		}
	}

	private static void deletePassengerFlight(Passenger passenger) {//prompting for ticket ID 
		while (true) {
			System.out.print("\n\tAdd Ticket id: ");
			int ticketId = sc.nextInt();
			if (passenger.deleteFlight(ticketId)) {
                                System.out.println("\t  *-------------------------------------* ");
				System.out.println("\t        Ticket deleted successfully");
                                System.out.println("\t  *-------------------------------------* ");
				break;
			} else {
				System.out.println("\tInvalid Ticket id. Please try again.\n");
			}
		}
	}
        //to orgnize the output 
	private static String getFieldValue(String fieldName) {
		System.out.print("\tAdd " + fieldName + ": ");
                if (fieldName == "Stops" || fieldName == "Number of of luggage")
                { String num;   // num represent the number of stops or the number of luggage
                  
               do{
                  num=sc.next();
                  int y =num.charAt(0); //return first digit of num to
                if (y >= '0'&& y<='9') // check if num is digit or not
                {   notDigit=false;
                    return num;
                }
               else 
              {System.out.println("\tinvalid value");
               System.out.print("\tAdd " + fieldName + ": ");
                }
                }while( notDigit );
                  
                    }
                
                return sc.next();
	}

}