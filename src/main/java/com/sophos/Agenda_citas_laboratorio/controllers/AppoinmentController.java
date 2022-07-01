package com.sophos.Agenda_citas_laboratorio.controllers;

import java.util.List;
import java.util.Optional;

import com.sophos.Agenda_citas_laboratorio.entities.Appoinment;


public interface AppoinmentController 
{
	
public List<Appoinment> getApList();
	
	public Optional<Appoinment> getApById(Integer id);
	
	public String postAp(Appoinment appoinment);
	
	public String deleteAp(Integer id);
	
	public String putAp(Appoinment appoinment);
	
	public String test();
	
	

}
