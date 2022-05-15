package com.filmassist.filmassist.service;

import com.filmassist.filmassist.model.Films;
import com.filmassist.filmassist.repository.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmsServiceImpl implements FilmsService{

    @Autowired
    private FilmsRepository repository;

    @Override
    public void save(Films film) {
        repository.save(film);
    }

    @Override
    public boolean isExist(String title) {
        return repository.findAll().stream().anyMatch(x -> x.getTitle().equals(title));
    }

    @Override
    public List<Films> getAllFilms() {
        return repository.findAll();
    }

    @Override
    public Films getFilmById(long id) {
        return repository.findAll().stream().filter(x -> x.getId()==id).findFirst().orElseThrow();
    }

    @Override
    public List<Films> getAllFilmsWithIds(List<Long> ids) {
        return repository.findAll().stream().filter(x -> ids.stream().anyMatch(z -> z.equals(x.getId())))
                .collect(Collectors.toList());
    }


}
