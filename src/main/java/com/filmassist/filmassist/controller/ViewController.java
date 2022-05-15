package com.filmassist.filmassist.controller;

import com.filmassist.filmassist.model.Films;
import com.filmassist.filmassist.service.FilmsService;
import com.filmassist.filmassist.service.FilmsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @Autowired
    private FilmsService service;

    @GetMapping("/view")
    public String view(Model model){
        String result = "";
        for(Films f : service.getAllFilms()){
            result+=f.getTitle()+" ";
        }
        model.addAttribute("name", result);
        return "view";
    }
}
