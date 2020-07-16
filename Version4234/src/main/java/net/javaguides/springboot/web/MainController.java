package net.javaguides.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springboot.model.Output;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/createAss")
    public String makeForm(Model model2) {
		
		Output output2 = new Output();
        model2.addAttribute("output2", output2);
         
        return "create";
    }
	
	@GetMapping("/register")
    public String showForm(Model model) {
		
		Output output = new Output();
        model.addAttribute("output", output);
         
        return "assessment";
    }
	
	@PostMapping("/register")
	 public String submitForm(@ModelAttribute("output") Output output) {
	     System.out.println(output);
	     
	     return "submission_success"; 
	 }
	
}
