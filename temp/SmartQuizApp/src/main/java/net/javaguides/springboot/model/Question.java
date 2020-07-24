package net.javaguides.springboot.model;


import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name =  "question", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Question {
	
	@Id
	@GeneratedValue
	@Column(name= "id")
	private Integer id;
	@Column(name= "question")
	private String questionPhrase;
	@Column(name= "Ans1")
	private String Ans1;
	@Column(name= "Ans2")
	private String Ans2;
	@Column(name= "Ans3")
	private String Ans3;
	@Column(name= "Ans4")
	private String Ans4;
	@Column(name= "correct")
	private Integer correct;
	
	
	public Question() {
		
	}
	public Question(Question q) {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getQuestionPhrase() {
		return questionPhrase;
	}


	public void setQuestionPhrase(String question) {
		this.questionPhrase = question;
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
	@Override
	public String toString() {
		return "Question [id=" + id + ", questionPhrase=" + questionPhrase + ", Ans1=" + Ans1 + ", Ans2=" + Ans2
				+ ", Ans3=" + Ans3 + ", Ans4=" + Ans4 + ", correct=" + correct + "]";
	}
	
	

}
