package com.sophos.Agenda_citas_laboratorio.controllersImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sophos.Agenda_citas_laboratorio.entities.Master;
import com.sophos.Agenda_citas_laboratorio.service.MasterService;
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
public class MasterControllerImpl {
	@Autowired
	MasterService masterService;

	@RequestMapping(value = "/master/date/{date}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Master>> getByDate(@PathVariable String date) {
		List<Master> masterList = masterService.getByDate(date);

		if (masterList == null || masterList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(masterList);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(masterList);
		}

	}

	@RequestMapping(value = "/master/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Master>> getByAffiliate(@PathVariable Integer id) {
		List<Master> masterList = masterService.getByAffiliates(id);
		if (masterService.getByAffiliates(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(masterList);
		}
		return ResponseEntity.status(HttpStatus.OK).body(masterList);

	}

	@RequestMapping(value = "/master/test", method = RequestMethod.GET, produces = "application/json")

	public String test() {

		return "Test Master Sucess";
	}

}
