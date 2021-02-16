package com.challenge.pplflwAssessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.pplflwAssessment.model.Employee;
import com.challenge.pplflwAssessment.repository.EmployeeRepository;
import com.challenge.pplflwAssessment.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);

	}

	@Override
	public Employee findById(Long id) {
		return employeeRepository.findById(id).get();
	}

}
