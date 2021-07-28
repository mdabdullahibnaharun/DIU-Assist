package com.abdullah.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.abdullah.main.model.QuestionForm;
import com.abdullah.main.model.Result;
import com.abdullah.main.service.QuizService;

@Controller
public class MainController {

	@Autowired
	Result result;

	@Autowired
	QuizService qService;

	Boolean isSubmitted = false;
	
	int numOfQues;

	@GetMapping("/")
	public String home() {
		return "index.html";
	}

	@PostMapping("/quiz")
	public String quiz(@RequestParam String username,@RequestParam String userNumber, Model m, RedirectAttributes ra) {
		if (username.equals("")) {
			ra.addFlashAttribute("nameWarning", "You must Enter Your Name");
			return "redirect:/";
		}
		if(userNumber.equals("") || !(userNumber.matches(".*\\d.*"))) {
			ra.addFlashAttribute("numberWarning","You Must Enter A Valid Number");
			return "redirect:/";
		}

		isSubmitted = false;
		result.setUsername(username);
		
		numOfQues = Integer.parseInt(userNumber);

		QuestionForm qForm = qService.getQuestions(numOfQues);
		m.addAttribute("qForm", qForm);

		return "quiz.html";
	}
	
	
	@PostMapping("/submit")
	public String submit(@ModelAttribute QuestionForm qForm, Model m) {
		
		numOfQues = qService.getNumQs();
		
		if(!isSubmitted) {
			result.setTotalCorrect(qService.getResult(qForm));
			result.setTotalWrong(Math.abs(numOfQues-qService.getResult(qForm)));
			result.setTotalAttempt(numOfQues);
			qService.saveScore(result);
			isSubmitted = true;
		}
		
		return "result.html";
	}

	@GetMapping("/score")
	public String score(Model m) {
		List<Result> sList = qService.getTopScore();
		m.addAttribute("sList" ,sList);
		
		return "scoreboard.html";
	}
	
	@ModelAttribute("result")
	public Result getResult() {
		return result;
	}

}
