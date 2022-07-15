package com.sophos.Agenda_citas_laboratorio.service.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import com.sophos.Agenda_citas_laboratorio.entities.TestL;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sophos.Agenda_citas_laboratorio.repository.TestRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TestServiceImplTest {

	@Autowired
	private TestRepository testRepository;

	@Test
	void testGetList() {
		List<TestL> result = testRepository.findAll();

		for (TestL test : result) {
			System.out.println(test.toString());

		}
	}

	@Test
	void testGetById() {
		System.out.println("testGetById");
		TestL mockTest = new TestL(2, "Análisis de orina",
				"Es una prueba de su orina; A menudo se realiza para chequear si hay una infección de las vías urinarias, problemas renales o diabetes");

		TestL resultTestL = new TestL();

		Optional<TestL> result = testRepository.findById(2);
		if (result.isPresent()) {
			resultTestL = result.get();
			assertEquals(mockTest.getId(), resultTestL.getId());
			assertEquals(mockTest.getName(), resultTestL.getName());
			assertEquals(mockTest.getDescription(), resultTestL.getDescription());

		}

	}

	@Test
	@Rollback(false)
	void testPost() {
		System.out.println("testPost");
		TestL mockTest = new TestL("Análisis Encefalográfico", "Registro de la actividad eléctrica del cerebro.");

		TestL newTestL = testRepository.save(mockTest);
		assertNotNull(newTestL);
	}

	@Test
	void testPutMethod_update_the_test_info() {
		System.out.println("testPutMethod_update_the_test_info");
		TestL mockTest = new TestL(6, "Encefalograma", "Registro de la actividad eléctrica del cerebro.");
		Integer id = 6;

		TestL updtTest = new TestL();
		testRepository.save(mockTest);
		Optional<TestL> result = testRepository.findById(id);

		if (result.isPresent()) {
			updtTest = result.get();
			System.out.println(mockTest.getName());
			System.out.println(updtTest.getName());
			assertEquals(mockTest.getName(), updtTest.getName());
		}

	}

	@Test

	void testDeleteWhenTheTestExist() {

		Integer id = 6;
		boolean existTheAppoinmentToDelete = testRepository.findById(id).isPresent();
		testRepository.deleteById(id);

		assertTrue(existTheAppoinmentToDelete);

	}

	@Test
	void testDeleteWhenTheTestDoesntExist() {
		try {
			System.out.println("DeleteWhenTheTestDoesntExist()");
			Integer id = 7;
			boolean existTheTestToDelete = testRepository.findById(id).isPresent();
			System.out.println(existTheTestToDelete);
			testRepository.deleteById(id);
			System.out.println(existTheTestToDelete);
			assertFalse(existTheTestToDelete);

		} catch (Exception e) {
			System.out.println(">>>>> An Exception Occurred the same is:" + e.getMessage());
		}

	}

}
