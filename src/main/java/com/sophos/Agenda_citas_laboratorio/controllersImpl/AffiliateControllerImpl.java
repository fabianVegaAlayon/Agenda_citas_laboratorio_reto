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

import com.sophos.Agenda_citas_laboratorio.entities.Affiliate;
import com.sophos.Agenda_citas_laboratorio.service.AffiliateService;

@RestController

public class AffiliateControllerImpl {

	@Autowired
	AffiliateService affiliateService;

	@RequestMapping(value = "/affiliates/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Affiliate>> getAById(@PathVariable Integer id) {
		if (affiliateService.getById(id) == null || affiliateService.getById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(affiliateService.getById(id));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(affiliateService.getById(id));
		}

	}

	// http://localhost:8080/affiliates
	@RequestMapping(value = "/affiliates", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Affiliate>> getAList() {

		if (affiliateService.getList() == null || affiliateService.getList().isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(affiliateService.getList());
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(affiliateService.getList());
		}

	}

	// http://localhost:8080/affiliates/1
	@RequestMapping(value = "/affiliates/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Affiliate> postA(Affiliate affiliate) {

		if (affiliateService.post(affiliate) == null) {
			System.out.println(affiliate);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(affiliateService.post(affiliate));
		} else {
			System.out.println(affiliate);
			return ResponseEntity.status(HttpStatus.CREATED).body(affiliateService.post(affiliate));
		}

	}

	@RequestMapping(value = "/affiliates/delete/{id}", method =  {RequestMethod.DELETE,
			RequestMethod.GET }, produces = "application/json")
	public ResponseEntity<String> deleteA(@PathVariable Integer id) {
		if (affiliateService.delete(id).contains("Error")) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(affiliateService.delete(id));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(affiliateService.delete(id));
		}

	}

	@RequestMapping(value = "/affiliates/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<String> putA(Affiliate affiliate) {

		if (affiliateService.put(affiliate).contains("Error")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(affiliateService.put(affiliate));
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(affiliateService.put(affiliate));
		}

		
	}

	// http://localhost:8080/test
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	public String test() {

		return "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<body>\r\n" + "\r\n" + "<h1>My First Heading</h1>\r\n"
				+ "<p>My first paragraph.</p>\r\n" + "\r\n" + "</body>\r\n" + "</html>";
	}

}
