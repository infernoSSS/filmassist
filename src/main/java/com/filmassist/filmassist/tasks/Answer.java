package com.filmassist.filmassist.tasks;

public class Answer{
    private String answer;
    private Question to;

    public Answer(String answer, Question to) {
        this.answer = answer;
        this.to = to;
    }

    public Question getTo() {
        return to;
    }

    public void setTo(Question to) {
        this.to = to;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
