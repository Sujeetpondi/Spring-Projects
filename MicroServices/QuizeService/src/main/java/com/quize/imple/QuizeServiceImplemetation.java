package com.quize.imple;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quize.Entity.Question;
import com.quize.Entity.Quize;
import com.quize.Repository.QuizeRepository;
import com.quize.Services.QuestionClient;
import com.quize.Services.QuizeServices;

@Service
public class QuizeServiceImplemetation implements QuizeServices {
	
	@Autowired
	private QuizeRepository quizerepo;
	@Autowired
	private QuestionClient questionClient;
	
	

	public QuizeServiceImplemetation(QuizeRepository quizerepo, QuestionClient questionClient) {
		this.quizerepo = quizerepo;
		this.questionClient = questionClient;
	}

	@Override
	public Quize add(Quize quize) {
		return quizerepo.save(quize);
	}

	@Override
	public List<Quize> get() {
		
		List<Quize> quizzes = quizerepo.findAll();
		List<Quize> QuizListWithQuestion = quizzes.stream().map(quiz -> {
			quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		
		return QuizListWithQuestion;
	}

	@Override
	public Quize get(Long id) {
		Quize quiz = quizerepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
		quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId())) ;
		return quiz;
	
	}

	

}
