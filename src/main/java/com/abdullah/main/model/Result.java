package com.abdullah.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "results")
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private int totalCorrect = 0;
	private int totalWrong = 0;
	private int totalAttempt = 0;

	public Result() {
		super();
	}

	public Result(int id, String username, int totalCorrect, int totalWrong, int totalAttempt) {
		super();
		this.id = id;
		this.username = username;
		this.totalCorrect = totalCorrect;
		this.totalWrong = totalWrong;
		this.totalAttempt = totalAttempt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getTotalCorrect() {
		return totalCorrect;
	}

	public void setTotalCorrect(int totalCorrect) {
		this.totalCorrect = totalCorrect;
	}

	public int getTotalWrong() {
		return totalWrong;
	}

	public void setTotalWrong(int totalWrong) {
		this.totalWrong = totalWrong;
	}

	public int getTotalAttempt() {
		return totalAttempt;
	}

	public void setTotalAttempt(int totalAttempt) {
		this.totalAttempt = totalAttempt;
	}

	

	
}
