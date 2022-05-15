package com.filmassist.filmassist.service;

import com.filmassist.filmassist.model.Films;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilmsService {
    public void save(Films film);
    public boolean isExist(String title);
    public List<Films> getAllFilms();
    public Films getFilmById(long id);
    public List<Films> getAllFilmsWithIds(List<Long> ids);
}
