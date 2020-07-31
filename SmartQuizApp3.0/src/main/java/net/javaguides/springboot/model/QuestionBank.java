package net.javaguides.springboot.model;

import java.util.ArrayList;

public class QuestionBank {
	private ArrayList<Question> bank;
	
	public QuestionBank()
	{
		bank = new ArrayList<Question>();
	}
	
	//Add a new question, after checking to make sure it isn't already in the bank
	public void add(Question q)
	{
		if (!contains(q))
			bank.add(new Question(q));
	}
	
	//Return a random question from the bank - used to make a quiz
	public Question getRandom()
	{
		int n = (int)(Math.random()*bank.size());
		return new Question(bank.get(n));
	}
	
	//Returns the number of questions in the bank
	public int size()
	{
		return bank.size();
	}
	
	//Check to see if a given question is already in the bank
	public boolean contains(Question q)
	{
		for (Question quest : bank)
			if (q.equals(quest))
					return true;
		return false;
	}
	
	//Returns the list of questions in the bank
	public String toString()
	{
		String temp = "";
		for (Question q : bank)
			temp += q.toString() + "\n";
		
		return temp;
	}
	
	public Question get(int index)
    {
        return bank.get(index);
    }
}
