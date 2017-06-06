package main.com.moviebooking.system;

import java.util.List;

import main.com.moviebooking.model.Movie;
import main.com.moviebooking.model.Screen;

public class MovieToScreenMap {

	private Movie movie;
	private Screen screen;
	private List<String> showTimings;

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public List<String> getShowTimings() {
		return showTimings;
	}

	public void setShowTimings(List<String> showTimings) {
		this.showTimings = showTimings;
	}

}
