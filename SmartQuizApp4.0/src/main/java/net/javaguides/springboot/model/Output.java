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


/**
 * Class that holds user quiz output and stores a user response
 * @author QuestionBankGroup
 * 
 * @param id the output id
 * @param firstName the user first name
 * @param lastName the user last name
 * @param period the user class period
 * @param answerChosen1 the answer chosen for question 1
 * @param answerChosen2 the answer chosen for question 2
 * @param answerChosen3 the answer chosen for question 3
 * @param answerChosen4 the answer chosen for question 4
 * @param the user assessment score
 * @param correctAnswers a list of index values corresponding to the correct quiz answers
 * @param answerChosen an array of string values corresponding to the answers selected
 * @param quiz the quiz assigned to the user
 * @param user the student taking the quiz
 * 
 *
 */
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

/**
 * Default constructor for Output class	
 */
	public Output() 
	{
		
	}
	
/**
 * Constructor for Output class
 * @param questions the list of questions to be used for the question bank
 */
	public Output(List<Question> questions) 
	{
		user = new User();
       
		QuestionBank q = new QuestionBank();
		
		q.loadQuestions(questions);
		
		int num = 4;
		quiz = new Quiz(firstName, lastName, q, num); 
		
		
		answerChosen = new String[num];
		score = 0;
		correctAnswers = quiz.getCorrectAnswers();
		
	}

/**
 * Getter method for output id
 * @return output id
 */
	public Integer getId()
	{
		return id;
	}

/**
 * Setter method for output id
 * @param id the output id
 */
	public void setId(Integer id)
	{
		this.id = id;
	}

/**
 * Getter method for the quiz object
 * @return the quiz object
 */
	public Quiz getQuiz() {
		return quiz;
	}

/**
 * Setter method for the quiz object
 * @param quiz the quiz object
 */
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

/**
 * Getter method for the user object
 * @return the user object
 */
	public User getUser() {
		return user;
	}

/**
 * Setter method for the user object
 * @param user the user object
 */
	public void setUser(User user) {
		this.user = user;
	}

/**
 * Getter method for student first name
 * @return first name
 */
	public String getFirstName() {
		return firstName;
	}

/**
 * Setter method for student first name
 * @param firstName the student first name
 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

/**
 * Getter method for student last name
 * @return student last name
 */
	public String getLastName() {
		return lastName;
	}
	
/**
 * Setter method for student last name
 * @param lastName student last name
 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

/**
 * Getter method for class period
 * @return class period
 */
	public String getPeriod() {
		return period;
	}

/**
 * Setter method for class period
 * @param period class period
 */
	public void setPeriod(String period) {
		this.period = period;
	}

/**
 * Getter method for answerChosen1
 * @return the answer chosen for question 1
 */
	public String getAnswerChosen1() {
		return answerChosen1;
	}

/**
 * Setter method for answerChosen1
 * @param answerChosen1 the answer chosen for question 1
 */
	public void setAnswerChosen1(String answerChosen1) {
		this.answerChosen1 = answerChosen1;
	}

	/**
	 * Getter method for answerChosen2
	 * @return the answer chosen for question 2
	 */
	public String getAnswerChosen2() {
		return answerChosen2;
	}

	/**
	 * Setter method for answerChosen2
	 * @param answerChosen1 the answer chosen for question 2
	 */
	public void setAnswerChosen2(String answerChosen2) {
		this.answerChosen2 = answerChosen2;
	}

	/**
	 * Getter method for answerChosen3
	 * @return the answer chosen for question 3
	 */
	public String getAnswerChosen3() {
		return answerChosen3;
	}

	/**
	 * Setter method for answerChosen3
	 * @param answerChosen1 the answer chosen for question 3
	 */
	public void setAnswerChosen3(String answerChosen3) {
		this.answerChosen3 = answerChosen3;
	}

	/**
	 * Getter method for answerChosen4
	 * @return the answer chosen for question 4
	 */
	public String getAnswerChosen4() {
		return answerChosen4;
	}

	/**
	 * Setter method for answerChosen4
	 * @param answerChosen1 the answer chosen for question 4
	 */
	public void setAnswerChosen4(String answerChosen4) {
		this.answerChosen4 = answerChosen4;
	}
	
/**
 * Getter method for answerChosen - a list of all answers chosen by the student
 * @return list of answers chosen
 */
	public String[] getAnswerChosen() {
		return answerChosen;
	}
	
/**
 * Setter method for student answerChosen
 * @param answerChosen a list of student answer choices
 */
	public void setAnswerChosen(String[] answerChosen) {
		this.answerChosen = answerChosen;
	}

/**
 * Getter method for student quiz score
 * @return the quiz score
 */
	public int getScore() {
		
		return score;
	}

/**
 * Setter method for student quiz score
 * @param score the quiz score
 */
	public void setScore(int score) {
		this.score = score;
	}
	
/**
 * Getter method for correctAnswers list
 * @return list of correct answers
 */
	public ArrayList<Integer> getCorrectAnswers() {
		return correctAnswers;
	}

/**
 * Setter method for correctAnswers list
 * @param correctAnswers list of correctAnswer index values
 */
	public void setCorrectAnswers(ArrayList<Integer> correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
	
/**
 * To string method for Output object
 */
	@Override
	public String toString() {
		return "Output [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", period=" + period
				+ ", answerChosen1=" + answerChosen1 + ", answerChosen2=" + answerChosen2 + ", answerChosen3="
				+ answerChosen3 + ", answerChosen4=" + answerChosen4 + "]";
	}

	}