package main.com.moviebooking.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.com.moviebooking.enums.ScreenType;
import main.com.moviebooking.enums.SeatType;
import main.com.moviebooking.model.Screen;
import main.com.moviebooking.model.Seat;

public class InitializeScreens {

	private List<Screen> screenList;

	int seatsInRow_Regular = 10;
	int seatsInRow_Rigliner = 6;
	int seatsInRow_Sofa = 4;

	Character[] charArr = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };

	public InitializeScreens() {
		screenList = new ArrayList<Screen>();
	}

	public List<Screen> getScreenList() {
		return screenList;
	}

	public void setScreenList(List<Screen> screenList) {
		this.screenList = screenList;
	}

	public void addScreens(ScreenType screenType, String screenName) {
		Screen screen = new Screen();
		screen.setScreenName(screenName);
		screen.setScreenType(screenType);

		screen.setSeatMap(prepareSeatMap(screen));
		screenList.add(screen);
	}

	private Map<SeatType, List<Seat>> prepareSeatMap(Screen screen) {

		List<Seat> seatList = new ArrayList<Seat>();

		if (screen.getScreenType().equals(ScreenType.GOLDCLASS)) {
			for (int i = 0; i < charArr.length; i++) {
				for (int j = 1; j < seatsInRow_Rigliner; j++) {
					Seat s = new Seat(charArr[i], j, SeatType.RIGLINER);
					seatList.add(s);
				}
			}
		} else if (screen.getScreenType().equals(ScreenType.VIP)) {
			for (int i = 0; i < charArr.length; i++) {
				for (int j = 1; j < seatsInRow_Sofa; j++) {
					Seat s = new Seat(charArr[i], j, SeatType.SOFA);
					seatList.add(s);
				}
			}
		} else if (screen.getScreenType().equals(ScreenType.NORMAL)) {
			for (int i = 0; i < charArr.length; i++) {
				for (int j = 1; j < seatsInRow_Regular; j++) {
					if (i <= 2) {
						Seat s = new Seat(charArr[i], j, SeatType.RIGLINER);
						seatList.add(s);
					} else {
						Seat s = new Seat(charArr[i], j, SeatType.REGULAR);
						seatList.add(s);
					}
				}
			}

		}

		Map<SeatType, List<Seat>> preparedSeatMap = new HashMap<SeatType, List<Seat>>();
		preparedSeatMap.put(SeatType.RIGLINER, seatList);

		return preparedSeatMap;
	}

}
