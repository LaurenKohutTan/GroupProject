package com.example.SpringbootThymeleafForm;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
 
@Controller
public class MainController {
	 @GetMapping("/register")
	    public String showForm(Model model) {
	        
	        Output output = new Output();
	        model.addAttribute("output", output); 
	        	             
	        return "register_form";
	    }
	 @PostMapping("/register")
	 public String submitForm(@ModelAttribute("output") Output output) {
	     System.out.println(output);
	     return "register_success"; 
	 }
}

