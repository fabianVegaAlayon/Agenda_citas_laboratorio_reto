package com.sophos.Agenda_citas_laboratorio.controllers;

import java.util.Optional;

import com.sophos.Agenda_citas_laboratorio.entities.Test;



public interface TestController {
	
public Optional<Test> getTById(Integer id);
	
	public String postT(Test test);
	
	public String deleteT(Integer id);
	
	public String putT(Test test);
	
	public String test();
	
	

}
