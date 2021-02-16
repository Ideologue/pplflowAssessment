package com.challenge.pplflwAssessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.challenge.pplflwAssessment.model.Employee;
import com.challenge.pplflwAssessment.model.enums.EmployeeState;
import com.challenge.pplflwAssessment.repository.EmployeeRepository;
import com.challenge.pplflwAssessment.service.EmployeeService;
import com.challenge.pplflwAssessment.service.impl.EmployeeServiceImpl;

public class EmployeeServiceTests {

	@InjectMocks
	EmployeeServiceImpl service;

	@Mock
	EmployeeRepository repo;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void getEmployeeByIdTest() {
		when(repo.findById(1L)).thenReturn(Optional.of( new Employee(1L, "Lokesh", "user@email.com",18,40 ,EmployeeState.ACTIVE)));

		Employee emp = service.findById(1L);

		assertEquals("Lokesh", emp.getName());
		assertEquals("user@email.com", emp.getEmail());
	}

	@Test
	public void createEmployeeTest() {
		Employee emp = new Employee(1L, "Lokesh", "user@email.com",18,40 ,EmployeeState.ACTIVE);

		service.save(emp);

		verify(repo, times(1)).save(emp);
	}

}
