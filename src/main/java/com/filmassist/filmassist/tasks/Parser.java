package com.filmassist.filmassist.tasks;

import com.filmassist.filmassist.model.Films;
import com.filmassist.filmassist.service.FilmsService;
import com.filmassist.filmassist.service.FilmsServiceImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Parser {
    @Autowired
    private FilmsService service;

    public void parse(){
        String url = "https://www.kinoafisha.info/rating/movies/";

        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("https://google.com")
                    .get();
            Elements titles = doc.getElementsByClass("movieItem_title");
            Elements imgs = doc.getElementsByClass("picture_image");
            String title;
            for(int i = 0; i<titles.size(); i++){
                title = titles.get(i).ownText();
                if(!service.isExist(title)){
                    Films film = new Films();
                    film.setTitle(title);
                    film.setImg(imgs.get(i).attr("data-picture"));
                    service.save(film);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
