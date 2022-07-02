package com.sophos.Agenda_citas_laboratorio.controllersImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Optional<Test> getAById(@PathVariable Integer id) {

		return testService.getById(id);
	}

	// http://localhost:8080/tests
	@RequestMapping(value = "/tests", method = RequestMethod.GET, produces = "application/json")

	public List<Test> getAList() {

		return testService.getList();

	}

	// http://localhost:8080/test/add
	@RequestMapping(value = "/test/add", method = RequestMethod.POST, produces = "application/json")
	public Test postA(Test test) {

		return testService.post(test);
	}

	@RequestMapping(value = "/test/delete/{id}", method = { RequestMethod.DELETE,
			RequestMethod.GET }, produces = "application/json")
	public String delete(@PathVariable Integer id) {

		return testService.delete(id);
	}
	//http://localhost:8080/test/update
	@RequestMapping(value = "/test/update", method = RequestMethod.PUT, produces = "application/json")
	public String put(Test test) {

		return testService.put(test);
	}

	@RequestMapping(value = "/test/tst", method = RequestMethod.GET, produces = "application/json")
	public String test() {

		return "Service Test is correct";
	}

}
