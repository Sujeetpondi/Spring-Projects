package com.question.Services;

import java.util.List;

import com.question.Entity.Question;

public interface QuestionService {
	
	Question add(Question question);
	
	Question get(Long id);
	
	List<Question> getAll();
	
	List<Question> getQuestionsofQuize(Long QuizeID);

}
