package com.filmassist.filmassist.service;

import com.filmassist.filmassist.config.Config;
import com.filmassist.filmassist.model.Films;
import com.filmassist.filmassist.model.Rating;
import com.filmassist.filmassist.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private Config config;

    @Autowired
    private RatingRepository repository;

    @Autowired
    private FilmsService filmsService;

    @Override
    public void evaluation(long userClassId, long filmId, boolean fine) {
        var change = fine ? 1 : -1;
        Rating rating = repository.findAll().stream()
                .filter(x -> x.getUserClassId() == userClassId && x.getFilmId() == filmId)
                .findFirst().orElse(new Rating(userClassId, filmId, 1, 0));
        rating.setRating(rating.getRating() + change);
        rating.setNumberOfRatings(rating.getNumberOfRatings()+1);
        repository.save(rating);
    }

    public List<Films> getTopRatingByUserClassId(long userClassId, int page) {
        List<Long> top = repository.findAll().stream().filter(x -> (x.getUserClassId()==userClassId))
                .sorted(Comparator.comparingDouble(Rating::getRating).reversed())
                .skip((long) config.getTopRLimit() *page)
                .limit(config.getTopRLimit()).map(Rating::getFilmId).collect(Collectors.toList());
        return filmsService.getAllFilmsWithIds(top);
    }

    public List<Films> getLowEvaluatedFilmsByUserClassId(long userClassId, List<Films> used, int page) {
        List<Long> top = repository.findAll().stream().filter(x -> (x.getUserClassId() == userClassId))
                .filter(x -> used.stream().noneMatch(z -> x.getFilmId() == z.getId()))
                .sorted(Comparator.comparingDouble(Rating::getNumberOfRatings))
                .skip((long) config.getLowEvaluatedLimit() *page)
                .limit(config.getLowEvaluatedLimit()).map(Rating::getFilmId).collect(Collectors.toList());
        return filmsService.getAllFilmsWithIds(top);
    }

    @Override
    public List<Films> getFilms(long userClassId) {
        return getFilms(userClassId, 0);
    }

    @Override
    public List<Films> getFilms(long userClassId, int page) {
        List<Films> result = getTopRatingByUserClassId(userClassId, page);
        result.addAll(getLowEvaluatedFilmsByUserClassId(userClassId, result, page));
        if(result.size()==0){
            addRatings(userClassId);
            result = getTopRatingByUserClassId(userClassId, 0);
            result.addAll(getLowEvaluatedFilmsByUserClassId(userClassId, result, 0));
        }
        return result;
    }

    private void addRatings(long userClassId){
        Rating rating;
        for(Films film : filmsService.getAllFilms()){
            rating = new Rating();
            rating.setUserClassId(userClassId);
            rating.setFilmId(film.getId());
            rating.setRating(0);
            rating.setNumberOfRatings(0);
            repository.save(rating);
        }
    }

}
