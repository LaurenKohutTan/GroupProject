package net.javaguides.springboot.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Output;
import net.javaguides.springboot.model.Question;
import net.javaguides.springboot.repository.QuestionRepository;


@Controller
@RequestMapping(value= "/create")
public class QuestionController {

	@Autowired
	QuestionRepository questionRepository;
	/*
	@PostMapping(value = "/all")
	public List<Question> getAll() {
		
		return questionRepository.findAll();
		
		}
	/*
	@GetMapping("/create")
    public String makeForm(Model model2) {
		
		//Output output2 = new Output();
       // model2.addAttribute("output2", output2);
		
		Question question = new Question();
	    model2.addAttribute("question", question); 
		
        return "create";
    }
*/
	
	/*
	@PostMapping(value= "/load")
	public List<Question> persist(@RequestBody final Question question) {
		questionRepository.save(question);
		return questionRepository.findAll();
		
	}
	*/
	
	 
	 
	
}
