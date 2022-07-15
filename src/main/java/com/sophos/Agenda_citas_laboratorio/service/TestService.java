package com.sophos.Agenda_citas_laboratorio.service;

import java.util.List;
import java.util.Optional;

import com.sophos.Agenda_citas_laboratorio.entities.TestL;

	
public interface TestService {
	
//  find All Tests
	public List<TestL> getList();

	public Optional<TestL> getById(Integer id);

	// save Test
	public TestL post(TestL testNew);

	// delete test
	public String delete(Integer id);

	// update test
	public String put(TestL testUpdated);
	
	

}
