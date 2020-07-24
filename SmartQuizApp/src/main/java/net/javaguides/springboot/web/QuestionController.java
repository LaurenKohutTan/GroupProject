package net.javaguides.springboot.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Question;
import net.javaguides.springboot.repository.QuestionRepository;
import net.javaguides.springboot.web.dto.QuestionRegistrationDto;


@RestController
@RequestMapping(value= "/create")
public class QuestionController {

	@Autowired
	QuestionRepository questionRepository;
	
	
	@ModelAttribute("question")
    public QuestionRegistrationDto questionRegistrationDto() {
        return new QuestionRegistrationDto();
    }
	
	@GetMapping(value= "/all")
	public List<Question> getAll() {

		
		
		return questionRepository.findAll();
		
		
		}
	/*
	@PostMapping(value= "/load")
	public List<Question> persist(@RequestBody final Question question) {
		questionRepository.save(question);
		return questionRepository.findAll();
		
	}
	*/
	@PostMapping
	public String registerQuestion(@ModelAttribute("question") QuestionRegistrationDto registrationDto) {
		questionRepository.save(registrationDto);
		return "index";
	}
	
	
}
