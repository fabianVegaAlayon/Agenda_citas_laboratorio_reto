package com.sophos.Agenda_citas_laboratorio.service;

import java.util.List;
import java.util.Optional;

import com.sophos.Agenda_citas_laboratorio.entities.Appoinment;



public interface AppoinmentService {

	//  find All Appoinment
	public List<Appoinment> getList();

	public Optional<Appoinment> getById(Integer id);

	// save Appoinment
	public Appoinment post(Appoinment appoinmentNew);

	// delete Appoinment
	public String delete(Integer id);

	// update Appoinment
	public String put(Appoinment appoinmentUpdated);
	
	
	
}
