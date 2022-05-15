package com.filmassist.filmassist.config;

import com.filmassist.filmassist.service.QuestionTree;
import com.filmassist.filmassist.tasks.QuestionTreeConfigurator;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {
    private final int topRLimit = 5;
    private final int lowEvaluatedLimit = 3;

    public int getTopRLimit() {
        return topRLimit;
    }

    public int getLowEvaluatedLimit() {
        return lowEvaluatedLimit;
    }

    @Bean(name = "qtd")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public QuestionTree getQuestionTree(){
        return new QuestionTree(new QuestionTreeConfigurator());
    }

    @Bean(name = "qtcd")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public QuestionTreeConfigurator getQuestionTreeConfigurator(){
        return new QuestionTreeConfigurator();
    }
}
