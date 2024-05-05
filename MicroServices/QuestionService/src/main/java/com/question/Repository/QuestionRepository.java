package com.question.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.question.Entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{
	
	List<Question> findByquizeId(Long quizeId);

}
