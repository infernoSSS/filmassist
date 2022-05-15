package com.filmassist.filmassist.controller;

import com.filmassist.filmassist.tasks.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
    @Autowired
    private Parser parser;

    @GetMapping("/search")
    public String search() {
        parser.parse();
        return "not_end";
    }
}
