package com.moviemanagement.movie_management.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Genre {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long genreId;
	private String genreName;
	 
	
	@OneToMany(mappedBy="genre",cascade=CascadeType.ALL)
	private List<Movie> movieList;

	public Genre() {
		movieList=new ArrayList<>();
	}

	public Genre(String genreName) {
		super();
		this.genreName = genreName;
		movieList=new ArrayList<>();

	}


	public Long getGenreId() {
		return genreId;
	}


	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}


	public String getGenreName() {
		return genreName;
	}


	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}


	public List<Movie> getMovieList() {
		return movieList;
	}


	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	/*
	 * @Override public String toString() { return "Genre [genreId=" + genreId +
	 * ", genreName=" + genreName + "]"; }
	 */	
	
	
}
