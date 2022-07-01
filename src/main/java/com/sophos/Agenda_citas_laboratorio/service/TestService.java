package com.sophos.Agenda_citas_laboratorio.service;

import java.util.List;
import java.util.Optional;

import com.sophos.Agenda_citas_laboratorio.entities.Test;

	
public interface TestService {
	
//  find All Tests
	public List<Test> getList();

	public Optional<Test> getById(Integer id);

	// save Test
	public Test post(Test testNew);

	// delete test
	public String delete(Integer id);

	// update test
	public String put(Test testUpdated);
	
	

}
