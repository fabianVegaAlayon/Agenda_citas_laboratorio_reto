package com.sophos.Agenda_citas_laboratorio.controllersImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sophos.Agenda_citas_laboratorio.entities.Test;
import com.sophos.Agenda_citas_laboratorio.service.TestService;

@RestController
public class TestControllerImpl {
	@Autowired
	TestService testService;

	// http://localhost:8080/tests/id
	@RequestMapping(value = "/test/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Test>> getAById(@PathVariable Integer id) {

		if (testService.getById(id) == null || testService.getById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(testService.getById(id));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(testService.getById(id));
		}

	}

	// http://localhost:8080/tests
	@RequestMapping(value = "/tests", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Test>> getAList() {

		if (testService.getList() == null || testService.getList().isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(testService.getList());
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(testService.getList());
		}

	}

	// http://localhost:8080/test/add
	@RequestMapping(value = "/test/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Test> postA(Test test) {

		if (testService.post(test) == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(testService.post(test));
		} else {

			return ResponseEntity.status(HttpStatus.CREATED).body(testService.post(test));
		}

	}

	@RequestMapping(value = "/test/delete/{id}", method = { RequestMethod.DELETE,
			RequestMethod.GET }, produces = "application/json")
	public ResponseEntity<String> delete(@PathVariable Integer id) {

		if (testService.delete(id).contains("Error")) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(testService.delete(id));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(testService.delete(id));
		}

	}

	// http://localhost:8080/test/update
	@RequestMapping(value = "/test/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<String> put(Test test) {

		if (testService.put(test).contains("Error")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(testService.put(test));
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(testService.put(test));
		}
		
		
	}

	@RequestMapping(value = "/test/tst", method = RequestMethod.GET, produces = "application/json")
	public String test() {

		return "Service Test is correct";
	}

}
