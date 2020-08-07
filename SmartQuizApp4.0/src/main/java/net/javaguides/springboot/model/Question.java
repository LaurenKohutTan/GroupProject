package src.main.java.net.javaguides.springboot.model;


import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import java.util.ArrayList;

/**
 * Class that holds question object
 * @author QuestionBankGroup
 * @param id the question id
 * @param questionPhrase the question phrase
 * @param Ans1 first answer choice
 * @param Ans2 second answer choice
 * @param Ans3 third answer choice
 * @param Ans4 fourth answer choice
 * @param correct the integer corresponding to the index of the correct answer
 * @param answers the list of all answer choices
 *
 */
@Entity
@Table(name =  "question", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Question {
	
	@Id
	@GeneratedValue
	@Column(name= "id")
	private Integer id;
	@Column(name= "question")
	private String questionPhrase;
	@Column(name= "ans1")
	private String Ans1;
	@Column(name= "ans2")
	private String Ans2;
	@Column(name= "ans3")
	private String Ans3;
	@Column(name= "ans4")
	private String Ans4;
	@Column(name= "correct")
	private Integer correct;
	@Transient
	private ArrayList<String> answers;
	
/**
 * Constructor for objects of class Question
 */
	public Question() {
		answers = new ArrayList<String>();
		answers.add(Ans1);
		answers.add(Ans2);
		answers.add(Ans3);
		answers.add(Ans4);
		
	}
/**
 * Copy constructor - used to add questions to new lists to ensure they're separate instances
 * @param q
 */
	public Question(Question q) {
		questionPhrase = q.getQuestionPhrase();
		//System.out.println(questionPhrase);
		answers = new ArrayList<String>();
		answers.add(q.getAns1());
		answers.add(q.getAns2());
		answers.add(q.getAns3());
		answers.add(q.getAns4());
        correct = q.correct;

	}
	
	/**
     * Constructor for objects of class Question
     * @param s the question itself
     * @param a the arraylist of answer string choices
     * @param correct the correct answer
     */
    public Question(String s, ArrayList<String> a, int correct)
    {
        questionPhrase = s;
        answers = a;
        this.correct = correct;
        Ans1 = a.get(0);
        Ans2 = a.get(1);
        Ans3 = a.get(2);
        Ans4 = a.get(3);
    }
    
/**
 * Getter method for question id
 * @return the question id
 */
	public Integer getId() {
		return id;
	}

/**
 * Setter method for question id
 * @param id the question id
 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter method for question phrase
	 * @return the question phrase
	 */	
	public String getQuestionPhrase() {
		return questionPhrase;
	}

	/**
	 * Setter method for questionPhrase
	 * @param question the questionPhrase
	 */
	public void setQuestionPhrase(String question) {
		this.questionPhrase = question;
	}

	/**
     * Rearrange the order of answers in a question
     */
    public void randomize()
    {
        ArrayList<String> temp = new ArrayList<String>();
        String right = answers.get(correct);

        while (answers.size() > 0)
        {
            int n = (int)(Math.random() * answers.size());
            temp.add(answers.remove(n));
        }

        answers = temp;

        for (int i = 0; i < answers.size(); i++)
        {
            if (answers.get(i).equals(right))
                correct = i;
        }
    }

  /**
   * Getter method for the answer of the question in the list
   * @param n the index of the answer to the question in the list
   * @return the answer to the question in the list
   */
    public String get(int n)
    {
    	return answers.get(n);
    }
    
/**
 * Getter method for ans1
 * @return the first answer 
 */
	public String getAns1() {
		return Ans1;
	}

/**
 * Setter method for ans1
 * @param ans1 the string value for ans1
 */
	public void setAns1(String ans1) {
		Ans1 = ans1;
	}

	/**
	 * Getter method for ans2
	 * @return the first answer 
	 */
	public String getAns2() {
		return Ans2;
	}

	/**
	 * Setter method for ans2
	 * @param ans1 the string value for ans2
	 */
	public void setAns2(String ans2) {
		Ans2 = ans2;
	}

	/**
	 * Getter method for ans3
	 * @return the first answer 
	 */
	public String getAns3() {
		return Ans3;
	}

	/**
	 * Setter method for ans3
	 * @param ans1 the string value for ans3
	 */
	public void setAns3(String ans3) {
		Ans3 = ans3;
	}

	/**
	 * Getter method for ans4
	 * @return the first answer 
	 */
	public String getAns4() {
		return Ans4;
	}

	/**
	 * Setter method for ans4
	 * @param ans1 the string value for ans4
	 */
	public void setAns4(String ans4) {
		Ans4 = ans4;
	}


	/**
     * Return the list of answers, to be used in a main for display
     */
    public ArrayList<String> getAnswers()
    {
        return answers;
    }
    
    /**
     * Check to see if a tester's answer is correct
     * @param n the index corresponding to the answer choice
     */
    public boolean isRight(int n)
    {
        return n == correct;
    }
	
    /**
     * Compare two questions to see if they're the same - avoids duplicating in lists of questions
     * @param other Question object to compare 
     */
    public boolean equals(Question other)
    {
        return questionPhrase.equals(other.getQuestionPhrase());
    }
    
    /**
     * Return all answers with a, b, c, etc formatting
     */
    public String answersIndent()
    {
        String temp = "";
        for (int i = 0; i < answers.size(); i++)
            temp += "\t" + (char)(97+i) + ") " + answers.get(i) + "\n";
        return temp;
    }
 
    /**
     * Getter method for the correct
     * @return the index of the correct answer 
     */
	public Integer getCorrect() {
		return correct;
	}

/**
 * Setter method for correct
 * @param correct the index of the correct answer
 */
	public void setCorrect(Integer correct) {
		this.correct = correct;
	}
	
	
/**
 * Setter method for the list of answers
 * @param answers
 */
	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}
	
/**
 * To string method for question object
 */
	@Override
	public String toString() {
		return "Question [id=" + id + ", questionPhrase=" + questionPhrase + ", Ans1=" + Ans1 + ", Ans2=" + Ans2
				+ ", Ans3=" + Ans3 + ", Ans4=" + Ans4 + ", correct=" + correct + "]";
	}
	
}
