package net.javaguides.springboot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import net.javaguides.springboot.repository.QuestionRepository;
import net.javaguides.springboot.web.MainController;

import javax.persistence.Column;
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

	
	@Transient
	private Quiz quiz;
	
	@Transient
	private User user;
	
	@Transient
	private String questionPhrase1;
	@Transient
	private String questionPhrase2;	
	@Transient
	private String questionPhrase3;	
	@Transient
	private String questionPhrase4;	
	@Transient
	private ArrayList<String> answersOutput;	
	@Transient
	private String answer1;
	@Transient
	private String answer2;
	@Transient
	private String answer3;
	@Transient
	private String answer4;
	
	
	public Output() 
	{
		/*
		user = new User();
        answersOutput = new ArrayList<String>();
        answersOutput.add("answer A"); 
        answersOutput.add("answer B");
        answersOutput.add("answer C");
        answersOutput.add("answer D");
        
        Question question1 = new Question("Question 1?", answersOutput, 0);
        Question question2 = new Question("Question 2?", answersOutput, 1);
        Question question3 = new Question("Question 3?", answersOutput, 2);
        Question question4 = new Question("Question 4?", answersOutput, 3);
        
		QuestionBank q = new QuestionBank();

		q.add(question1);
		q.add(question2);
		q.add(question3);
		q.add(question4);
		
		quiz = new Quiz(firstName, lastName, q, 4); 
		questionPhrase1 = quiz.getQuiz().get(0).getQuestionPhrase();
		questionPhrase2 = quiz.getQuiz().get(1).getQuestionPhrase();
		questionPhrase3 = quiz.getQuiz().get(2).getQuestionPhrase();
		questionPhrase4 = quiz.getQuiz().get(3).getQuestionPhrase();
		
		// Right now the answer choices are being taken from only question 1, but we need to put stuff in an arraylist
		// so we don't have an exponential amount of answer variables. 
		
		answer1 = quiz.getQuiz().get(0).getAnswers().get(0);
		answer2 = quiz.getQuiz().get(0).getAnswers().get(1);
		answer3 = quiz.getQuiz().get(0).getAnswers().get(2);
		answer4 = quiz.getQuiz().get(0).getAnswers().get(3);
		
		answerChosen1 = "";
		answerChosen2 = "";
		answerChosen3 = "";
		answerChosen4 = "";
		
		*/
	}
	
	public Output(List<Question> questions) 
	{
		user = new User();
       
		QuestionBank q = new QuestionBank();
		
		q.loadQuestions(questions);
		

		quiz = new Quiz(firstName, lastName, q, 4); 
		questionPhrase1 = quiz.getQuestions().get(0).getQuestionPhrase();
		questionPhrase2 = quiz.getQuestions().get(1).getQuestionPhrase();
		questionPhrase3 = quiz.getQuestions().get(2).getQuestionPhrase();
		questionPhrase4 = quiz.getQuestions().get(3).getQuestionPhrase();
		
		
		// Right now the answer choices are being taken from only question 1, but we need to put stuff in an arraylist
		// so we don't have an exponential amount of answer variables. 
		
		answer1 = quiz.getQuestions().get(0).getAnswers().get(0);
		answer2 = quiz.getQuestions().get(0).getAnswers().get(1);
		answer3 = quiz.getQuestions().get(0).getAnswers().get(2);
		answer4 = quiz.getQuestions().get(0).getAnswers().get(3);
		answersOutput = new ArrayList<String>();
		answersOutput.add(answer1);
		answersOutput.add(answer2);
		answersOutput.add(answer3);
		answersOutput.add(answer4);
		
		
		answerChosen1 = "";
		answerChosen2 = "";
		answerChosen3 = "";
		answerChosen4 = "";
		
		
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

	public String getQuestionPhrase1() {
		return questionPhrase1;
	}

	public void setQuestionPhrase1(String questionPhrase1) {
		this.questionPhrase1 = questionPhrase1;
	}

	public String getQuestionPhrase2() {
		return questionPhrase2;
	}

	public void setQuestionPhrase2(String questionPhrase2) {
		this.questionPhrase2 = questionPhrase2;
	}

	public String getQuestionPhrase3() {
		return questionPhrase3;
	}

	public void setQuestionPhrase3(String questionPhrase3) {
		this.questionPhrase3 = questionPhrase3;
	}

	public String getQuestionPhrase4() {
		return questionPhrase4;
	}

	public void setQuestionPhrase4(String questionPhrase4) {
		this.questionPhrase4 = questionPhrase4;
	}

	public ArrayList<String> getAnswers() {
		return answersOutput;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answersOutput = answers;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
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

	@Override
	public String toString() {
		return "Output [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", period=" + period
				+ ", answerChosen1=" + answerChosen1 + ", answerChosen2=" + answerChosen2 + ", answerChosen3="
				+ answerChosen3 + ", answerChosen4=" + answerChosen4 + "]";
	}

	}