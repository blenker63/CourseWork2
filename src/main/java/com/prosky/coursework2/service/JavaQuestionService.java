package com.prosky.coursework2.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Random random = new Random();
    Set<Question> questionsSet = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questionsSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questionsSet.contains(question)) {
            questionsSet.remove(question);
            return question;
        }
        throw new NotFindException("Такой вопрос отсутствует");
    }

    @Override
    public Collection<Question> getAll() {
        List<Question> questionList = new ArrayList<>(questionsSet);
        return questionList;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> randomQuestion = new ArrayList<>(questionsSet);
        int number = random.nextInt(getAll().size());
        return randomQuestion.get(number);
    }

}
