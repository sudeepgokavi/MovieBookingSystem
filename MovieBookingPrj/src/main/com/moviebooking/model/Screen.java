package main.com.moviebooking.model;

import java.util.List;
import java.util.Map;

import main.com.moviebooking.enums.ScreenType;
import main.com.moviebooking.enums.SeatType;

public class Screen {

	private String screenName;
	private Map<SeatType, List<Seat>> seatMap;
	private ScreenType screenType;

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Map<SeatType, List<Seat>> getSeatMap() {
		return seatMap;
	}

	public void setSeatMap(Map<SeatType, List<Seat>> seatMap) {
		this.seatMap = seatMap;
	}

	public ScreenType getScreenType() {
		return screenType;
	}

	public void setScreenType(ScreenType screenType) {
		this.screenType = screenType;
	}

}
