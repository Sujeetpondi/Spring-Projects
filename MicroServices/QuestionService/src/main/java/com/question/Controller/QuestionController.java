package com.question.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.Entity.Question;
import com.question.Services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService service;
	
	
	
	//Create 
	@PostMapping
	public Question create(@RequestBody Question question)
	{
		return service.add(question);
		
	}
	
	//Fetch
	@GetMapping("/{Id}")
	public Question get(@PathVariable Long Id)
	{
		return service.get(Id);
		
	}
	
	@GetMapping 
	public List<Question> getAll()
	{
		return service.getAll();
	}
	
	//Get All questions related to specific quiz ID
	@GetMapping("/quiz/{QuizID}")
	public List<Question> getQuestionsByQuizeID(@PathVariable Long QuizID)
	{
		return service.getQuestionsofQuize(QuizID);
	}
	
	
}
