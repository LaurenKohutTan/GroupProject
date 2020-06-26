# GroupProject

## QuestionBank
Smart Quiz is an application that makes multiple quizzes out of a single question bank of questions.
The web app would be used by the teacher for which they could randomly assign questions to each student in random order. 
This idea would make it much more difficult for students to share answers due to the fact that they would have a unique set of questions.

Right now, QuestionBank contains the following:

- Question class which makes question objects with the question text and an arraylist of answer choices.
- QuestionBank class which holds an arraylist of Question objects.
- Quiz class which takes a question bank and randomly chooses a specified number of questions to be added to a new arraylist of questions.

The classes run using a testing class which runs through a sample txt file with random test questions. For the next milestone we will incorporate Spring functionality.

## Data
The data project takes the Question class from the QuestionBank project and uses a CrudRepository to store question objects and chooses a random question to output.

## Demo
This project contains the files from tech exercise #2 and #4.

## gs-accessing-data-jpa-master
This project contains the files from tech exercise #3.




