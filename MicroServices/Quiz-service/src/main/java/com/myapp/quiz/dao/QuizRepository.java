package com.myapp.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.quiz.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer>{

}
