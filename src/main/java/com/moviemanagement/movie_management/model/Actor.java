 package com.moviemanagement.movie_management.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Actor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long actorId;
	private String actorName;
	private String actorRole;
	
	@ManyToOne
//	@JoinColumn(name="movie_id")
	private Movie movie;
	
	public Actor() {
	}


	public Long getActorId() {
		return actorId;
	}

	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActorRole() {
		return actorRole;
	}

	public void setActorRole(String actorRole) {
		this.actorRole = actorRole;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/*
	 * @Override public String toString() { return "Actor [actorId=" + actorId +
	 * ", actorName=" + actorName + ", actorRole=" + actorRole + "]"; }
	 */	
}
