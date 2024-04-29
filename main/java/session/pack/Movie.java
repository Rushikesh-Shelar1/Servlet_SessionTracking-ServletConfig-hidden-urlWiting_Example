package session.pack;

public class Movie {
	
	private String movieName;
	private String moivePrice;
	private String cinemaHall;
	private String movieTime;
	private String movieDate;
	/**
	 * @param movieName
	 * @param moivePrice
	 * @param cinemaHall
	 * @param movieTime
	 * @param movieDate
	 */
	public Movie(String movieName, String moivePrice, String cinemaHall, String movieTime, String movieDate) {
		super();
		this.movieName = movieName;
		this.moivePrice = moivePrice;
		this.cinemaHall = cinemaHall;
		this.movieTime = movieTime;
		this.movieDate = movieDate;
	}
	public String getMovieName() {
		return movieName;
	}
	public String getMoivePrice() {
		return moivePrice;
	}
	public String getCinemaHall() {
		return cinemaHall;
	}
	public String getMovieTime() {
		return movieTime;
	}
	public String getMovieDate() {
		return movieDate;
	}
	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", moivePrice=" + moivePrice + ", cinemaHall=" + cinemaHall
				+ ", movieTime=" + movieTime + ", movieDate=" + movieDate + "]";
	}

}
