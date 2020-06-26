import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Testing {

    public static void main(String[] args) {
        QuestionBank bank = new QuestionBank();
        try {
            File file = new File("questions.txt");
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String quest = read.nextLine();
                ArrayList<String> answers = new ArrayList<String>();
                String ans = read.nextLine();
                while (!ans.equals(""))
                {
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
        
        Quiz q1 = new Quiz();
        
        while (q1.size() < 4)
        {
            Question temp = bank.getRandom();
            if (!q1.contains(temp))
                q1.add(temp);
        }
        
        Quiz q2 = new Quiz();
        
        while (q2.size() < 4)
        {
            Question temp = bank.getRandom();
            if (!q2.contains(temp))
                q2.add(temp);
        }
        
        q1.randomize();
        q2.randomize();
        
        System.out.println(q1);
        System.out.println(q2);
    }

}