package com.sophos.Agenda_citas_laboratorio.controllersImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sophos.Agenda_citas_laboratorio.entities.TestL;
import com.sophos.Agenda_citas_laboratorio.service.TestService;
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
public class TestControllerImpl {
	@Autowired
	TestService testService;

	// http://localhost:8080/tests/id
	@RequestMapping(value = "/test/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<TestL>> getAById(@PathVariable Integer id) {
		Optional<TestL> listTestLaboratory = testService.getById(id);
		if (listTestLaboratory == null || listTestLaboratory.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(listTestLaboratory);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(listTestLaboratory);
		}

	}

	// http://localhost:8080/tests
	@RequestMapping(value = "/tests", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<TestL>> getAList() {
		List<TestL> listTestLaboratory = testService.getList();
		if (listTestLaboratory == null || listTestLaboratory.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(listTestLaboratory);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(listTestLaboratory);
		}

	}

	// http://localhost:8080/test/add
	@RequestMapping(value = "/test/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<TestL>> postA(TestL test) {
		List<TestL> listTestLaboratory = Arrays.asList(testService.post(test));
		if (listTestLaboratory == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listTestLaboratory);
		} else {

			return ResponseEntity.status(HttpStatus.CREATED).body(listTestLaboratory);
		}

	}

	@RequestMapping(value = "/test/delete/{id}", method = { RequestMethod.DELETE,
			RequestMethod.GET }, produces = "application/json")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		String messagge = testService.delete(id);
		if (messagge.contains("Error")) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(messagge);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(messagge);
		}

	}

	// http://localhost:8080/test/update
	@RequestMapping(value = "/test/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<String> put(TestL test) {
		String messagge = testService.put(test);
		if (testService.put(test).contains("Error")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messagge);
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(messagge);
		}

	}

	@RequestMapping(value = "/test/tst", method = RequestMethod.GET, produces = "application/json")
	public String test() {

		return "Service Test is correct";
	}

}
