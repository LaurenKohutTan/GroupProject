import java.util.ArrayList;

public class QuestionBank {
	private ArrayList<Question> bank;
	
	public QuestionBank()
	{
		bank = new ArrayList<Question>();
	}
	
	public void add(Question q)
	{
		if (!contains(q))
			bank.add(new Question(q));
	}
	
	public Question getRandom()
	{
		int n = (int)(Math.random()*bank.size());
		return new Question(bank.get(n));
	}
	
	public int size()
	{
		return bank.size();
	}
	
	public boolean contains(Question q)
	{
		return bank.contains(q);
	}
}
