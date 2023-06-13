package com.prosky.coursework2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
@Mock
    QuestionService questionServiceMoc;
@InjectMocks
    ExaminerService examinerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        examinerService = new ExaminerService(questionServiceMoc);
    }
}
