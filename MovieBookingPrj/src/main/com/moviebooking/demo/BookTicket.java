package main.com.moviebooking.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.com.moviebooking.enums.ScreenType;
import main.com.moviebooking.enums.SeatType;
import main.com.moviebooking.model.Movie;
import main.com.moviebooking.model.Screen;
import main.com.moviebooking.model.Seat;
import main.com.moviebooking.model.TicketFare;
import main.com.moviebooking.system.InitializeScreens;

public class BookTicket {
	Map<SeatType, List<Seat>> preparedSeatMap;

	public TicketFare prapraeTicketFares(Movie movie) {
		TicketFare ticketFare = new TicketFare();
		ticketFare.setMovie(movie);
		ticketFare.setSeatType(SeatType.RIGLINER);
		ticketFare.setFare(new Double(200));

		return ticketFare;
	}

	public static void main(String[] args) {
		BookTicket bTicket = new BookTicket();
		bTicket.initMovieAndScreen();

		// bTicket.bookTickets(9);

		// bTicket.bookTickets(5);

		//bTicket.bookTickets('D', 4);
		//bTicket.bookTickets('D', 4);
		
		List<String> selectedSeatList = new ArrayList<String>();
		selectedSeatList.add("D - 1");
		//selectedSeatList.add("D - 6");
		//selectedSeatList.add("E - 1");
		
		bTicket.bookTickets(selectedSeatList);
	}

	private void bookTickets(List<String> selectedSeatList) {
		List<Seat> seatList = preparedSeatMap.get(SeatType.RIGLINER);
		Double fare = new Double(0);

		for (Seat s : seatList) {
			String tempSeatNo = s.getRow() + " - " + s.getSeatNo();
			for (String temp : selectedSeatList) {
				if (temp.equals(tempSeatNo)) {
					s.setSeatOccupied(true);
					fare += 200;
				}
			}
		}

		System.out.println(" ----------------------------------------------- ");
		System.out.println("Total Fare for " + selectedSeatList + " tickets is --> " + fare);
		System.out.println(" ----------------------------------------------- ");
		printSeatMap(seatList);

	}

	private void bookTickets(Character row, Integer noOfSeats) {
		int ticketsRequired = noOfSeats;
		List<Seat> seatList = preparedSeatMap.get(SeatType.RIGLINER);
		Double fare = new Double(0);

		for (Seat s : seatList) {

			if (!s.isSeatOccupied() && s.getRow() == row) {
				if (noOfSeats == 0)
					break;
				else {
					s.setSeatOccupied(true);
					fare += 200;
				}
				--noOfSeats;
			}
		}

		System.out.println(" ----------------------------------------------- ");
		System.out.println("Total Fare for " + ticketsRequired + " tickets is --> " + fare);
		System.out.println(" ----------------------------------------------- ");
		printSeatMap(seatList);

	}

	private void bookTickets(int quantity) {
		int ticketsRequired = quantity;
		List<Seat> seatList = preparedSeatMap.get(SeatType.RIGLINER);
		Double fare = new Double(0);
		for (Seat s : seatList) {

			if (!s.isSeatOccupied()) {
				if (quantity == 0)
					break;
				else {
					s.setSeatOccupied(true);
					fare += 200;
				}

				--quantity;
			}
		}

		System.out.println(" ----------------------------------------------- ");
		System.out.println("Total Fare for " + ticketsRequired + " tickets is --> " + fare);
		System.out.println(" ----------------------------------------------- ");
		printSeatMap(seatList);
	}

	private void initMovieAndScreen() {
		InitializeScreens screen = new InitializeScreens();
		screen.addScreens(ScreenType.GOLDCLASS, "Audi - 1");
		preparedSeatMap = screen.getScreenList().get(0).getSeatMap();

		List<Seat> seatList = preparedSeatMap.get(SeatType.RIGLINER);
		printSeatMap(seatList);
	}

	private void printSeatMap(List<Seat> seatList) {
		int counter = 0;
		for (Seat s : seatList) {
			System.out.print(s.getRow() + "-" + s.getSeatNo());
			if (s.isSeatOccupied())
				System.out.print(" --> O ");
			else
				System.out.print(" --> E ");

			if (counter < 8)
				System.out.print(" , ");
			counter++;
			if (counter == 9) {
				System.out.println("");
				counter = 0;
			}
		}
	}

}
