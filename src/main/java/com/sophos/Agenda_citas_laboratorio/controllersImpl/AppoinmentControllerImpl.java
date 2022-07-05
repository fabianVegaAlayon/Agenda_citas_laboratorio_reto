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

import com.sophos.Agenda_citas_laboratorio.entities.Appoinment;
import com.sophos.Agenda_citas_laboratorio.service.AppoinmentService;

@RestController
public class AppoinmentControllerImpl {
	@Autowired
	AppoinmentService appoinmentService;

	@RequestMapping(value = "/appoinments/{id}", method = RequestMethod.GET, produces = "application/json")

	public ResponseEntity<Optional<Appoinment>> getAById(@PathVariable Integer id) {
		if (appoinmentService.getById(id) == null || appoinmentService.getById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(appoinmentService.getById(id));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(appoinmentService.getById(id));
		}

	}

	// http://localhost:8080/appoinments
	@RequestMapping(value = "/appoinments", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Appoinment>> getAList() {

		if (appoinmentService.getList() == null || appoinmentService.getList().isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(appoinmentService.getList());
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(appoinmentService.getList());
		}

	}

	// http://localhost:8080/appoinment/add/params
	@RequestMapping(value = "/appoinment/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Appoinment> postA(Appoinment appoinment) {

		if (appoinmentService.post(appoinment) == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(appoinmentService.post(appoinment));
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(appoinmentService.post(appoinment));
		}

	}

	// http://localhost:8080/appoinment/delete/n
	@RequestMapping(value = "/appoinment/delete/{id}", method = { RequestMethod.DELETE,
			RequestMethod.GET }, produces = "application/json")
	public ResponseEntity<String> deleteA(@PathVariable Integer id) {

		if (appoinmentService.delete(id).contains("Error")) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(appoinmentService.delete(id));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(appoinmentService.delete(id));
		}

	}

	// http://localhost:8080/appoinment/update/
	@RequestMapping(value = "/appoinment/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<String> putA(Appoinment appoinment) {

		if (appoinmentService.put(appoinment).contains("Error")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(appoinmentService.put(appoinment));
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(appoinmentService.put(appoinment));
		}

	}

	// http://localhost:8080/appoinment/test
	@RequestMapping(value = "/appoinment/test", method = RequestMethod.GET, produces = "application/json")

	public String test() {

		return "Test Sucess";
	}

}
