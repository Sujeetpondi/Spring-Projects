package com.myapp.quiz.model;

public class QuestionWrapper {

	int questionId;
	String questionTitle,category,option1,ioption2,option3,option4;
	public QuestionWrapper(int questionId, String questionTitle, String category, String option1, String ioption2,
			String option3, String option4) {
		super();
		this.questionId = questionId;
		this.questionTitle = questionTitle;
		this.category = category;
		this.option1 = option1;
		this.ioption2 = ioption2;
		this.option3 = option3;
		this.option4 = option4;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getIoption2() {
		return ioption2;
	}
	public void setIoption2(String ioption2) {
		this.ioption2 = ioption2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	
}
