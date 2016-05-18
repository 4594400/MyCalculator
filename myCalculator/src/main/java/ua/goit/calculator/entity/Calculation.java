package ua.goit.calculator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Calculation {
	
	@Id
	@GeneratedValue
	private int id;
	private String infixExpression;
	private String postfixExpression;
	private String answer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getInfixExpression() {
		return infixExpression;
	}
	public void setInfixExpression(String infixExpression) {
		this.infixExpression = infixExpression;
	}
	public String getPostfixExpression() {
		return postfixExpression;
	}
	public void setPostfixExpression(String postfixExpression) {
		this.postfixExpression = postfixExpression;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	

}
