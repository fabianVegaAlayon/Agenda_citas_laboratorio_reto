package com.sophos.Agenda_citas_laboratorio.controllersTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.aopalliance.intercept.Invocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sophos.Agenda_citas_laboratorio.Datos;
import com.sophos.Agenda_citas_laboratorio.controllersImpl.MasterControllerImpl;

import com.sophos.Agenda_citas_laboratorio.service.MasterService;

@WebMvcTest(MasterControllerImpl.class)
class MasterControllerImplTest {

	@Autowired
	private MockMvc masterMockMvc;

	@MockBean
	private MasterService masterService;

	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	ObjectMapper objectMapper;
	Invocation invocation;

	@BeforeEach
	void setUp() {
		objectMapper = new ObjectMapper();

	}

	@Test
	void testGetById() throws Exception {
		when(masterService.getByAffiliates(1)).thenReturn(Datos.getAffiliateById());
		masterMockMvc.perform(get("/master/id/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].id_affiliate").value(1))
				.andExpect(jsonPath("$[0].name_affiliate").value("sara"));
		verify(masterService, times(2)).getByAffiliates(1);
	}

	@Test
	void testGetByDate() throws Exception {
		Date fecha = (Date) formato.parse("10/12/2023");
		when(masterService.getByDate(fecha.toString())).thenReturn(Datos.getAffiliateByDate());
		masterMockMvc.perform(get("/master/date/" + fecha.toString()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		verify(masterService, times(3)).getByDate(fecha.toString());
	}

}
