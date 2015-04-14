package com.security.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "security_check")
public class Security {
	@Id
	@Column(name = "psid")
	@GeneratedValue
	private int psid;
	
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "user_title")
	private String user_title;
	
	@Column(name = "question1")
	private String question1;

	@Column(name = "question2")
	private String question2;

	@Column(name = "question3")
	private String question3;

	@Column(name = "answer1")
	private String answer1;
	@Column(name = "answer2")
	private String answer2;
	@Column(name = "answer3")
	private String answer3;
	
	@Transient
	public String hasQuestion;
	
	public int getPsid() {
		return psid;
	}

	public void setPsid(int psid) {
		this.psid = psid;
	}

	

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_title() {
		return user_title;
	}

	public void setUser_title(String user_title) {
		this.user_title = user_title;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
}
