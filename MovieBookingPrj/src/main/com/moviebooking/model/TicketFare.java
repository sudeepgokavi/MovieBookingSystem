package main.com.moviebooking.model;

import main.com.moviebooking.enums.SeatType;

public class TicketFare {

	private Movie movie;
	private SeatType seatType;
	private Double fare;

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

}
