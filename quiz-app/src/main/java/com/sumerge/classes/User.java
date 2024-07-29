package com.sumerge.classes;

import com.sumerge.App;

public class User {

    private String name;
    private int score;

    public User(String name)
    {
        this.name = name;
    }

    public void answerQuestion(Question question)
    {
        System.out.print("your answer is \n-> ");
        String userAnswer = App.sc.nextLine();
        score += question.checkAnswer(userAnswer);
    }

    public int getScore()
    {
        return score;
    }

    public String getName()
    {
        return name;
    }

}
