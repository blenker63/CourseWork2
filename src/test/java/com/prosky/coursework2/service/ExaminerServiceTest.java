package com.prosky.coursework2.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    QuestionService questionServiceMoc;
    @InjectMocks
    ExaminerServiceImpl examinerServiceImpl;
    private Set<Question> questionSet;

    private final Collection<Question> questionCollection = Set.of(
            new Question("Q21", "A21"),
            new Question("Q22", "A22"),
            new Question("Q23", "A23"),
            new Question("Q24", "A24"),
            new Question("Q25", "A25"));

    @Test
    public void getQuestionNegative() {
        when(questionServiceMoc.getAll()).thenReturn(questionCollection);
        Assertions.assertThatExceptionOfType(ExceedingNumberQuestionsException.class).isThrownBy(() ->
                examinerServiceImpl.getQuestion(-1));
        Assertions.assertThatExceptionOfType(ExceedingNumberQuestionsException.class).isThrownBy(() ->
                examinerServiceImpl.getQuestion(questionCollection.size() + 1));
    }

    @Test
    public void getQuestionPositive() {
        when(questionServiceMoc.getAll()).thenReturn(questionCollection);
        when(questionServiceMoc.getRandomQuestion()).thenReturn(
                new Question("Q23", "A23"),
                new Question("Q23", "A23"),
                new Question("Q25", "A25"),
                new Question("Q22", "A22"));
        Assertions.assertThat(examinerServiceImpl.getQuestion(3))
                .hasSize(3)
                .containsExactlyInAnyOrder(new Question("Q23", "A23"),
                        new Question("Q22", "A22"),
                        new Question("Q25", "A25"));

    }
}

