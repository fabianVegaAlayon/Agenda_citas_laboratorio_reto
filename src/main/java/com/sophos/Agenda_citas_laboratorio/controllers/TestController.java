package com.sophos.Agenda_citas_laboratorio.controllers;

import java.util.Optional;

import com.sophos.Agenda_citas_laboratorio.entities.TestL;



public interface TestController {
	
public Optional<TestL> getTById(Integer id);
	
	public String postT(TestL test);
	
	public String deleteT(Integer id);
	
	public String putT(TestL test);
	
	public String test();
	
	

}
