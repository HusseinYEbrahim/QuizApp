package com.sumerge.classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {

    private String prompt;
    private String answer;
    private int score;

    @JsonCreator
    public Question(@JsonProperty("prompt") String prompt, @JsonProperty("answer") String answer,
         @JsonProperty("score") int score)
    {
        this.prompt = prompt;
        this.answer = answer;
        this.score = score;
    }

    public int checkAnswer(String answer)
    {
        return this.answer.equals(answer) ? this.score : 0;
    }

    public String getPrompt()
    {
        return prompt;
    }

    public String toString()   
    {
        return prompt;
    }

    
}
