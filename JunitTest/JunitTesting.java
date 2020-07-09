public class JunitTesting {
	
	public int squareNum(int x)
	{
		return x * x;
	}
	
	public int countAs(String phrase)
	{
		int count = 0;
		for (int i = 0; i < phrase.length(); i++) 
		{
			if (phrase.charAt(i) == 'a' || phrase.charAt(i) == 'A')
			{
				count++;
			}
		}
		return count;
	}
}