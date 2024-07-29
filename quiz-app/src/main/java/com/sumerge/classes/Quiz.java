package com.sumerge.classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sumerge.classes.exceptions.NoMoreQuestionsException;

public class Quiz {

    private String name;
    private Question[] questions;
    int currQuestion = 0;

    @JsonCreator
    public Quiz(@JsonProperty("name") String name,
        @JsonProperty("questions") Question[] questions)
    {
        this.name = name;
        this.questions = questions;
    }

    public String getName()
    {
        return name;
    }

    public void reset()
    {
        currQuestion = 0;
    }

    public Question getNextQuestion() throws NoMoreQuestionsException
    {
        if(currQuestion >= questions.length)
            throw new NoMoreQuestionsException("The quiz doesn't have anymore questions");
        
        return questions[currQuestion++];
    }

    public boolean hasNextQuestion()
    {
        return currQuestion < questions.length;
    }
    
}
