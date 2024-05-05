package com.myapp.question.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myapp.question.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

	List<Question> findAllByCategory(String category);

	
	@Query(value = "Select id  from questionDB.question where category = :categoryName ORDER BY rand() Limit :noOfQns",nativeQuery = true)
	List<Integer> findRandomQuestionIdByCategory(String categoryName, Integer noOfQns);

}
