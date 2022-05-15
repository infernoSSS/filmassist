package com.filmassist.filmassist.service;

import com.filmassist.filmassist.model.Films;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    public void evaluation(long userClassId, long filmId, boolean fine);
    public List<Films> getFilms(long userClassId);
    public List<Films> getFilms(long userClassId, int page);
}
