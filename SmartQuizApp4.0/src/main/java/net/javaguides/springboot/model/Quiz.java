package net.javaguides.springboot.model;

import java.util.ArrayList;
/**
 * Quiz Class is a class that holds questions and assesses students.
 * @param questions store the questions in the quiz
 * @param answers store the student responses 
 * @param results stores the results (right/wrong)
 * @param correctAnswers list that stores the index corresponding to the correct answer for each question
 * @param score the calculated quiz score
 *
 */
public class Quiz {
    private ArrayList<Question> questions;		//Store the questions in the quiz
    private ArrayList<Integer> answers, results, correctAnswers;		//Store the student responses and the results (right/wrong)
    private String firstName, lastName;
    private int score;

    /**
     * Constructor for objects of class Quiz
     */
    public Quiz()
    {
        questions = new ArrayList<Question>();
        answers = new ArrayList<Integer>();
        results = new ArrayList<Integer>();
        correctAnswers = new ArrayList<Integer>();
        firstName = "John";
        lastName = "Doe";
    }

    //
    /**
     * Constructor for objects of class Quiz. Build a random n-question quiz using a provided question bank.
     * @param f the first name of the student
     * @param l the last name of the student
     * @param b the question bank to pull questions from
     * @param n the number of questions needed
     * 
     */
    public Quiz(String f, String l, QuestionBank b, int n)
    {
        questions = new ArrayList<Question>();
        answers = new ArrayList<Integer>();
        results = new ArrayList<Integer>();
        correctAnswers = new ArrayList<Integer>();
        firstName = f;
        lastName = l;

        if (n > b.size())		//If the bank doesn't have enough questions, use them all
            n = b.size();

        while (questions.size() < n) {
            Question temp = b.getRandom();
            add(temp);
            
        }
        
    }

    /**
     * Add a new question to the quiz after checking that it isn't a duplicate - returns true if added
     * @param q the question object to be added
     */
    public boolean add(Question q)
    {
        if (contains(q))
            return false;

        questions.add(new Question(q));
        correctAnswers.add(q.getCorrect());
        return true;
    }

    /**
     * Check to see if Question q is in the quiz
     * @param q the question object to be checked
     */
    public boolean contains(Question q)
    {
        for (Question quest : questions)
            if (q.equals(quest))
                return true;
        return false;
    }

    /**
     * Rearrange the order of the answers in each question
     */
    public void randomize()
    {
        for (int i = 0; i < questions.size(); i++)
        {
            Question temp = new Question(questions.get(i));
            temp.randomize();
            questions.set(i, temp);
        }
    }

    /**
     * Return the student full name
     */
    public String getName()
    {
        return lastName + ", " + firstName;
    }

    /**
     *  Returns in a quiz format, with name, question, and all answers for each - used for testing, but could use in 
     *  a print quiz option
     */
    public String toString()
    {
        String temp = getName() + "\n--------------------\n";
        for (int i = 0; i < questions.size(); i++)
            temp += "" + (i + 1) + ") " + questions.get(i) + "\n" + questions.get(i).answersIndent() + "\n";
        return temp.substring(0, temp.length()-1);
    }

    /**
     * Returns the number of questions in the quiz
     */
    public int size()
    {
        return questions.size();
    }

    /**
     * Takes in the set of answers, checks them, stores those results (right = 1, wrong = 0), and returns the number of 
     * correct answers
     * @param a the student answers to the questions
     */
    public int check(ArrayList<Integer> a)
    {
        answers = a;
        for (int i = 0; i < answers.size(); i++)
            if(questions.get(i).isRight(answers.get(i)))
            {
                results.add(1);
                score++;
            }
            else
                results.add(0);
        return score;
    }

    /**
     * Returns the right/wrong results as 1/0
     */
    public ArrayList<Integer> getResults()
    {
        return results;
    }

    /**
     * Returns the number of correct responses
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Returns a question
     */
    public Question get(int n)
    {
        return questions.get(n);
    }

    /**
     * Returns the arraylist of quiz questions
     */
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    /**
     * Sets the arraylist of quiz questions
     */
    public void setQuestions(ArrayList<Question> quiz) {
        this.questions = quiz;
    }

    /**
     * Returns the arraylist of student answers 
     */
    public ArrayList<Integer> getAnswers() {
        return answers;
    }

    /**
     * Sets the arraylist of quiz answers 
     */
    public void setAnswers(ArrayList<Integer> answers) {
        this.answers = answers;
    }

    /**
     * Returns the first name of the quiz taker
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the quiz taker
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the quiz taker
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the quiz taker
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets an arraylist of scores for each question
     */
    public void setResults(ArrayList<Integer> results) {
        this.results = results;
    }

    /**
     * Sets score for the quiz that was taken
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    /**
     * Returns the arraylist of quiz answers 
     */
    public ArrayList<Integer> getCorrectAnswers() {
        return correctAnswers;
    }
}