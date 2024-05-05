package com.question.Services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.Entity.Question;
import com.question.Repository.QuestionRepository;
import com.question.Services.QuestionService;

@Service
public class QuestionImpl implements QuestionService{
	
	@Autowired
	QuestionRepository repo;
	
	
	
	public QuestionImpl(QuestionRepository repo) {
		this.repo = repo;
	}


	public Question add(Question question)
	{
		return repo.save(question);
		
	}


	@Override
	public Question get(Long id) {
		return repo.findById(id)
				.orElseThrow(()-> new RuntimeException(" No Data found for Id"+id));
	}


	@Override
	public List<Question> getAll() {
		return repo.findAll();
	}


	@Override
	public List<Question> getQuestionsofQuize(Long QuizeID) {
		return repo.findByquizeId(QuizeID);
	}

}
