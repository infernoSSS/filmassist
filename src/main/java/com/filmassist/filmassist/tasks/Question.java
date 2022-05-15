package com.filmassist.filmassist.tasks;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String question;
    private List<Answer> answers;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Question(String question) {
        this.question = question;
        this.answers = new ArrayList();
    }

    public Question(Question question) {
        this.question = question.question;
        this.answers = new ArrayList();
    }

    public void add(Answer a){
        answers.add(a);
    }

    public Question getNextQuestByAnswer(int answerIndex){
        return answers.get(answerIndex - 1).getTo();
    }

    public List<Answer> getAnswers(){
        return answers;
    }
}
