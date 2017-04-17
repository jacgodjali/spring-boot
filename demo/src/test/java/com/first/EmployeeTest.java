package com.first;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new EmployeeController()).build();
	}
	
	@Test
	public void postGender() throws Exception {
	    this.mockMvc.perform(post("/employee").content("{\"gender\":\"male\"}").contentType("application/json")).andExpect(status().isOk());

	}
	
	@Test
	public void getGender() throws Exception {
	    String result = "[{\"gender\":\"male\"}]";
		
		this.mockMvc.perform(get("/employees?gender=male")).andExpect(content().json(result));
	}
}
