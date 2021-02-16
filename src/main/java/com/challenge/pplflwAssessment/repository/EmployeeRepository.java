package com.challenge.pplflwAssessment.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.challenge.pplflwAssessment.model.Employee;

@Repository
public interface EmployeeRepository  extends PagingAndSortingRepository<Employee, Long> {

}
