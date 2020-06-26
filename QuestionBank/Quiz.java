import java.util.ArrayList;

public class Quiz {
	private ArrayList<Question> quiz;
	
	public Quiz()
	{
		quiz = new ArrayList<Question>();
	}
	
	public void add(Question q)
	{
		if (!contains(q))
			quiz.add(new Question(q));
	}
	
	public boolean contains(Question q)
	{
		for (Question quest : quiz)
			if (q.toString().contentEquals(quest.toString()))
					return true;
		return false;
			
	}
	
	public void randomize()
	{
		for (int i = 0; i < quiz.size(); i++)
		{
			Question temp = new Question(quiz.get(i).toString(), quiz.get(i).getAnswers());
			temp.randomize();
			quiz.set(i, temp);
		}
	}
	
	public String toString()
	{
		String temp = "";
		for (int i = 0; i < quiz.size(); i++)
			temp += "" + (i + 1) + ") " + quiz.get(i) + "\n" + quiz.get(i).answersIndent() + "\n";
		return temp.substring(0, temp.length()-1);
	}
	
	public int size()
	{
		return quiz.size();
	}
}
