package com.challenge.pplflwAssessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.pplflwAssessment.model.Employee;
import com.challenge.pplflwAssessment.model.enums.EmployeeState;
import com.challenge.pplflwAssessment.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/employees")
	Employee addEmployee(@RequestParam String name, @RequestParam String email, @RequestParam Integer yearsOfExperience,
			@RequestParam Integer age) {
		Employee employee = Employee.builder().name(name).email(email).yearsOfExperience(yearsOfExperience).age(age)
				.state(EmployeeState.ADDED).build();
		return service.save(employee);
	}

	@PostMapping("/employees/{id}/changeState")
	Employee changeEmplyeeState(@PathVariable("id") Long id, @RequestParam EmployeeState state) {

		Employee employee = service.findById(id);
		employee.setState(state);
		return service.save(employee);
	}

}
