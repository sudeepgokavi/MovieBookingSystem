package main.com.moviebooking.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import main.com.moviebooking.enums.ScreenType;
import main.com.moviebooking.enums.SeatType;
import main.com.moviebooking.model.Screen;
import main.com.moviebooking.model.Seat;
import main.com.moviebooking.system.InitializeScreens;

public class ScreenInitializerDemo {
	
	InitializeScreens initScreens;
	int seatsInRow_Regular = 9;
	int seatsInRow_Rigliner = 5;
	int seatsInRow_Sofa = 3;

	public void initScreens() {
		initScreens = new InitializeScreens();
	}

	public void addScreens(ScreenType screenType, String screenName) {
		initScreens.addScreens(screenType, screenName);
	}

	public static void main(String[] args) {
		ScreenInitializerDemo sDemo = new ScreenInitializerDemo();
		sDemo.initScreens();
		sDemo.addScreens(ScreenType.GOLDCLASS, "Audi - 1");
		sDemo.addScreens(ScreenType.VIP, "Audi - 2");
		sDemo.addScreens(ScreenType.NORMAL, "Audi - 3");
		sDemo.print();
	}

	private void print() {
		List<Screen> screenList = initScreens.getScreenList();
		for (Screen s : screenList) {
			System.out.println(" --------- " + s.getScreenName());
			printSeatMap(s);
		}
	}

	private void printSeatMap(Screen screen) {
		Map<SeatType, List<Seat>> preparedSeatMap = screen.getSeatMap();
		int breakPoint = 0;
		Iterator<SeatType> seatType = preparedSeatMap.keySet().iterator();

		switch (screen.getScreenType()) {
		case GOLDCLASS:
			breakPoint = seatsInRow_Rigliner;
			break;
		case NORMAL:
			breakPoint = seatsInRow_Regular;
			break;
		case VIP:
			breakPoint = seatsInRow_Sofa;
		default:
			break;
		}

		while (seatType.hasNext()) {
			List<Seat> seatList = preparedSeatMap.get(seatType.next());
			int counter = 0;
			for (Seat s : seatList) {
				System.out.print(s.getRow() + "-" + s.getSeatNo());

				switch (s.getSeatType()) {
				case REGULAR:
					System.out.print(" --> R ");
					break;
				case RIGLINER:
					System.out.print(" --> RL ");
					break;
				case SOFA:
					System.out.print(" --> S ");
					break;
				default:
					break;
				}

				if (counter < (breakPoint - 1))
					System.out.print(" , ");
				counter++;
				if (counter == breakPoint) {
					System.out.println("");
					counter = 0;
				}
			}
		}
	}

}
