package com.myapp.question.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myapp.question.dao.QuestionRepository;
import com.myapp.question.model.Question;
import com.myapp.question.model.QuestionWrapper;
import com.myapp.question.model.Response;

@Service
public class QuestionService{
	
	@Autowired
	QuestionRepository repo;
	

	public ResponseEntity<List<Question>> getAllQuestion() {
		
		return new ResponseEntity<List<Question>>( repo.findAll(),HttpStatus.OK);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		
		return new ResponseEntity<List<Question>>(repo.findAllByCategory(category),HttpStatus.OK);
	}

	public ResponseEntity<Question> addQuestion(Question question) {
		return new ResponseEntity<Question>(repo.save(question),HttpStatus.ACCEPTED);
	}

	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName,Integer noOfQns) {
		
		List<Integer> questionId = repo.findRandomQuestionIdByCategory(categoryName,noOfQns);
		
		return new ResponseEntity<List<Integer>>(questionId,HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsByIds(List<Integer> qnsIds) {
		
		List<Question> questions = new ArrayList<>();
		List<QuestionWrapper> qnsForClient = new ArrayList<>();
		for(int id : qnsIds)
		{
			questions.add(repo.findById(id).get());
		}
		for(Question question : questions)
		{
			QuestionWrapper wrapperQns = new QuestionWrapper(
					question.getid(), 
					question.getCategory(),
					question.getQuestionTitle(), 
					question.getOption1(),  
					question.getOption2(), 
					question.getOption3(),
					question.getOption4()
					);
			qnsForClient.add(wrapperQns);
		}
		System.out.println("Question Generated");
		
		return new ResponseEntity<List<QuestionWrapper>>(qnsForClient,HttpStatus.ACCEPTED);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {
		int score =0;
		
		for(Response res : responses)
		{
			Question qns = repo.findById(res.getId()).get();
			if(qns.getRightAnswer().equals(res.getResponse()))
				score++;
			System.out.println("Score Increased");
		}
		
		return new ResponseEntity<Integer>(score,HttpStatus.OK);
	}
	

}
