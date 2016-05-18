package ua.goit.calculator.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ua.goit.calculator.entity.Calculation;
import ua.goit.calculator.service.CalculationService;
import ua.goit.calculator.utils.InfixToPostfix;
import ua.goit.calculator.utils.PostfixEvaluator;

@ManagedBean
@ViewScoped
public class CalculationListController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String zero = "0";
	private String one = "1";
	private String two = "2";
	private String three = "3";
	private String four = "4";
	private String five = "5";
	private String six = "6";
	private String seven = "7";
	private String eight = "8";
	private String nine = "9";
	private String divide = "/";
	private String multiply = "*";
	private String plus = "+";
	private String minus = "-";
	private String dot = ".";
	private String pow = "^";
	private String leftBracket = "(";
	private String rightBracket = ")";
	private String clear = "";
	private String backspace = "";

	private String resultExpression = "";

	@ManagedProperty("#{calculationService}")
	private CalculationService calculationService;

	private List<Calculation> calculations;
	private Calculation calculation = new Calculation();

	@PostConstruct
	private void loadCalculation() {
		calculations = calculationService.findAll();

	}

	public void save(Calculation calculation) {
		calculationService.save(calculation);		
		calculations = calculationService.findAll();
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", null));
	}

	public void remove(Calculation calculation) {
		calculationService.remove(calculation);
		calculations = calculationService.findAll();
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Removed", null));
	}

	public void eval() {
		InfixToPostfix postfixExpression = new InfixToPostfix();
		String infixString = getResultExpression();
		String postfixString = postfixExpression.convertToPostfix(infixString);

		PostfixEvaluator postfixEvaluator = new PostfixEvaluator();
		Double res;
		try {
			res = postfixEvaluator.evaluate(postfixString);

			setResultExpression(res.toString());

			calculation = new Calculation();
			calculation.setInfixExpression(infixString);
			calculation.setPostfixExpression(postfixString);
			calculation.setAnswer(res.toString());
			if (infixString.length() > 2) {
				save(calculation);
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrect expression", null));

		}

		// return getResultExpression();

	}

	// ******************************************************** GETTER AND SETTER ********************

	public CalculationService getCalculationService() {
		return calculationService;
	}

	public void setCalculationService(CalculationService calculationService) {
		this.calculationService = calculationService;
	}

	public List<Calculation> getCalculations() {
		return calculations;
	}

	public void setCalculations(List<Calculation> calculations) {
		this.calculations = calculations;
	}

	public Calculation getCalculation() {
		return calculation;
	}

	public void setCalculation(Calculation calculation) {
		this.calculation = calculation;
	}

	// *********************** GETTER AND SETTER FOR CALCULATOR BUTTON *************

	public String getZero() {
		return zero;
	}

	public void setZero(String zero) {
		this.zero = zero;
	}

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	public String getThree() {
		return three;
	}

	public void setThree(String three) {
		this.three = three;
	}

	public String getFour() {
		return four;
	}

	public void setFour(String four) {
		this.four = four;
	}

	public String getFive() {
		return five;
	}

	public void setFive(String five) {
		this.five = five;
	}

	public String getSix() {
		return six;
	}

	public void setSix(String six) {
		this.six = six;
	}

	public String getSeven() {
		return seven;
	}

	public void setSeven(String seven) {
		this.seven = seven;
	}

	public String getEight() {
		return eight;
	}

	public void setEight(String eight) {
		this.eight = eight;
	}

	public String getNine() {
		return nine;
	}

	public void setNine(String nine) {
		this.nine = nine;
	}

	public String getDivide() {
		return divide;
	}

	public void setDivide(String divide) {
		this.divide = divide;
	}

	public String getMultiply() {
		return multiply;
	}

	public void setMultiply(String multiply) {
		this.multiply = multiply;
	}

	public String getPlus() {
		return plus;
	}

	public void setPlus(String plus) {
		this.plus = plus;
	}

	public String getMinus() {
		return minus;
	}

	public void setMinus(String minus) {
		this.minus = minus;
	}

	public String getDot() {
		return dot;
	}

	public void setDot(String dot) {
		this.dot = dot;
	}

	public String getPow() {
		return pow;
	}

	public void setPow(String pow) {
		this.pow = pow;
	}

	public String getLeftBracket() {
		return leftBracket;
	}

	public void setLeftBracket(String leftBracket) {
		this.leftBracket = leftBracket;
	}

	public String getRightBracket() {
		return rightBracket;
	}

	public void setRightBracket(String rightBracket) {
		this.rightBracket = rightBracket;
	}

	public String getClear() {
		return clear;
	}

	public void setClear(String clear) {
		this.clear = clear;
	}

	public String getBackspace() {
		return backspace;
	}

	public void setBackspace(String backspace) {
		this.backspace = backspace;
	}

	public String getResultExpression() {
		return resultExpression;
	}

	public void setResultExpression(String result) {
		this.resultExpression = result;
	}

	// ******************************METHODS SET DIGIT INTO EDIT****************

	public void addToEditZero() {
		setResultExpression(getResultExpression() + getZero());
	}

	public void addToEditOne() {
		setResultExpression(getResultExpression() + getOne());
	}

	public void addToEditTwo() {
		setResultExpression(getResultExpression() + getTwo());
	}

	public void addToEditThree() {
		setResultExpression(getResultExpression() + getThree());
	}

	public void addToEditFour() {
		setResultExpression(getResultExpression() + getFour());
	}

	public void addToEditFive() {
		setResultExpression(getResultExpression() + getFive());
	}

	public void addToEditSix() {
		setResultExpression(getResultExpression() + getSix());
	}

	public void addToEditSeven() {
		setResultExpression(getResultExpression() + getSeven());
	}

	public void addToEditEight() {
		setResultExpression(getResultExpression() + getEight());
	}

	public void addToEditNine() {
		setResultExpression(getResultExpression() + getNine());
	}

	// ****************************METHODS SET OPERATOR INTO EDIT****************************
	public void addToEditDivide() {
		setResultExpression(getResultExpression() + getDivide());
	}

	public void addToEditMultiply() {
		setResultExpression(getResultExpression() + getMultiply());
	}

	public void addToEditPlus() {
		setResultExpression(getResultExpression() + getPlus());
	}

	public void addToEditMinus() {
		setResultExpression(getResultExpression() + getMinus());
	}

	public void addToEditDot() {
		setResultExpression(getResultExpression() + getDot());
	}

	public void addToEditPow() {
		setResultExpression(getResultExpression() + getPow());
	}

	public void addToEditLeftBracket() {
		setResultExpression(getResultExpression() + getLeftBracket());
	}

	public void addToEditRightBracket() {
		setResultExpression(getResultExpression() + getRightBracket());
	}

	public void addToEditClear() {
		setResultExpression("");
	}

	public void addToEditBackSpace() {
		setResultExpression(getResultExpression().substring(0,
				getResultExpression().length() - 1));
	}
	// ******************************************************************************************************************************

}
