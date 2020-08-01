package net.javaguides.springboot.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * The test class QuizTest.
 *
 */
public class QuizTest
{
    /**
     * The test1 method checks that there are no repeated questions in the quiz
     * after it is generated.
     */
    @Test
    public void test1() {
        // Make a generic list of answers
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("A");
        answers.add("B");
        answers.add("C");
        answers.add("D");
        
        // Make a question bank with 20 questions. Answer to the questions 
        // will follow the pattern a, b, c, d, a, b, c, d... 
        QuestionBank questions = new QuestionBank();
        int[] answerChoices = {0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3};
        
        for (int i = 0; i < answerChoices.length; i++)
        {
            questions.add(new Question("What is the answer to q" + (i + 1) + "?", answers, answerChoices[i]));
            
        }
        

        // Make 4 new quizzes
        Quiz quiz1 = new Quiz("Person", "1", questions, 5);
        Quiz quiz2 = new Quiz("Person", "2", questions, 8);
        Quiz quiz3 = new Quiz("Person", "3", questions, 20);
        Quiz quiz4 = new Quiz("Person", "4", questions, 12);
        
        // Test 1 and 2: assume true until otherwise determined false
        Boolean test1 = true;
        Boolean test2 = true;
        //Quiz 1
        for (int i = 0; i < 5; i++) 
        {
            for (int j = 0; j < 5; j++)
            {
                // Check for repeats with the equals method from Question class:
                if (quiz1.get(i).equals(quiz1.get(j)) && i != j)
                   test1 = false;
                // Check for repeats with the getQuestion method from Question class
                // and the String equals method:
                else if(quiz1.get(i).getQuestionPhrase().equals(quiz1.get(j).getQuestionPhrase()) && i != j)
                {
                    test2 = false;
                }
            }
        }
        //Quiz 2
        for (int i = 0; i < 8; i++) 
        {
            for (int j = 0; j < 8; j++)
            {
                // Check for repeats with the equals method from Question class:
                if (quiz2.get(i).equals(quiz2.get(j)) && i != j)
                   test1 = false;
                // Check for repeats with the getQuestion method from Question class
                // and the String equals method:
                else if(quiz2.get(i).getQuestionPhrase().equals(quiz2.get(j).getQuestionPhrase()) && i != j)
                {
                    test2 = false;
                }
            }
        }
        //Quiz 3
        for (int i = 0; i < 20; i++) 
        {
            for (int j = 0; j < 20; j++)
            {
                // Check for repeats with the equals method from Question class:
                if (quiz3.get(i).equals(quiz3.get(j)) && i != j)
                   test1 = false;
                // Check for repeats with the getQuestion method from Question class
                // and the String equals method:
                else if(quiz3.get(i).getQuestionPhrase().equals(quiz3.get(j).getQuestionPhrase()) && i != j)
                {
                    test2 = false;
                }
            }
        }
        //Quiz 4
        for (int i = 0; i < 12; i++) 
        {
            for (int j = 0; j < 12; j++)
            {
                // Check for repeats with the equals method from Question class:
                if (quiz4.get(i).equals(quiz4.get(j)) && i != j)
                   test1 = false;
                // Check for repeats with the getQuestion method from Question class
                // and the String equals method:
                else if(quiz4.get(i).getQuestionPhrase().equals(quiz4.get(j).getQuestionPhrase()) && i != j)
                {
                    test2 = false;
                }
            }
        }
        assertTrue(test1 && test2);
        
        System.out.println(quiz1);
        System.out.println(quiz2);
    }
    
    /**
     * The test2 method checks that the isRight method from the question class 
     * works as intended. 
     */
    @Test
    public void test2() {
        // Make a generic list of answers
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("A");
        answers.add("B");
        answers.add("C");
        answers.add("D");
        
        // Make a question bank with 20 questions. Answer to the questions 
        // will follow the pattern a, b, c, d, a, b, c, d... 
        QuestionBank questions = new QuestionBank();
        int[] answerChoices = {0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3};
        for (int i = 0; i < answerChoices.length; i++)
        {
            questions.add(new Question("What is the answer to q" + (i + 1) + "?", answers, answerChoices[i]));
        }

               
        // Test 1
        Boolean test1 = true;
        
        for (int i = 0; i < questions.size(); i++) 
        {
            if (!questions.get(i).isRight(answerChoices[i]))
            {
                test1 = false;
            }
        }
        assertTrue(test1);
        
    }
    

    /**
     * The test3 method checks that the check method from the Quiz
     * class works as intended.
     */
    @Test
    public void test3() {
        // Make a generic list of answers
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("A");
        answers.add("B");
        answers.add("C");
        answers.add("D");
        
        // Make a question bank with 20 questions. Answer to the questions 
        // will follow the pattern a, b, c, d, a, b, c, d... 
        QuestionBank questions = new QuestionBank();
        int[] answerChoices = {0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3};
        for (int i = 0; i < answerChoices.length; i++)
        {
            questions.add(new Question("What is the answer to q" + (i + 1) + "?", answers, answerChoices[i]));
        }

        // Make 4 new quizzes
        Quiz quiz1 = new Quiz("Person", "1", questions, 5);
        Quiz quiz2 = new Quiz("Person", "2", questions, 8);
        Quiz quiz3 = new Quiz("Person", "3", questions, 20);
        Quiz quiz4 = new Quiz("Person", "4", questions, 12);
        
        // Test 1: assume true until otherwise determined false
        Boolean test1 = true;
        ArrayList<Integer> choices = new ArrayList<Integer>();
        int manualScore = 0;
        int calculatedScore = 0;
        //Quiz 1
        for (int i = 0; i < 5; i++) 
        {
            choices.add((int) (Math.random() * 4));
            if (quiz1.get(i).isRight(choices.get(i)))
                manualScore++;
            
        }
        calculatedScore = quiz1.check(choices);
        test1 = manualScore == calculatedScore;
        
        assertTrue(test1);
        
        System.out.println(choices);
        System.out.println(quiz1.getResults());
        System.out.println(quiz1.getCorrectAnswers());
        
    }
    
}
