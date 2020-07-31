# GroupProject

## SpringbootThymeleafForm
Smart Quiz is an application that makes multiple quizzes out of a single question bank of questions.
The web app would be used by the teacher for which they could randomly assign questions to each student in random order. 
This idea would make it much more difficult for students to share answers due to the fact that they would have a unique set of questions.

This package runs as a Spring boot application. Right now, QuestionBank contains the following:

- Question class which makes question objects with the question text and an arraylist of answer choices.
- QuestionBank class which holds an arraylist of Question objects.
- Quiz class which takes a question bank and randomly chooses a specified number of questions to be added to a new arraylist of questions.
- Testing class which runs through a sample txt file with random test questions. For simple testing only.
- User class which represents a system user (teacher or student) takes input from an HTML form and saves it in a database.
- Output class contains a User and Quiz object which then can be used to output the quiz questions for the specific user on the webpage.
- MainController class that handles the HTTP GET and POST requests.
- QuestionRepository - an interface that extends CrudRepository which holds Question objects and corresponds to the Question sql database.
- UserRepository - an interface that extends CrudRepository which holds User objects and corresponds to the User sql database.
- OutputRepository - an interface that extends CrudRepository which holds Output objects and corresponds to the Output sql database.
- QuizTest - a Junit test class which tests the methods in the Quiz class.


## Data
The data project takes the Question class from the QuestionBank project and uses a CrudRepository to store question objects and chooses a random question to output.

## Demo
This project contains the files from tech exercise #2 and #4.

## gs-accessing-data-jpa-master
This project contains the files from tech exercise #3.




