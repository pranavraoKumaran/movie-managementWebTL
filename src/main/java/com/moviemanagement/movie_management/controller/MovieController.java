package com.moviemanagement.movie_management.controller;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moviemanagement.movie_management.model.Actor;
import com.moviemanagement.movie_management.model.Genre;
import com.moviemanagement.movie_management.model.Movie;
import com.moviemanagement.movie_management.repository.MovieRepository;
import com.moviemanagement.movie_management.service.ActorService;
import com.moviemanagement.movie_management.service.GenreService;
import com.moviemanagement.movie_management.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ActorService actorService;
	
	@Autowired
	private GenreService genreService;
	
	
	
	@GetMapping("/home")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/movie")
	public String movie(Model model) {
		List<Genre> genre=genreService.getAllGenre();
		model.addAttribute("genres",genre);
		model.addAttribute("movie",new Movie());
		
		return "addMovie";
	}
	
	@PostMapping("/addmovie")
	public String addMovie(@ModelAttribute("movie") Movie movie) {
		movieService.addMovie(movie);
		return "redirect:/home";
	}
	
	@GetMapping("/actor")
	public String showActor(Model model) {
		List<Movie> movie=movieService.getAllMovie();
		model.addAttribute("movies",movie);
		model.addAttribute("actor",new Actor());
		return "addActor";
	}
	
	@PostMapping("/addactor")
	public String addActor(@ModelAttribute("actor") Actor actor) {
		actorService.addActor(actor);
		return "redirect:/home";
	}
	@GetMapping("/genre")
	public String showGenre(Model model) {
		model.addAttribute("genre",new Genre());
		
		return "addGenre";
	}
	@PostMapping("/addgenre")
	public String addGenre(@ModelAttribute("genre") Genre genre ) {
		genreService.addGenre(genre);
		return "redirect:/home";
	}
	
	@GetMapping("/showall")
	public String showAll(Model model) {
		List<Movie> movie=movieService.getAllMovie();
		List<Genre> genre=genreService.getAllGenre();
		List<Actor> actor=actorService.getAllActor();
		model.addAttribute("movies",movie);
		model.addAttribute("genres",genre);
		model.addAttribute("actors",actor);

		
		return "showAll";
	}
	
	@GetMapping("/showFormForUpdateMovie/{id}")
	public String showFormForUpdateMovie(@PathVariable(value="id") Long id,Model model) {
		Movie movie=movieService.getMovieById(id);
		model.addAttribute("movie", movie);
		
		return "update_movie";
	}
	
	@GetMapping("/showFormForUpdateGenre/{id}")
	public String showFormForUpdateGenre(@PathVariable(value="id") Long id,Model model) {
		Genre genre=genreService.getGenreById(id);
		model.addAttribute("genre", genre);
		
		return "update_genre";
	}
	
	@GetMapping("/showFormForUpdateActor/{id}")
	public String showFormForUpdateActor(@PathVariable(value="id") Long id,Model model) {
		Actor actor=actorService.getActorById(id);
		model.addAttribute("actor", actor);
		
		return "update_actor";
	}
	
	@GetMapping("/deleteMovie/{id}")
	public String deleteMovie(@PathVariable(value="id") Long id) {
		movieService.deleteMovie(id);
		return "redirect:/home";
	}
	
	@GetMapping("/deleteGenre/{id}")
	public String deleteGenre(@PathVariable(value="id") Long id,Model model) {
		genreService.deleteGenre(id);
		return "redirect:/home";
	}
	
	@GetMapping("/deleteActor/{id}")
	public String deleteActor(@PathVariable(value="id") Long id,Model model) {
		actorService.deleteActor(id);
		return "redirect:/home";
	}
	
	@GetMapping("/viewMovieById")
	public String viewMovieById(Model model) {
		model.addAttribute("movie",new Movie());
		return "viewMovieById";
	}
	
	@PostMapping("/viewMovie")
	public String viewMovie(@ModelAttribute("movie") Movie movie, Model model) {
		Long id=movie.getMovieId();
		Movie movies=movieService.getMovieById(id);
		
		Genre gen=genreService.getGenreById(movies.getGenre().getGenreId());
		List<Actor> actors=movies.getActorList();
		model.addAttribute("actors", actors);
		model.addAttribute("genre",gen);
		model.addAttribute("movieview", movies);
		
		return "viewMovieById";
	}
	
	
}