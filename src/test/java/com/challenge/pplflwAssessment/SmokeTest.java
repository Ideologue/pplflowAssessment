package com.challenge.pplflwAssessment;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.pplflwAssessment.controller.EmployeeController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private EmployeeController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void applicationContextTest() {
		PplflwAssessmentApplication.main(new String[] {});
	}

}
