package com.question.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long QuestionId;
	
	private String question;
	private Long quizeId;
	
	public long getQuestionId() {
		return QuestionId;
	}
	public void setId(long id) {
		this.QuestionId = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "Question [id=" + QuestionId + ", question=" + question + "]";
	}
	public Long getQuizeId() {
		return quizeId;
	}
	public void setQuizeId(Long Id) {
		quizeId = Id;
	}
	

}
