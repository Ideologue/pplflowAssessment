package com.challenge.pplflwAssessment.service;

import com.challenge.pplflwAssessment.model.Employee;

public interface EmployeeService {
	Employee save(Employee e);
	Employee findById(Long id);
	
}
