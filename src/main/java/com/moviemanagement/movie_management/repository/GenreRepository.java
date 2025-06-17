package com.moviemanagement.movie_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviemanagement.movie_management.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

}
