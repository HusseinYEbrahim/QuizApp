package com.sumerge;

import java.util.*;
import java.io.IOException;
import java.nio.file.Path;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.sumerge.classes.*;
import com.sumerge.classes.exceptions.NoMoreQuestionsException;

/**
 * Hello world!
 *
 */
public class App 
{

    public static Scanner sc = new Scanner(System.in);

    public static User login(HashMap<String, User> users)
    {
        System.out.print("Enter your username\n-> ");
        String username = sc.nextLine();
        User user = new User(username);
        if(users.containsKey(username))
            System.out.println("Welcome Back " + username + " , last time you got " + users.get(username).getScore());
        else
            System.out.println("Welcome " + username + ", Enjoy the quiz");
        users.put(username, user);
        return user;
    }

    public static void main( String[] args ) throws StreamReadException, DatabindException, IOException
    {
        Quiz quiz = DiskUtils.readQuiz(Path.of("./quiz.json"));
        HashMap<String, User> loggedInUsers = new HashMap<>();
        
        System.out.println("Welcome to Quizlet");
    
        while(true)
        {
            User user = login(loggedInUsers);
            System.out.println("Starting QUiz : " + quiz.getName());
            while(quiz.hasNextQuestion()){
                try {
                    Question currQuestion = quiz.getNextQuestion();
                    System.out.println(currQuestion);
                    user.answerQuestion(currQuestion);
                } catch (NoMoreQuestionsException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Congratulations you have scored " + user.getScore());
            quiz.reset();
        }
        
    }
}
