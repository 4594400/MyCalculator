package ua.goit.calculator.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.goit.calculator.entity.Calculation;
import ua.goit.calculator.repository.CalculationRepository;

@Service
public class InitDBService {

	@Autowired
	private CalculationRepository calculationRepository;

	@PostConstruct
	private void init() {
		System.out.println("START init DB");
		{
			Calculation calculation = new Calculation();
			calculation.setInfixExpression("2*(3+1)*3");
			calculation.setPostfixExpression("2 3 1 3 * + *");
			calculation.setAnswer("24");
			calculationRepository.save(calculation);
		}
		{
			Calculation calculation = new Calculation();
			calculation.setInfixExpression("7*(4+5)*3");
			calculation.setPostfixExpression("7 4 5 3 * + *");
			calculation.setAnswer("56");
			calculationRepository.save(calculation);
		}
		
		System.out.println("FINISH init DB");
	}
}
