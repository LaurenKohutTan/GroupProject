package net.javaguides.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springboot.model.Output;
import net.javaguides.springboot.model.Question;
import net.javaguides.springboot.repository.OutputRepository;
import net.javaguides.springboot.repository.QuestionRepository;

@Controller
public class MainController {
	
	@Autowired
	OutputRepository outputRepository;
	
	@Autowired
	QuestionRepository questionRepository;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/create")
    public String makeForm(Model model2) {
		
		//Output output2 = new Output();
       // model2.addAttribute("output2", output2);
		
		Question question = new Question();
	    model2.addAttribute("question", question); 
		
        return "create";
    }
	
	@GetMapping("/assessment")
    public String showForm(Model model) {
		
		Output output = new Output();
		
        model.addAttribute("output", output);
         
        return "assessment";
    }
	
	@PostMapping("/register")
	 public String submitForm(@ModelAttribute("output") Output output) {
	     System.out.println(output);
	     outputRepository.save(output);
	     return "submission_success"; 
	 }
	
	@PostMapping("/create") 
	 public String registerQuestion(@ModelAttribute("question") Question question) {
	 questionRepository.save(question); 
	 for (Question q : questionRepository.findAll())
	 System.out.println(q);
	 return "create"; }
	
}
