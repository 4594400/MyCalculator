package ua.goit.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.goit.calculator.entity.Calculation;

public interface CalculationRepository extends JpaRepository<Calculation, Integer>{

}
