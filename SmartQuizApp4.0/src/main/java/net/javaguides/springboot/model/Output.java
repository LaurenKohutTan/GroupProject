package net.javaguides.springboot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import net.javaguides.springboot.repository.QuestionRepository;
import net.javaguides.springboot.web.MainController;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name =  "output", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Output {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "period")
	private String period;
	
	@Column(name = "response1")
	private String answerChosen1;
	@Column(name = "response2")
	private String answerChosen2;
	@Column(name = "response3")
	private String answerChosen3;
	@Column(name = "response4")
	private String answerChosen4;
	
	@Column(name = "score")
	private int score;
	
	@Transient
	private ArrayList<Integer> correctAnswers;
	
	@Transient
	private String[] answerChosen;
	
	@Transient
	private Quiz quiz;
	  
	@Transient
	private User user;
	
	public Output() 
	{
		
	}
	
	public Output(List<Question> questions) 
	{
		user = new User();
       
		QuestionBank q = new QuestionBank();
		
		q.loadQuestions(questions);
		
		int num = 4;
		quiz = new Quiz(firstName, lastName, q, num); 
		
		
		answerChosen = new String[num];
		//answerChosen[0] = "";
		initializeAnswers(num);
		
		score = 0;
		correctAnswers = quiz.getCorrectAnswers();
		
	}
	
	private void initializeAnswers(int n)
	{
		for (int i = 0; i < n; i++)
			answerChosen[i] = "test";
		
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	
	public String getAnswerChosen1() {
		return answerChosen1;
	}

	public void setAnswerChosen1(String answerChosen1) {
		this.answerChosen1 = answerChosen1;
	}

	public String getAnswerChosen2() {
		return answerChosen2;
	}

	public void setAnswerChosen2(String answerChosen2) {
		this.answerChosen2 = answerChosen2;
	}

	public String getAnswerChosen3() {
		return answerChosen3;
	}

	public void setAnswerChosen3(String answerChosen3) {
		this.answerChosen3 = answerChosen3;
	}

	public String getAnswerChosen4() {
		return answerChosen4;
	}

	public void setAnswerChosen4(String answerChosen4) {
		this.answerChosen4 = answerChosen4;
	}
	
	
	public String[] getAnswerChosen() {
		return answerChosen;
	}
	

	public void setAnswerChosen(String[] answerChosen) {
		this.answerChosen = answerChosen;
	}

	
	
	public int getScore() {
		
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	

	public ArrayList<Integer> getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(ArrayList<Integer> correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	@Override
	public String toString() {
		return "Output [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", period=" + period
				+ ", answerChosen1=" + answerChosen1 + ", answerChosen2=" + answerChosen2 + ", answerChosen3="
				+ answerChosen3 + ", answerChosen4=" + answerChosen4 + "]";
	}

	}