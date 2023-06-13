package com.prosky.coursework2.service;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{
private final QuestionService questionService;


    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        int size = questionService.getAll().size();
        if (size < amount) {
            throw new ExceedingNumberQuestionsException("Запрос превышает количество вопросов.");
        }
        Set<Question> randomSet = new HashSet<>();
        while (randomSet.size() < amount) {
            randomSet.add(questionService.getRandomQuestion());
        }
        return randomSet;
    }
}

