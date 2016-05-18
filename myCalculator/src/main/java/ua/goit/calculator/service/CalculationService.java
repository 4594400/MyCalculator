package ua.goit.calculator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.goit.calculator.entity.Calculation;
import ua.goit.calculator.repository.CalculationRepository;

@Service
public class CalculationService {

	@Autowired
	private CalculationRepository calculationRepository;
	
	public List<Calculation> findAll() {
		return calculationRepository.findAll();
	}

	public void save(Calculation calculation) {
		calculationRepository.save(calculation);
		
	}

	public void remove(Calculation calculation) {
		calculationRepository.delete(calculation);
		
	}
}
