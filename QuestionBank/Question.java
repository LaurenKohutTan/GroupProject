import java.util.ArrayList;

public class Question {
	private String question;
	private ArrayList<String> answers;
	private int correct;
	
	public Question(String s, ArrayList<String> a)
	{
		question = s;
		answers = new ArrayList<>();
		answers.addAll(a);
	}
	
	public Question(Question q)
	{
		question = q.toString();
		answers = new ArrayList<>();
		answers.addAll(q.getAnswers());
	}
	
	public String toString()
	{
		return question;
	}
	
	public String get(int n)
	{
		return answers.get(n);
	}
	
	public String answers()
	{
		String temp = "";
		for (int i = 0; i < answers.size(); i++)
			temp += (char)(97+i) + ") " + answers.get(i) + "\n";
		return temp;
	}
	
	public String answersIndent()
	{
		String temp = "";
		for (int i = 0; i < answers.size(); i++)
			temp += "\t" + (char)(97+i) + ") " + answers.get(i) + "\n";
		return temp;
	}
	
	public ArrayList<String> getAnswers()
	{
		return answers;
	}
	
	public boolean isRight(int n)
	{
		return n == correct;
	}
	
	public boolean equals(Question other)
	{
		return question.equals(other);
	}
	
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
