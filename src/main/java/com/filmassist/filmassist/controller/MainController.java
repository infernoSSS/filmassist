package com.filmassist.filmassist.controller;

import com.filmassist.filmassist.service.QuestionTree;
import com.filmassist.filmassist.service.RatingService;
import com.filmassist.filmassist.tasks.Answer;
import com.filmassist.filmassist.tasks.QuestionTreeConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@SessionScope
public class MainController {
    private QuestionTree questionTree;

    @Autowired
    private RatingService ratingService;

    @GetMapping("/quest")
    public String getQeust(Model model){
        this.questionTree = new QuestionTree(new QuestionTreeConfigurator());
        model.addAttribute("quest", questionTree.getCurrent());
        return "question_p";
    }

    @PostMapping("/quest")
    public String postQuest(Model model, @RequestParam String answer){
        if(questionTree==null){
            this.questionTree = new QuestionTree(new QuestionTreeConfigurator());
        }
        if(answer == null || questionTree.getCurrent()==null){
            model.addAttribute("quest", questionTree.getCurrent());
            return "question_p";
        }
        List<String> answers = questionTree.getCurrent().getAnswers()
                .stream().map(Answer::getAnswer).collect(Collectors.toList());
        var answerInd = answers.indexOf(answer);
        if(questionTree.doStep(Math.max(answerInd, 0))){
            model.addAttribute("quest", questionTree.getCurrent());
            return "question_p";
        };
        return filmsPage(model, questionTree.getWay());
    }

    public String filmsPage(Model model, String userClass){
        return filmsPage(model, null, userClass, null, null, null);
    }


    @PostMapping("/films")
    public String filmsPage(Model model, @RequestParam(required = false) String page, @RequestParam(required = false) String userClass,
                            @RequestParam(required = false) String evaluate, @RequestParam(required = false) String filmId,
                            @RequestParam(required = false) String nav){
        if(userClass==null){
            userClass="000";
        }
        if(evaluate!=null){
            if(evaluate.equals("Cool!")) {
                ratingService.evaluation(Integer.parseUnsignedInt(userClass), Integer.parseUnsignedInt(filmId), true);
            }else{
                ratingService.evaluation(Integer.parseUnsignedInt(userClass), Integer.parseUnsignedInt(filmId), false);
            }
        }
        int iPage = page!=null ? Math.max(Integer.parseUnsignedInt(page)-1, 0) : 0;
        System.out.println(iPage);
        if(nav != null){
            if(nav.equals("next")){
                iPage++;
            }else if(iPage>0){
                iPage--;
            }
        }
        model.addAttribute("films", ratingService.getFilms(Integer.parseUnsignedInt(userClass), iPage));
        model.addAttribute("ui", userClass);
        model.addAttribute("page", iPage+1);
        return "films_p";
    }
}
