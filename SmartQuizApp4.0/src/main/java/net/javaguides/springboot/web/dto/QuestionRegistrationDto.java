package net.javaguides.springboot.web.dto;


public class QuestionRegistrationDto {
	private String question;
	private String Ans1;
	private String Ans2;
	private String Ans3;
	private String Ans4;
	private Integer correct;
	private Integer id;
	public QuestionRegistrationDto(){
		
	}
	
	
	public QuestionRegistrationDto(String question, String ans1, String ans2, String ans3, String ans4,
			Integer correct, Integer id) {
		super();
		this.question = question;
		Ans1 = ans1;
		Ans2 = ans2;
		Ans3 = ans3;
		Ans4 = ans4;
		this.correct = correct;
		this.id = id;
	}



	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAns1() {
		return Ans1;
	}
	public void setAns1(String ans1) {
		Ans1 = ans1;
	}
	public String getAns2() {
		return Ans2;
	}
	public void setAns2(String ans2) {
		Ans2 = ans2;
	}
	public String getAns3() {
		return Ans3;
	}
	public void setAns3(String ans3) {
		Ans3 = ans3;
	}
	public String getAns4() {
		return Ans4;
	}
	public void setAns4(String ans4) {
		Ans4 = ans4;
	}
	public Integer getCorrect() {
		return correct;
	}
	public void setCorrect(Integer correct) {
		this.correct = correct;
	}
	
	public Integer getid() {
		return id;
	}
	public void setid(Integer id) {
		this.id = id;
	}
	
	
	
}