package com.sophos.Agenda_citas_laboratorio.service.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sophos.Agenda_citas_laboratorio.entities.Appoinment;
import com.sophos.Agenda_citas_laboratorio.repository.AppoinmentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class AppoinmentServiceImplTest {

	@Autowired
	private AppoinmentRepository appoinmentRepository;

	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	public void testGetAppoinmentsList() {

		List<Appoinment> resultado = appoinmentRepository.findAll();

		for (Appoinment appoinment : resultado) {
			System.out.println(appoinment.toString());

		}

		assertNotNull(resultado);

	}

	@Test
	public void testGetById() throws ParseException {
		System.out.println("testGetById");
		Date fecha = (Date) formato.parse("09/12/2023");

		Appoinment mockAppoinment = new Appoinment(23, fecha, "11:20:20", 3, 4);

		Appoinment resultAppoinment = new Appoinment();

		Optional<Appoinment> resultado = appoinmentRepository.findById(23);
		if (resultado.isPresent()) {
			resultAppoinment = resultado.get();
			assertEquals(mockAppoinment.getId(), resultAppoinment.getId());
			assertEquals(mockAppoinment.getDate(), resultAppoinment.getDate());
			assertEquals(mockAppoinment.getHour(), resultAppoinment.getHour());
			assertEquals(mockAppoinment.getId_test(), resultAppoinment.getId_test());
			assertEquals(mockAppoinment.getId_affiliate(), resultAppoinment.getId_affiliate());
		}

	}

	@Test
	// @Rollback ( false)
	void testPostMethod() throws ParseException {
		System.out.println("testPost");
		Date fecha = (Date) formato.parse("10/07/2022");
		Appoinment mockAppoinment = new Appoinment(fecha, "06:40:00", 2, 3);

		Appoinment newAppoinment = appoinmentRepository.save(mockAppoinment);
		assertNotNull(newAppoinment);

	}

	@Test
	//@Rollback(false)
	void testPutMethod_update_the_appoinment_info() throws ParseException {
		System.out.println("testPutMethod_update_the_appoinment_info");
		Date fecha = (Date) formato.parse("15/08/2022");
		Appoinment mockAppoinment = new Appoinment(26, fecha, "14:30:00", 2, 3);
		Integer id = 26;

		Appoinment updtAppoinment = new Appoinment();
		appoinmentRepository.save(mockAppoinment);
		Optional<Appoinment> updateAppoinment = appoinmentRepository.findById(id);

		if (updateAppoinment.isPresent()) {
			updtAppoinment = updateAppoinment.get();
			System.out.println(mockAppoinment.getDate());
			System.out.println(updtAppoinment.getDate());
			assertEquals(mockAppoinment.getDate(), updtAppoinment.getDate());
		}

	}

	@Test
	@Rollback(false)
	void testDeleteWhenTheAappoinmentExist() {
		Integer id = 26;
		boolean existTheAppoinmentToDelete = appoinmentRepository.findById(id).isPresent();
		appoinmentRepository.deleteById(id);

		assertTrue(existTheAppoinmentToDelete);
	}
	
	
	@Test
	void testDeleteWhenTheAffiliateDoesntExist() {
		try {
		System.out.println("testDeleteWhenTheAffiliateDoesntExist()");
		Integer id = 26;
		boolean existTheAppoinmentToDelete = appoinmentRepository.findById(id).isPresent();
		System.out.println(existTheAppoinmentToDelete);
		appoinmentRepository.deleteById(id);

		assertFalse(existTheAppoinmentToDelete);
		
		}catch (Exception e) {
			System.out.println(">>>>> An Exception Occurred the same is:" + e.getMessage());
		}
		
	}


}
