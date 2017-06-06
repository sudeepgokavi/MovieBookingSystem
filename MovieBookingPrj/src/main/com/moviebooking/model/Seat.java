package main.com.moviebooking.model;

import main.com.moviebooking.enums.SeatType;

public class Seat {

	private Character row;
	private Integer seatNo;
	private SeatType seatType;
	private boolean seatOccupied = false;

	public Seat(Character row, Integer seatNo, SeatType seatType) {
		super();
		this.row = row;
		this.seatNo = seatNo;
		this.seatType = seatType;
	}

	public boolean isSeatOccupied() {
		return seatOccupied;
	}

	public void setSeatOccupied(boolean seatOccupied) {
		this.seatOccupied = seatOccupied;
	}

	public Character getRow() {
		return row;
	}

	public void setRow(Character row) {
		this.row = row;
	}

	public Integer getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

}
