package com.filmassist.filmassist.service;

import com.filmassist.filmassist.tasks.Question;
import com.filmassist.filmassist.tasks.QuestionTreeConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class QuestionTree {
    private QuestionTreeConfigurator configurator;
    private Question current;
    private String userWay;

    @Autowired
    public QuestionTree(@Qualifier("qtcd") QuestionTreeConfigurator configurator){
        this.current = configurator.configuration();
        this.userWay = "";
    }

    public boolean doStep(int answerIndex) {
        current = current.getNextQuestByAnswer(answerIndex+1);
        userWay+=answerIndex;
        return current != null;
    }

    public String getWay(){
        return userWay;
    }

    public Question getCurrent() {
        return current;
    }
}
