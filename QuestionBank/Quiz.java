import java.util.ArrayList;
/**
 * Quiz Class is a class that holds questions and assesses students.
 *
 */
public class Quiz {
    private ArrayList<Question> quiz;		//Store the questions in the quiz
    private ArrayList<Integer> answers, results;		//Store the student responses and the results (right/wrong)
    private String firstName, lastName;
    private int score;

    /**
     * Constructor for objects of class Quiz
     */
    public Quiz()
    {
        quiz = new ArrayList<Question>();
        answers = new ArrayList<Integer>();
        results = new ArrayList<Integer>();
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

    /**
     * Add a new question to the quiz after checking that it isn't a duplicate - returns true if added
     * @param q the question object to be added
     */
    public boolean add(Question q)
    {
        if (contains(q))
            return false;

        quiz.add(new Question(q));
        return true;
    }

    /**
     * Check to see if Question q is in the quiz
     * @param q the question object to be checked
     */
    public boolean contains(Question q)
    {
        for (Question quest : quiz)
            if (q.equals(quest))
                return true;
        return false;
    }

    /**
     * Rearrange the order of the answers in each question
     */
    public void randomize()
    {
        for (int i = 0; i < quiz.size(); i++)
        {
            Question temp = new Question(quiz.get(i));
            temp.randomize();
            quiz.set(i, temp);
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
        for (int i = 0; i < quiz.size(); i++)
            temp += "" + (i + 1) + ") " + quiz.get(i) + "\n" + quiz.get(i).answersIndent() + "\n";
        return temp.substring(0, temp.length()-1);
    }

    /**
     * Returns the number of questions in the quiz
     */
    public int size()
    {
        return quiz.size();
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
            if(quiz.get(i).isRight(answers.get(i)))
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
        return quiz.get(n);
    }
}
