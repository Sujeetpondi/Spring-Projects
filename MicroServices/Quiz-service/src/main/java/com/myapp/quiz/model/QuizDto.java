package com.myapp.quiz.model;

public class QuizDto {

	private String categoryName;
	private Integer noOfQns;
	private String title;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getNoOfQns() {
		return noOfQns;
	}
	public void setNoOfQns(Integer noOfQns) {
		this.noOfQns = noOfQns;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "QuizDto [categoryName=" + categoryName + ", noOfQns=" + noOfQns + ", title=" + title + "]";
	}
	public QuizDto(String categoryName, Integer noOfQns, String title) {
		super();
		this.categoryName = categoryName;
		this.noOfQns = noOfQns;
		this.title = title;
	}
	
	
}
