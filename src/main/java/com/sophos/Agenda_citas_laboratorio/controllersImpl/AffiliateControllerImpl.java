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

import com.sophos.Agenda_citas_laboratorio.entities.Affiliate;
import com.sophos.Agenda_citas_laboratorio.service.AffiliateService;

@RestController

public class AffiliateControllerImpl {

	@Autowired
	AffiliateService affiliateService;

	@RequestMapping(value = "/affiliates/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Affiliate>> getAById(@PathVariable Integer id) {
		Optional<Affiliate> listAffiliate = affiliateService.getById(id);

		if (listAffiliate == null || listAffiliate.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(listAffiliate);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(listAffiliate);
		}

	}

	// http://localhost:8080/affiliates
	@RequestMapping(value = "/affiliates", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Affiliate>> getAList() {
		List<Affiliate> affiliateList = affiliateService.getList();

		if (affiliateList == null || affiliateList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(affiliateList);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(affiliateList);
		}

	}

	// http://localhost:8080/affiliates/1
	@RequestMapping(value = "/affiliates/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<Affiliate>> postA(Affiliate affiliate) {

		List<Affiliate> affiliateList = Arrays.asList(affiliateService.post(affiliate));
		if (affiliateList == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(affiliateList);
		} else {

			return ResponseEntity.status(HttpStatus.CREATED).body(affiliateList);
		}

	}

	@RequestMapping(value = "/affiliates/delete/{id}", method = { RequestMethod.DELETE,
			RequestMethod.GET }, produces = "application/json")
	public ResponseEntity<String> deleteA(@PathVariable Integer id) {
		String messagge = affiliateService.delete(id);
		if (messagge.contains("Error")) {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(messagge);

		} else {

			return ResponseEntity.status(HttpStatus.OK).body(messagge);
		}

	}

	@RequestMapping(value = "/affiliates/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<String> putA(Affiliate affiliate) {
		String messagge = affiliateService.put(affiliate);
		if (messagge.contains("Error")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messagge);
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(messagge);
		}

	}

	// http://localhost:8080/test
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	public String test() {

		return "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<body>\r\n" + "\r\n" + "<h1>My First Heading</h1>\r\n"
				+ "<p>My first paragraph.</p>\r\n" + "\r\n" + "</body>\r\n" + "</html>";
	}

}
