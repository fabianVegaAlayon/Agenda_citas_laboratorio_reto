package com.sophos.Agenda_citas_laboratorio.controllersTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.Arrays;
import java.util.List;

import org.aopalliance.intercept.Invocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sophos.Agenda_citas_laboratorio.Datos;
import com.sophos.Agenda_citas_laboratorio.controllersImpl.TestControllerImpl;
import com.sophos.Agenda_citas_laboratorio.entities.TestL;
import com.sophos.Agenda_citas_laboratorio.service.TestService;

@WebMvcTest(TestControllerImpl.class)
class TestControllerImplTest {
	@Autowired
	private MockMvc testMockMvc;

	@MockBean
	private TestService testService;

	ObjectMapper objectMapper;
	Invocation invocation;

	@BeforeEach
	void setUp() {
		objectMapper = new ObjectMapper();

	}

	@Test
	void testGetAById() throws Exception {
		when(testService.getById(1)).thenReturn(Datos.createTest());
		testMockMvc.perform(get("/test/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name").value("Test Sangre"))
				.andExpect(jsonPath("$.description").value("Es el test de sangre"));
		verify(testService, times(3)).getById(1);
	}

	@Test
	void testGetAList() throws JsonProcessingException, Exception {
		System.out.println("testGetAList");
		List<TestL> test = Arrays.asList(Datos.createTest().orElseThrow(), Datos.createTestNumbTwo().orElseThrow());
		when(testService.getList()).thenReturn(test);

		testMockMvc.perform(get("/tests").contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].name").value("Test Sangre"))
				.andExpect(jsonPath("$[1].name").value("Test Horina")).andExpect(jsonPath("$[0].id").value("1"))
				.andExpect(jsonPath("$[1].id").value("2"))
				.andExpect(jsonPath("$[0].description").value("Es el test de sangre"))
				.andExpect(jsonPath("$[1].description").value("Es el test de Horina"))
				.andExpect(content().json(objectMapper.writeValueAsString(test)));
		verify(testService, times(3)).getList();
		assertEquals(2, test.size());
	}

	@Test
	void testPostA() {
		try {
			TestL test = new TestL(2, "Test Horina", "Es el test de Horina");

			given(testService.post(test)).willReturn(Datos.newTest());

			testMockMvc.perform(post("/test/add" + "?id=" + test.getId() + "&name=" + test.getName() + "&description="
					+ test.getDescription())

					.content(objectMapper.writeValueAsString(test)).contentType(MediaType.APPLICATION_JSON));

			assertEquals("Test Horina", test.getName());

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	

	@Test
	void testPut() {
		System.out.println("testPutA()");
		try {
			TestL test = new TestL();
			test.setId(2);
			test.setName("Test Horina");
			test.setDescription("Es el test es una muestra de Horina");
			when(testService.put(test)).thenReturn("Success");
			testMockMvc.perform(put("/test/update" +  "?id=" + test.getId() + "&name=" + test.getName() + "&description="
					+ test.getDescription())
					.content(objectMapper.writeValueAsString(test)).contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
			verify(testService, times(3)).put(test);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	void testDelete() throws Exception {
		
		Integer id = 2;
		
		TestL test = new TestL(id, "Test Horina", "Es el test es una muestra de Horina");
		

		when(testService.delete(test.getId())).thenReturn("Deleted");

		testMockMvc.perform(
				delete("/test/delete/2").contentType(MediaType.APPLICATION_JSON));
		
	
	
	}
	

}
