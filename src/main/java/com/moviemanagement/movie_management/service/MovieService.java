package com.moviemanagement.movie_management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviemanagement.movie_management.model.Genre;
import com.moviemanagement.movie_management.model.Movie;
import com.moviemanagement.movie_management.repository.ActorRepository;
import com.moviemanagement.movie_management.repository.GenreRepository;
import com.moviemanagement.movie_management.repository.MovieRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MovieService {
	
	@Autowired
	private MovieRepository movierepository;
	
	@Autowired
	private GenreRepository genrerepository;
	
	@Autowired
	private ActorRepository actorrepository;
	
	public void addMovie(Movie movie) {
		movierepository.save(movie);
	}
	
	public List<Movie> getAllMovie() {
		return movierepository.findAll();
	}
	public Movie getMovieById(Long mId) { 
		return movierepository.findById(mId).get();
	}
	
	public List<Movie> getMovieByGenre(Long gId) {
		Genre g=genrerepository.findById(gId).get();
		return g.getMovieList();		
	}
	public void deleteMovie(Long id) {
//		Movie m=movierepository.findById(id).get();
//		movierepository.findById(id).get().getGenre().getMovieList().remove(m);
		movierepository.deleteById(id);
		System.out.println("Sucessfully Deleted");
	}
}
