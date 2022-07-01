package com.sophos.Agenda_citas_laboratorio.controllersImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.sophos.Agenda_citas_laboratorio.entities.Affiliate;
import com.sophos.Agenda_citas_laboratorio.service.AffiliateService;

@RestController

public class AffiliateControllerImpl{

	@Autowired
	AffiliateService affiliateService;

	@RequestMapping(value = "/affiliates/{id}", method = RequestMethod.GET, produces = "application/json")
	//@ResponseStatus(code = HttpStatus.OK, reason = "Servicio consumido de manera exitosa")
	
	public Optional<Affiliate> getAById(@PathVariable Integer id) {
		
		return affiliateService.getById(id);
	}
	
		

	// http://localhost:8080/affiliates
	@RequestMapping(value = "/affiliates", method = RequestMethod.GET, produces = "application/json")

	public List<Affiliate> getAList() {

		return affiliateService.getList();

	}

	// http://localhost:8080/affiliates/1

	@RequestMapping(value = "/affiliates/add", method = RequestMethod.POST, produces = "application/json")
	public Affiliate postA(Affiliate affiliate) {

		return affiliateService.post(affiliate);
	}

	// @Override
	@RequestMapping(value = "/affiliates/delete/{id}", method = { RequestMethod.DELETE,
			RequestMethod.GET }, produces = "application/json")
	public String deleteA(@PathVariable Integer id) {
		
		return affiliateService.delete(id);
	}

//	@Override
	@RequestMapping(value = "/affiliates/update", method = RequestMethod.PUT, produces = "application/json")
	public String putA(Affiliate affiliate) {

		return affiliateService.put(affiliate);
	}

	// http://localhost:8080/test

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	// @GetMapping()
	public String test() {

		return "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<body>\r\n" + "\r\n" + "<h1>My First Heading</h1>\r\n"
				+ "<p>My first paragraph.</p>\r\n" + "\r\n" + "</body>\r\n" + "</html>";
	}

}
