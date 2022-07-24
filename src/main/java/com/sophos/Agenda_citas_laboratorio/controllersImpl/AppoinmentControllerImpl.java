package com.sophos.Agenda_citas_laboratorio.controllersImpl;

import java.util.Arrays;
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
		Optional<Appoinment> listAppoinment = appoinmentService.getById(id);
		if (listAppoinment == null || listAppoinment.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(listAppoinment);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(listAppoinment);
		}

	}

	// http://localhost:8080/appoinments
	@RequestMapping(value = "/appoinments", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Appoinment>> getAList() {
		List<Appoinment> appoinmentList = appoinmentService.getList();
		if (appoinmentList == null || appoinmentList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(appoinmentList);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(appoinmentList);
		}

	}

	// http://localhost:8080/appoinment/add/params
	@RequestMapping(value = "/appoinment/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<Appoinment>> postA(Appoinment appoinment) {
		List<Appoinment> appoinmentList = Arrays.asList(appoinmentService.post(appoinment));
		if (appoinmentList == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(appoinmentList);
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(appoinmentList);
		}

	}

	// http://localhost:8080/appoinment/delete/n
	@RequestMapping(value = "/appoinment/delete/{id}", method = { RequestMethod.DELETE,
			RequestMethod.GET }, produces = "application/json")
	public ResponseEntity<String> deleteA(@PathVariable Integer id) {
		String messagge = appoinmentService.delete(id);
		if (messagge.contains("Error")) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(messagge);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(messagge);
		}

	}

	// http://localhost:8080/appoinment/update/
	@RequestMapping(value = "/appoinment/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<String> putA(Appoinment appoinment) {
		String messagge = appoinmentService.put(appoinment);
		if (appoinmentService.put(appoinment).contains("Error")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messagge);
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(messagge);
		}

	}

	// http://localhost:8080/appoinment/test
	@RequestMapping(value = "/appoinment/test", method = RequestMethod.GET, produces = "application/json")

	public String test() {

		return "Test Sucess";
	}

}
