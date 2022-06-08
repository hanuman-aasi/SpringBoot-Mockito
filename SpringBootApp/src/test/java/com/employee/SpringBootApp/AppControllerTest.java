package com.employee.SpringBootApp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.management.modelmbean.XMLParseException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.employee.SpringBootApp.controller.AppController;
import com.employee.SpringBootApp.model.Employee;
import com.employee.SpringBootApp.repository.EmployeeRepository;
import com.employee.SpringBootApp.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


@RunWith(SpringRunner. class)
@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerTest {
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
    private EmployeeService service;
	
	@Test
	public void addTest() throws Exception {
		Employee emp = new Employee(1,"hanuma","dev");
		String inputInXml = this.mapToXml(emp);
		
		String URI = "/addEmployee";
		
		Mockito.when(service.addEmployee(Mockito.any(Employee.class))).thenReturn(emp);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_XML_VALUE).content(inputInXml)
				.contentType(MediaType.APPLICATION_XML_VALUE);

		MvcResult result = mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInXml = response.getContentAsString();
		
		assertThat(outputInXml).isEqualTo(inputInXml);
		assertEquals(HttpStatus.OK.value(), response.getStatus());		
	}
	
	@Test
	public void getAllTest() throws Exception {
		
				Employee e1 = new Employee(1,"emp1","Lead");
				Employee e2 = new Employee(2,"emp2","Dev");
				Employee e3 = new Employee(3,"emp3","test");
				List<Employee> employees = new ArrayList<>();
				employees.add(e1);
				employees.add(e2);
				employees.add(e3);
		Mockito.when(service.getEmployees()).thenReturn((ArrayList<Employee>) employees);
		String URI = "/getEmployeesList";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_XML_VALUE);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		String expectedXml = this.mapToXml(employees);
		String outputInXml = result.getResponse().getContentAsString();
		assertThat(outputInXml).isEqualTo(expectedXml);
	}
	
	private String mapToXml (Object object) throws Exception {
		ObjectMapper om = new XmlMapper();
		return om.writeValueAsString(object);
	}
	
	

}
