package com.sophos.Agenda_citas_laboratorio.controllersTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import com.sophos.Agenda_citas_laboratorio.controllersImpl.AffiliateControllerImpl;
import com.sophos.Agenda_citas_laboratorio.entities.Affiliate;
import com.sophos.Agenda_citas_laboratorio.service.AffiliateService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(AffiliateControllerImpl.class)
class AffiliateControllerImplTest {

	@Autowired
	private MockMvc affiliateMockMvc;

	@MockBean
	private AffiliateService affiliateService;

	ObjectMapper objectMapper;
	Invocation invocation;

	@BeforeEach
	void setUp() {
		objectMapper = new ObjectMapper();

	}

	@Test
	void testGetAById() throws Exception {
		when(affiliateService.getById(1)).thenReturn(Datos.createAffiliate());
		affiliateMockMvc.perform(get("/affiliates/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name").value("quico")).andExpect(jsonPath("$.age").value("22"));
		verify(affiliateService, times(3)).getById(1);

	}

	@Test
	void testGetAList() throws Exception {
		System.out.println("testGetAList");
		List<Affiliate> affiliates = Arrays.asList(Datos.createAffiliate().orElseThrow(),
				Datos.createAffiliateNumbTwo().orElseThrow());
		when(affiliateService.getList()).thenReturn(affiliates);

		affiliateMockMvc.perform(get("/affiliates").contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].name").value("quico")).andExpect(jsonPath("$[1].name").value("Chavo"))
				.andExpect(jsonPath("$[0].age").value("22")).andExpect(jsonPath("$[1].age").value("22"))
				.andExpect(jsonPath("$[0].mail").value("quico@any.com"))
				.andExpect(jsonPath("$[1].mail").value("chavo@any.com"))
				.andExpect(content().json(objectMapper.writeValueAsString(affiliates)));
		verify(affiliateService, times(3)).getList();
		assertEquals(2, affiliates.size());

	}

	@Test
	void testPutA() throws Exception {
		System.out.println("testPutA()");
		try {
			Affiliate affiliate = new Affiliate();
			affiliate.setId(4);
			affiliate.setName("HomeroJay");
			affiliate.setAge(40);
			affiliate.setMail("homero@simpson.com");

			when(affiliateService.put(affiliate)).thenReturn("Success");
			affiliateMockMvc.perform(put("/affiliates/update" + "?id=" + affiliate.getId() + "&name="
					+ affiliate.getName() + "&age=" + affiliate.getAge() + "&mail=" + affiliate.getMail())
					.content(objectMapper.writeValueAsString(affiliate)).contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
			verify(affiliateService, times(3)).put(affiliate);
		} catch (Exception e) {
			System.out.println(e);
		}

	}


	@Test
	public void createUser_whenPostMethod() throws Exception {
		try {
			Affiliate user = new Affiliate(4, "HomeroJay", 40, "homero@simpson.com");

			given(affiliateService.post(user)).willReturn(Datos.newAffiliate());

			affiliateMockMvc.perform(post("/affiliates/add" + "?id=" + user.getId() + "&name=" + user.getName()
					+ "&age=" + user.getAge() + "&mail=" + user.getMail())

					.content(objectMapper.writeValueAsString(user)).contentType(MediaType.APPLICATION_JSON));

			assertEquals("HomeroJay", user.getName());

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	public void removeUserById_whenDeleteMethod() throws Exception {

		Affiliate affiliate = new Affiliate(4, "HomeroJay", 40, "homero@simpson.com");

		when(affiliateService.delete(affiliate.getId())).thenReturn("Deleted");

		affiliateMockMvc.perform(
				delete("/affiliates/delete/4").contentType(MediaType.APPLICATION_JSON));
	
	}

	
}
