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

import com.sophos.Agenda_citas_laboratorio.entities.Master;
import com.sophos.Agenda_citas_laboratorio.service.MasterService;

@RestController
public class MasterControllerImpl {
	@Autowired
	MasterService masterService;

	@RequestMapping(value = "/master/date/{date}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Master>> getByDate(@PathVariable String date) {
		if (masterService.getByDate(date) == null || masterService.getByDate(date).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(masterService.getByDate(date));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(masterService.getByDate(date));
		}

	}

	@RequestMapping(value = "/master/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Master>> getByAffiliate(@PathVariable Integer id) {
		if (masterService.getByAffiliates(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(masterService.getByAffiliates(id));
		}
		return ResponseEntity.status(HttpStatus.OK).body(masterService.getByAffiliates(id));

	}

	@RequestMapping(value = "/master/test", method = RequestMethod.GET, produces = "application/json")

	public String test() {

		return "Test Master Sucess";
	}

}
