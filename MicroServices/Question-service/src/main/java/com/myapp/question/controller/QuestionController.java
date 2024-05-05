package com.myapp.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.question.model.Question;
import com.myapp.question.model.QuestionWrapper;
import com.myapp.question.model.Response;
import com.myapp.question.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService service;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		return service.getAllQuestion();
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
	{
		return service.getQuestionsByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question)
	{
		return service.addQuestion(question);
	}
	
	@PostMapping("generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer NoOfQns)
	{
		return service.getQuestionsForQuiz(categoryName,NoOfQns);
	}
	
	@GetMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionById(@RequestBody List<Integer> qnsIds)
	{
		return service.getQuestionsByIds(qnsIds);
	}
	
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
	{
		return service.getScore(responses);
	}
	

}
