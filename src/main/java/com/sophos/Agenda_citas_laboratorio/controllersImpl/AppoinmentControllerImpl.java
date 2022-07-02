package com.sophos.Agenda_citas_laboratorio.controllersImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	public Optional<Appoinment> getAById(@PathVariable Integer id) {

		return appoinmentService.getById(id);
	}

	// http://localhost:8080/appoinments
	@RequestMapping(value = "/appoinments", method = RequestMethod.GET, produces = "application/json")

	public List<Appoinment> getAList() {

		return appoinmentService.getList();

	}

	// http://localhost:8080/appoinment/add/params
	@RequestMapping(value = "/appoinment/add", method = RequestMethod.POST, produces = "application/json")
	public Appoinment postA(Appoinment appoinment) {

		return appoinmentService.post(appoinment);
	}

	// http://localhost:8080/appoinment/delete/n
	@RequestMapping(value = "/appoinment/delete/{id}", method = { RequestMethod.DELETE,
			RequestMethod.GET }, produces = "application/json")
	public String deleteA(@PathVariable Integer id) {

		return appoinmentService.delete(id);
	}

	// http://localhost:8080/appoinment/update/
	@RequestMapping(value = "/appoinment/update", method = RequestMethod.PUT, produces = "application/json")
	public String putA(Appoinment appoinment) {

		return appoinmentService.put(appoinment);
	}

	// http://localhost:8080/appoinment/test
	@RequestMapping(value = "/appoinment/test", method = RequestMethod.GET, produces = "application/json")

	public String test() {

		return "Test Sucess";
	}

}
