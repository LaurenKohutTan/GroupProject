package com.example.SpringbootThymeleafForm;

import java.util.ArrayList;

public class Quiz {
	private ArrayList<Question> quiz;		//Store the questions in the quiz
	private ArrayList<Integer> answers, results;		//Store the student responses and the results (right/wrong)
	private String firstName, lastName;
	private int score;
	
	public Quiz()
	{
		quiz = new ArrayList<Question>();
		answers = new ArrayList<Integer>();
		results = new ArrayList<Integer>();
		firstName = "John";
		lastName = "Doe";
	}
	
	//Build a random n-question quiz using a provided question bank
	public Quiz(String f, String l, QuestionBank b, int n)
	{
		quiz = new ArrayList<Question>();
		answers = new ArrayList<Integer>();
		results = new ArrayList<Integer>();
		firstName = f;
		lastName = l;
		
		if (n > b.size())		//If the bank doesn't have enough questions, use them all
			n = b.size();
		
		while (quiz.size() < n) {
			Question temp = b.getRandom();
			add(temp);
		}
	}
	
	
	
	public ArrayList<Question> getQuiz() {
		return quiz;
	}

	public void setQuiz(ArrayList<Question> quiz) {
		this.quiz = quiz;
	}

	public ArrayList<Integer> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<Integer> answers) {
		this.answers = answers;
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

	public void setResults(ArrayList<Integer> results) {
		this.results = results;
	}

	public void setScore(int score) {
		this.score = score;
	}

	//Add a new question to the quiz after checking that it isn't a duplicate - returns true if added
	public boolean add(Question q)
	{
		if (contains(q))
			return false;
		
		quiz.add(new Question(q));
		return true;
	}
	
	//Check to see if Question q is in the quiz
	public boolean contains(Question q)
	{
		for (Question quest : quiz)
			if (q.equals(quest))
					return true;
		return false;
	}
	
	//Rearrange the order of the answers in each question
	public void randomize()
	{
		for (int i = 0; i < quiz.size(); i++)
		{
			Question temp = new Question(quiz.get(i));
			temp.randomize();
			quiz.set(i, temp);
		}
	}
	
	//Returns the name
	public String getName()
	{
		return lastName + ", " + firstName;
	}
	
	//Returns in a quiz format, with name, question, and all answers for each - used for testing, but could use in a print quiz option
	public String toString()
	{
		String temp = getName() + "\n--------------------\n";
		for (int i = 0; i < quiz.size(); i++)
			temp += "" + (i + 1) + ") " + quiz.get(i) + "\n" + quiz.get(i).answersIndent() + "\n";
		return temp.substring(0, temp.length()-1);
	}
	
	//Returns the number of questions in the quiz
	public int size()
	{
		return quiz.size();
	}
	
	//Takes in the set of answers, checks them, stores those results (right = 1, wrong = 0), and returns the number of correct answers
	public int check(ArrayList<Integer> a)
	{
		answers = a;
		for (int i = 0; i < answers.size(); i++)
			if(quiz.get(i).isRight(answers.get(i)))
			{
				results.add(1);
				score++;
			}
			else
				results.add(0);
		return score;
	}
	
	//Returns the right/wrong results as 1/0
	public ArrayList<Integer> getResults()
	{
		return results;
	}
	
	//Returns the number of correct responses
	public int getScore()
	{
		return score;
	}
}
