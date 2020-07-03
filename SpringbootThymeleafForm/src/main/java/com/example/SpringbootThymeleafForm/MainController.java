package com.example.SpringbootThymeleafForm;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
 
@Controller
public class MainController {
	 @GetMapping("/register")
	    public String showForm(Model model) {
	        User user = new User();
	        ArrayList<String> answers = new ArrayList<String>();
	        answers.add("answer A");
	        answers.add("answer B");
	        answers.add("answer C");
	        answers.add("answer D");
	        
	        Question q1 = new Question("Question 1?", answers);
	        model.addAttribute("user", user);
	        model.addAttribute("question", q1);
	         
	      
	         
	        return "register_form";
	    }
	 @PostMapping("/register")
	 public String submitForm(@ModelAttribute("user") User user) {
	     System.out.println(user);
	     return "register_success";
	 }
}
