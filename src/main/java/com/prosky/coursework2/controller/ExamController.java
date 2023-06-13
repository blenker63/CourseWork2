package com.prosky.coursework2.controller;

import com.prosky.coursework2.service.ExaminerService;
import com.prosky.coursework2.service.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
public class ExamController {
   private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/{amount}")
    public Collection<Question> examinerRandomQuestion(@PathVariable int amount) {
        return examinerService.getQuestion(amount);
    }
}
