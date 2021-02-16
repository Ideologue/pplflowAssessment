package com.challenge.pplflwAssessment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.challenge.pplflwAssessment.controller.EmployeeController;
import com.challenge.pplflwAssessment.model.Employee;
import com.challenge.pplflwAssessment.model.enums.EmployeeState;
import com.challenge.pplflwAssessment.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
//@AutoConfigureMockMvc
public class EmployeeControllerTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private WebApplicationContext context;

	// @Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeService service;

	@BeforeEach
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	Employee resource = Employee.builder().id(1000L).name("mohammed").email("a@a.a").yearsOfExperience(18).age(40)
			.state(EmployeeState.ADDED).build();
	Employee resource2 = Employee.builder().id(1000L).name("mohammed").email("a@a.a").yearsOfExperience(18).age(40)
			.state(EmployeeState.APPROVED).build();

	@Test
	public void addEmployeeTest() throws Exception {

		Mockito.when(service.save(Mockito.any())).thenReturn(resource);

		MvcResult mvcResult = mvc
				.perform(post("/employees").contentType(MediaType.MULTIPART_FORM_DATA).param("name", "mohammed")
						.param("id", "1000").param("email", "a@a.a").param("yearsOfExperience", "18")
						.param("state", "ADDED").param("age", "40").param("state", "ADDED"))
				.andDo(print()).andExpect(status().isOk()).andReturn();

		String actualResponseBody = mvcResult.getResponse().getContentAsString();

		assertThat(actualResponseBody).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(resource));

	}

	@Test
	public void changeEmployeeStateTest() throws Exception {

		Mockito.when(service.findById(Mockito.any())).thenReturn(resource);
		Mockito.when(service.save(Mockito.any())).thenReturn(resource2);
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.post("/employees/{id}/changeState", 1000)
						.contentType(MediaType.MULTIPART_FORM_DATA).param("state", "APPROVED"))
				.andDo(print()).andExpect(status().isOk()).andReturn();

		String actualResponseBody = mvcResult.getResponse().getContentAsString();

		assertThat(actualResponseBody).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(resource2));

	}

}
