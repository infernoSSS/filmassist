package com.filmassist.filmassist.repository;

import com.filmassist.filmassist.model.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmsRepository extends JpaRepository<Films, Long> {
}
