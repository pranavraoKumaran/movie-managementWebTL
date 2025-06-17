package com.moviemanagement.movie_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviemanagement.movie_management.model.Actor;
import com.moviemanagement.movie_management.repository.ActorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ActorService {
	
	@Autowired
	private ActorRepository actorrepository;
	
	public void addActor(Actor actor) {
		if(!actor.getActorName().isBlank())
		actorrepository.save(actor);
	}
	
	public List<Actor> getAllActor() {
		return actorrepository.findAll();
	}
	public Actor getActorById(Long id) {
		Optional<Actor> optional=actorrepository.findById(id);
		Actor actor=null;
		if(optional.isPresent()) {
			actor=optional.get();
		}
		else {
			throw new RuntimeException("Actor Not Found id ::"+id);
		}
		return actor;
	}
	public void deleteActor(Long id) {
		actorrepository.deleteById(id);
		System.out.println("Sucessfully Deleted");

		
	}
}
