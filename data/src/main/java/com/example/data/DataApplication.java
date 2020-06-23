package com.example.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;

@SpringBootApplication
public class DataApplication {

  private static final Logger log = LoggerFactory.getLogger(DataApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(DataApplication.class);
  }

  @Bean
  public CommandLineRunner demo(QuestionRepository repository) {
    return (args) -> {
      // save a few customers
      ArrayList<String> answers = new ArrayList<String>();
      answers.add("answer 1");
      answers.add("answer 2");
      answers.add("answer 3");
      answers.add("answer 4");
      repository.save(new Question("What is the answer to question 1?", answers));
      repository.save(new Question("What is the answer to question 2?", answers));
      repository.save(new Question("What is the answer to question 3?", answers));
      repository.save(new Question("What is the answer to question 4?", answers));
      repository.save(new Question("What is the answer to question 5?", answers));

      // fetch an individual customer by ID
      int rand = (int) (Math.random()*repository.count()) + 1;
      Question question;
      log.info("" + rand);
      if (rand == 1)
    	  question = repository.findById(1L);
      else if (rand == 2)
    	  question = repository.findById(2L);
      else if (rand == 3)
    	  question = repository.findById(3L);
      else if (rand == 4)
    	  question = repository.findById(4L);
      else
    	  question = repository.findById(5L);
      log.info("Customer found with findById(" + rand + "L):");
      log.info("--------------------------------");
      log.info("\n" + question.toString());
      log.info("\n" + question.answersIndent());
      log.info("");

    };
  }

}