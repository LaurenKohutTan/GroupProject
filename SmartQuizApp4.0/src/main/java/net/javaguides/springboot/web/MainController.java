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

/**
 * The MainController class handles the http get and post requests
 * @author QuestionBankGroup
 * @param quiz the quiz object tied to the output
 * @param outputRepository the respoitory of output objects from the sql database
 * @param questionRepository the respoitory of question objects from the sql database
 *
 */
@Controller
public class MainController {
	
	Quiz quiz;
	
	@Autowired
	OutputRepository outputRepository;
	
	@Autowired
	QuestionRepository questionRepository;
	
	/**
	 * Method that handles the login page
	 * @return login the login.html page
	 */
	@GetMapping("/login")
	public String login() {
		System.out.println("LOGIN PAGE");
		return "login";
	}
	
	/**
	 * Method that handles get mapping for the home page
	 * @return the index.html page
	 */
	@GetMapping("/")
	public String home() {
		System.out.println("GETMAPPING INDEX PAGE");
		return "index";
	}
	
	/**
	 * Method that handles get mapping for the create page
	 * @param model the ui model object
	 * @return the create.html page
	 */
	@GetMapping("/create")
    public String makeForm(Model model) {
		
		System.out.println("GETMAPPING CREATE PAGE");
		Question question = new Question();
	    model.addAttribute("question", question); 
		
        return "create";
    }
	
	/**
	 * Method that handles get mapping for the record page
	 * @param model the ui model object
	 * @return the record.html page
	 */
	@GetMapping("/record")
	public String showRecord(Model model) {
		List<Output> listOutputs = outputRepository.findAll();
		System.out.println(listOutputs);
	    model.addAttribute("listOutputs", listOutputs);
		return "record";
	}
	
	/**
	 * Method that handles get mapping for the assessment page
	 * @param model the ui model object
	 * @return the assessment.html page
	 */
	@GetMapping("/assessment")
    public String showAssessment(Model model) {
		
		System.out.println("GETMAPPING ASSESSMENT PAGE");
		Output output = new Output(questionRepository.findAll());
		
		System.out.println(questionRepository.findAll());
        model.addAttribute("output", output);
        quiz = output.getQuiz();
         
        return "assessment";
    }
	
	
	/**
	 * Method that handles post mapping for the assessment page
	 * @param output the output object from the model
	 * @return
	 */
	@PostMapping("/register")
	 public String submitAssessment(@ModelAttribute("output") Output output) {
		System.out.println("POST REGISTER PAGE");
		
		// Store the answers chosen in a list for checking:
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(getNumber(output.getAnswerChosen1()));
		ans.add(getNumber(output.getAnswerChosen2()));
		ans.add(getNumber(output.getAnswerChosen3()));
		ans.add(getNumber(output.getAnswerChosen4()));
		
		// Check the answers given:
	    output.setScore(quiz.check(ans));
		outputRepository.save(output);
		
		// For testing
		System.out.println(quiz.getCorrectAnswers());
		System.out.println(ans);
		System.out.println(output.getScore());	
			
	     return "submission_success";   
	 }

	/**
	 * Method that converts a letter answer into a corresponding index value
	 * @param ans the letter chosen
	 * @return the integer which corresponds to the letter
	 */
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
	
	/**
	 * Method that handles post mapping for the create page
	 * @param question the question object from the model
	 * @return the index.html page
	 */
	@PostMapping("/create") 
	 public String registerQuestion(@ModelAttribute("question") Question question) {
	 questionRepository.save(question); 

	 return "index"; }
	
}
