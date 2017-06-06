package main.com.moviebooking.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import main.com.moviebooking.enums.ScreenType;
import main.com.moviebooking.enums.SeatType;
import main.com.moviebooking.model.Movie;
import main.com.moviebooking.model.Screen;
import main.com.moviebooking.model.Seat;
import main.com.moviebooking.system.InitializeScreens;
import main.com.moviebooking.system.MovieToScreenMap;

public class MovieSystemDemo {

	private List<MovieToScreenMap> movieScreenMapList;
	InitializeScreens screenList;
	int seatsInRow_Regular = 9;
	int seatsInRow_Rigliner = 5;
	int seatsInRow_Sofa = 3;

	public MovieSystemDemo() {
		movieScreenMapList = new ArrayList<MovieToScreenMap>();
	}

	private void addScreens() {
		screenList = new InitializeScreens();
		screenList.addScreens(ScreenType.GOLDCLASS, "Audi - 1");
		screenList.addScreens(ScreenType.VIP, "Audi - 2");
		screenList.addScreens(ScreenType.NORMAL, "Audi - 3");
	}

	private void mapMovies2Screen() {
		List<String> showTimes = new ArrayList<String>();
		showTimes.add("10:00 AM");
		showTimes.add("01:00 PM");

		MovieToScreenMap map1 = new MovieToScreenMap();
		Movie m = new Movie();
		m.setName("Don");
		m.setType("Action");

		map1.setMovie(m);
		map1.setScreen(screenList.getScreenList().get(2));
		map1.setShowTimings(showTimes);

		movieScreenMapList.add(map1);
	}

	public static void main(String[] args) {
		MovieSystemDemo msd = new MovieSystemDemo();
		//msd.addMovies();
		msd.addScreens();

		msd.mapMovies2Screen();
		msd.print();

	}

	private void print() {
		for (MovieToScreenMap movieScreenMap : movieScreenMapList) {

			System.out.println("Movie -- > " + movieScreenMap.getMovie().getName());
			System.out.println("Type --> " + movieScreenMap.getMovie().getType());
			System.out.println("Showing At --> " + movieScreenMap.getScreen().getScreenName());
			System.out.println("Show Timings --> " + movieScreenMap.getShowTimings());
			System.out.println(" ------------------ SEAT MAP ------------------------");
			printSeatMap(movieScreenMap.getScreen());
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
