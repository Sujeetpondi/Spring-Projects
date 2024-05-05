package com.myapp.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.quiz.model.QuestionWrapper;
import com.myapp.quiz.model.Quiz;
import com.myapp.quiz.model.QuizDto;
import com.myapp.quiz.model.Response;
import com.myapp.quiz.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService services;
	
	@PostMapping("create")
	public ResponseEntity<Quiz> createQuiz (@RequestBody QuizDto dto)
	{
		return services.createQuiz(dto.getCategoryName(),dto.getNoOfQns(),dto.getTitle());
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id)
	{
		return services.getQuizQuestions(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> responses)
	{
		return services.calculateScore(id,responses);
	}

}
