package com.prosky.coursework2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @BeforeEach
    public void List() {
        javaQuestionService.add("Q1", "A1");
        javaQuestionService.add("Q2", "A2");
        javaQuestionService.add("Q3", "A3");
        javaQuestionService.add("Q4", "A4");
    }

    @Test
    public void addTest() {
        Question expected = new Question("Q55", "A55");
        Assertions.assertEquals(expected, javaQuestionService.add("Q55", "A55"));
    }

    @Test
    public void removeTest() {
        Question expected = new Question("Q4", "A4");
        Question actual = javaQuestionService.remove(new Question("Q4", "A4"));
    }

    @Test
    public void removeExceptionTest() {
        Assertions.assertThrows(NotFindException.class, () -> {
            javaQuestionService.remove(new Question("Q66", "A66"));
        });
    }

    @Test
    public void getAllTest() {
        List expected = Arrays.asList(
                new Question("Q1", "A1"),
                new Question("Q2", "A2"),
                new Question("Q3", "A3"),
                new Question("Q4", "A4"));
        Assertions.assertEquals(expected, javaQuestionService.getAll());
    }

    @Test
    public void getRandomQuestion() {

    }
}
