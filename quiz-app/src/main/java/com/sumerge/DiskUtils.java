package com.sumerge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sumerge.classes.Quiz;

public class DiskUtils {

    public static Quiz readQuiz(Path quizPath) throws StreamReadException, DatabindException, IOException
    {
        ObjectMapper om = new ObjectMapper();
        String data = Files.readString(quizPath);
        Quiz quiz = om.readValue(data, Quiz.class);
        return quiz;
    }
    
}
