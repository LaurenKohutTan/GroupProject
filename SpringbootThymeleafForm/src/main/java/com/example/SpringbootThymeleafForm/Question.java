package com.example.SpringbootThymeleafForm;
import java.util.ArrayList;


public class Question {
	private String question;				//The question itself
	private ArrayList<String> answers;		//Multiple choice answers
	private int correct;					//Which answer is correct
	
	
	public Question(String s, ArrayList<String> a)
	{
		question = s;
		answers = new ArrayList<>();
		answers.addAll(a);
	}
	
	//Copy constructor - used to add questions to new lists to ensure they're separate instances
	public Question(Question q)
	{
		question = q.toString();
		answers = new ArrayList<>();
		answers.addAll(q.getAnswers());
		correct = q.correct;
	}
	
	//The toString displays just the question (no answers)
	public String toString()
	{
		return question;
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	
	//Return a particular answer - possibly used for alternate displays
	public String get(int n)
	{
		return answers.get(n);
	}

	//Return all answers
	public String answers()
	{
		String temp = "";
		for (int i = 0; i < answers.size(); i++)
			temp += (char)(97+i) + ") " + answers.get(i) + "\n";
		return temp;
	}
	
	//Return all answers with a, b, c, etc formatting
	public String answersIndent()
	{
		String temp = "";
		for (int i = 0; i < answers.size(); i++)
			temp += "\t" + (char)(97+i) + ") " + answers.get(i) + "\n";
		return temp;
	}
	
	//Return the list of answers, to be used in a main for display
	public ArrayList<String> getAnswers()
	{
		return answers;
	}
	
	//Check to see if a tester's answer is correct
	public boolean isRight(int n)
	{
		return n == correct;
	}
	
	//Compare two questions to see if they're the same - avoids duplicating in lists of questions
	public boolean equals(Question other)
	{
		return question.equals(other.toString());
	}
	
	//Rearrange the order of answers in a question
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
}
