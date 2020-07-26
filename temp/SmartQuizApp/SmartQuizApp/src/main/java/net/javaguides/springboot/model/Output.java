package net.javaguides.springboot.model;

import java.util.ArrayList;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
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
	private ArrayList<String> answers;	
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
		user = new User();
        answers = new ArrayList<String>();
        answers.add("answer A"); 
        answers.add("answer B");
        answers.add("answer C");
        answers.add("answer D");
        
        Question question1 = new Question("Question 1?", answers, 0);
        Question question2 = new Question("Question 2?", answers, 1);
        Question question3 = new Question("Question 3?", answers, 2);
        Question question4 = new Question("Question 4?", answers, 3);
        /*
        Question question1 = new Question();
        Question question2 = new Question();
        Question question3 = new Question();
        Question question4 = new Question();
		firstName = getUser().getFirstName();
		lastName = getUser().getLastName();
		period = user.getPeriod();
		*/
		QuestionBank q = new QuestionBank();
		/*
		q.add(question1);
		q.add(question2);
		q.add(question3);
		q.add(question4);
		*/
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
		/*
		answer1 = quiz.getQuiz().get(0).getAnswers().get(0);
		answer2 = quiz.getQuiz().get(0).getAnswers().get(1);
		answer3 = quiz.getQuiz().get(0).getAnswers().get(2);
		answer4 = quiz.getQuiz().get(0).getAnswers().get(3);
		*/
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

	@Transient
	public Quiz getQuiz() {
		return quiz;
	}

	
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Transient
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

	@Transient
	public String getQuestionPhrase1() {
		return questionPhrase1;
	}

	public void setQuestionPhrase1(String questionPhrase1) {
		this.questionPhrase1 = questionPhrase1;
	}

	@Transient
	public String getQuestionPhrase2() {
		return questionPhrase2;
	}

	public void setQuestionPhrase2(String questionPhrase2) {
		this.questionPhrase2 = questionPhrase2;
	}

	@Transient
	public String getQuestionPhrase3() {
		return questionPhrase3;
	}

	public void setQuestionPhrase3(String questionPhrase3) {
		this.questionPhrase3 = questionPhrase3;
	}

	@Transient
	public String getQuestionPhrase4() {
		return questionPhrase4;
	}

	public void setQuestionPhrase4(String questionPhrase4) {
		this.questionPhrase4 = questionPhrase4;
	}

	@Transient
	public ArrayList<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}

	@Transient
	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	@Transient
	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	@Transient
	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	@Transient
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
		return "Output [quiz=" + quiz + ", user=" + user + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", period=" + period + "]";
	}
	


}