package com.myapp.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myapp.quiz.dao.QuizRepository;
import com.myapp.quiz.feign.QuestionInterface;
import com.myapp.quiz.model.QuestionWrapper;
import com.myapp.quiz.model.Quiz;
import com.myapp.quiz.model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizRepository repo;
	
	@Autowired
	QuestionInterface questionInterface;

	public ResponseEntity<Quiz> createQuiz(String category, int numQ, String title) {
	//call generate url of question service using questionInterface openGign client
		
		List<Integer> questionIds = questionInterface.getQuestionsForQuiz(category,numQ).getBody();
		
		Quiz quiz = new Quiz();
		quiz.setQuestionIds(questionIds);
		quiz.setTitle(title);
	
		return new ResponseEntity<Quiz>(repo.save(quiz),HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		Quiz quiz = repo.findById(id).get();
		List<Integer> questionIds = quiz.getQuestionIds();		
		return new ResponseEntity<List<QuestionWrapper>>(questionInterface.getQuestionById(questionIds).getBody(),HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateScore(int id, List<Response> responses) {
		
		return new ResponseEntity<Integer>(questionInterface.getScore(responses).getBody(),HttpStatus.OK );
	}

}
