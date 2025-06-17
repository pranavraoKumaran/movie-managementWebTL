package com.moviemanagement.movie_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviemanagement.movie_management.model.Genre;
import com.moviemanagement.movie_management.repository.GenreRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GenreService {
	
	@Autowired
	private GenreRepository genrerepository;
	
	public void addGenre(Genre genre) {
		genrerepository.save(genre);
	}
	public Genre getGenreById(Long id) {
		Optional<Genre> optional=genrerepository.findById(id);
		Genre genre=null;
		if(optional.isPresent()) {
			genre=optional.get();
		}
		else {
			throw new RuntimeException("Genre not found for id:: "+id);
		}
		return genre;
	}
	public List<Genre> getAllGenre() {
		return genrerepository.findAll();
	}
	
	public void deleteGenre(Long id) {
		
		genrerepository.deleteById(id);
		
		System.out.println("Sucessfully Deleted");

	}
	
	
}
