import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Testing {
	private static QuestionBank bank;

	public static void fillBank() {
		bank = new QuestionBank();
		try {
			File file = new File("questions.txt");
			Scanner read = new Scanner(file);
			while (read.hasNextLine()) {
				String quest = read.nextLine();
				ArrayList<String> answers = new ArrayList<String>();
				String ans = read.nextLine();
				while (!ans.equals("")) {
					answers.add(ans);
					ans = read.nextLine();
				}
				Question q = new Question(quest, answers);
				bank.add(q);
			}
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("That file ain't there.");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int n = 4;
		
		fillBank();
		
		Quiz q1 = new Quiz("Randolph", "Smith", bank, n);
		ArrayList<Integer> a1 = new ArrayList<Integer>();

		//Quiz q2 = new Quiz("Matilda", "Jones", bank, 4);

		q1.randomize();
		//q2.randomize();
		
		for (int i = 0; i < q1.size(); i++)
		{
			a1.add((int)(Math.random()*4));
		}
		
		int score1 = q1.check(a1);
		ArrayList<Integer> r1 = q1.getResults();
		
		System.out.println(q1);
		System.out.println("\n---------------------------------------------------------------\n");
		//System.out.println(q2);
		System.out.println(r1);
		System.out.println(score1);
		
		
	}

}