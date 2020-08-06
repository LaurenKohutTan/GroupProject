package net.javaguides.springboot.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.javaguides.springboot.model.Output;
import net.javaguides.springboot.model.Question;
import net.javaguides.springboot.model.Quiz;
import net.javaguides.springboot.repository.OutputRepository;
import net.javaguides.springboot.repository.QuestionRepository;

@Controller
public class MainController {
	
	Quiz quiz;
	
	@Autowired
	OutputRepository outputRepository;
	
	@Autowired
	QuestionRepository questionRepository;
	
	@GetMapping("/login")
	public String login() {
		System.out.println("LOGIN PAGE");
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		System.out.println("GETMAPPING INDEX PAGE");
		return "index";
	}
	
	@GetMapping("/create")
    public String makeForm(Model model) {
		
		System.out.println("GETMAPPING CREATE PAGE");
		Question question = new Question();
	    model.addAttribute("question", question); 
		
        return "create";
    }
	
	@GetMapping("/record")
	public String showRecord(Model model) {
		List<Output> listOutputs = outputRepository.findAll();
		System.out.println(listOutputs);
	    model.addAttribute("listOutputs", listOutputs);
		return "record";
	}
	
	@GetMapping("/assessment")
    public String showAssessment(Model model) {
		
		System.out.println("GETMAPPING ASSESSMENT PAGE");
		Output output = new Output(questionRepository.findAll());
		
		System.out.println(questionRepository.findAll());
        model.addAttribute("output", output);
        quiz = output.getQuiz();
         
        return "assessment";
    }
	
	
	@PostMapping("/register")
	 public String submitAssessment(@ModelAttribute("output") Output output) {
		System.out.println("POST REGISTER PAGE");
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		ans.add(getNumber(output.getAnswerChosen1()));
		ans.add(getNumber(output.getAnswerChosen2()));
		ans.add(getNumber(output.getAnswerChosen3()));
		ans.add(getNumber(output.getAnswerChosen4()));
		
		
	    output.setScore(quiz.check(ans));
		outputRepository.save(output);
		System.out.println(output.getScore());	
			
	     return "submission_success";   
	 }

	public int getNumber(String ans) {
		if (ans.equalsIgnoreCase("A"))
			return 0;
		else if (ans.equalsIgnoreCase("B"))
			return 1;
		else if (ans.equalsIgnoreCase("C"))
			return 2;
		else { 
			return 3;
		}
	}
	
	@PostMapping("/create") 
	 public String registerQuestion(@ModelAttribute("question") Question question) {
	 questionRepository.save(question); 
	 //for (Question q : questionRepository.findAll())
	 //System.out.println(q);
	 return "index"; }
	
}
