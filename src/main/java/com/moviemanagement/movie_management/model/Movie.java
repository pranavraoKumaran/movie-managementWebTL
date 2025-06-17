package com.moviemanagement.movie_management.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long movieId;
	private String movieTitle;
	private String movieDescription;
	private int movieDuration;
	private int movieReleaseYear;
	
	
	@ManyToOne
	Genre genre;
	
	
	 @OneToMany(mappedBy="movie",cascade=CascadeType.ALL) 
	 List<Actor> actorList;
	
	public Movie() {
		actorList=new ArrayList<>();
		
	}


	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public int getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(int movieDuration) {
		this.movieDuration = movieDuration;
	}

	public int getMovieReleaseYear() {
		return movieReleaseYear;
	}

	public void setMovieReleaseYear(int movieReleaseYear) {
		this.movieReleaseYear = movieReleaseYear;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
	}

	/*
	 * @Override public String toString() { return "Movie [movieId=" + movieId +
	 * ", movieTitle=" + movieTitle + ", movieDescription=" + movieDescription +
	 * ", movieDuration=" + movieDuration + ", movieReleaseYear=" +
	 * movieReleaseYear+"]"; }
	 */
	
	
}
