package io.javabrains.MovieCatalogService;

public class Rating {
	public Rating() {
	}
	private String MovieId;
	private int MovieRating;
	public String getMovieId() {
		return MovieId;
	}
	public void setMovieId(String movieId) {
		MovieId = movieId;
	}
	public int getMovieRating() {
		return MovieRating;
	}
	public void setMovieRating(int movieRating) {
		MovieRating = movieRating;
	}
	public Rating(String movieId, int movieRating) {
		MovieId = movieId;
		MovieRating = movieRating;
	}
	
	
	
	

}
