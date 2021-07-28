package com.abdullah.main.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.abdullah.main.model.Question;
import com.abdullah.main.model.QuestionForm;
import com.abdullah.main.model.Result;
import com.abdullah.main.repository.QuestionRepo;
import com.abdullah.main.repository.ResultRepo;

@Service
public class QuizService {

	@Autowired
	Question question;

	@Autowired
	QuestionForm qFrom;

	@Autowired
	QuestionRepo qRepo;

	@Autowired
	Result result;

	@Autowired
	ResultRepo rRepo;

	private int num = 5;

	// random Questions
	public QuestionForm getQuestions(int userNumber) {
		
		

		List<Question> allQues = qRepo.findAll();
		List<Question> qList = new ArrayList<Question>();

		if (userNumber < 1 || userNumber > allQues.size()) {
			num = allQues.size()/2;
			
		} else {
			num = userNumber;
		}

		Random random = new Random();

		for (int i = 0; i < num; i++) {
			try {
				int rand = random.nextInt(allQues.size());
				qList.add(allQues.get(rand));
				allQues.remove(rand);
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e);
			}
		}

		qFrom.setQuestions(qList);
		return qFrom;
	}

	// count result
	public int getResult(QuestionForm qForm) {
		int correct = 0;

		for (Question q : qForm.getQuestions()) {
			if (q.getAns() == q.getChose()) {
				correct++;
			}
		}

		return correct;
	}

	// save to DB
	public void saveScore(Result result) {

		Result saveResult = new Result();

		saveResult.setUsername(result.getUsername());
		saveResult.setTotalCorrect(result.getTotalCorrect());
		saveResult.setTotalAttempt(result.getTotalAttempt());
		saveResult.setTotalWrong(result.getTotalWrong());

		rRepo.save(saveResult);

	}

	// return topper's
	public List<Result> getTopScore() {
		List<Result> sList = rRepo.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));
		return sList;
	}
	
	public int  getNumQs() {
		return num;
	}
	
	public void  settNumQs(int num) {
		this.num = num;
	}

}
