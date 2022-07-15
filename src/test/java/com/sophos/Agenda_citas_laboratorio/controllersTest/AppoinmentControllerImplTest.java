package com.sophos.Agenda_citas_laboratorio.controllersTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
import com.sophos.Agenda_citas_laboratorio.controllersImpl.AppoinmentControllerImpl;
import com.sophos.Agenda_citas_laboratorio.entities.Appoinment;
import com.sophos.Agenda_citas_laboratorio.service.AppoinmentService;

@WebMvcTest(AppoinmentControllerImpl.class)
class AppoinmentControllerImplTest {

	@Autowired
	private MockMvc appoinmentMockMvc;

	@MockBean
	private AppoinmentService appoinmentService;

	ObjectMapper objectMapper;
	Invocation invocation;

	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	@BeforeEach
	void setUp() {
		objectMapper = new ObjectMapper();

	}

	@Test
	void testGetAById() throws Exception {
		when(appoinmentService.getById(1)).thenReturn(Datos.createAppoinment());
		appoinmentMockMvc.perform(get("/appoinments/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.date").value("2023-12-09T05:00:00.000+00:00"))
				.andExpect(jsonPath("$.hour").value("16:55:24"));
		verify(appoinmentService, times(3)).getById(1);

	}

	@Test
	void testGetAList() throws Exception {
		System.out.println("testGetAList");
		List<Appoinment> appoinment = Arrays.asList(Datos.createAppoinment().orElseThrow(),
				Datos.createAppoinmentTwo().orElseThrow());
		when(appoinmentService.getList()).thenReturn(appoinment);

		appoinmentMockMvc.perform(get("/appoinments").contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

		verify(appoinmentService, times(3)).getList();
		assertEquals(2, appoinment.size());

	}

	@Test
	void testPutA() throws Exception {
		System.out.println("testPutA()");

		Date fecha = (Date) formato.parse("09/12/2023");
		Appoinment appoinment = new Appoinment(1, fecha, "16:55:24", 1, 1);

		when(appoinmentService.put(appoinment)).thenReturn("Success");
		appoinmentMockMvc.perform(put(
				"/appoinment/update" + "?id=" + appoinment.getId() + "&date=" + fecha + "&hour=" + appoinment.getHour()
						+ "&id_test=" + appoinment.getId_test() + "&id_affiliate=" + appoinment.getId_affiliate())
				.contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	public void createAppoinment_whenPostMethod() throws Exception {
		try {
			Date fecha = (Date) formato.parse("09/12/2023");
			Appoinment appoinment = new Appoinment(1, fecha, "16:55:24", 1, 1);

			given(appoinmentService.post(appoinment)).willReturn(Datos.newAppoinment());

			appoinmentMockMvc.perform(post("/appoinment/add" + "?id=" + appoinment.getId() + "&date="
					+ appoinment.getDate() + "&hour=" + appoinment.getHour() + "&id_test=" + appoinment.getId_test()
					+ "&id_affiliate=" + appoinment.getId_affiliate())

					.content(objectMapper.writeValueAsString(appoinment)).contentType(MediaType.APPLICATION_JSON));

			assertEquals("16:55:24", appoinment.getHour());

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	public void removeAppoinmentById_whenDeleteMethod() throws Exception {

		Date fecha = (Date) formato.parse("09/12/2023");
		Integer id = 1;

		Appoinment appoinment = new Appoinment(id, fecha, "16:55:24", 1, 1);

		when(appoinmentService.delete(appoinment.getId())).thenReturn("Deleted");

		appoinmentMockMvc.perform(delete("/appoinment/delete/1").contentType(MediaType.APPLICATION_JSON));

	}

}
