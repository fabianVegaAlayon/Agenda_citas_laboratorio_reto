package com.sophos.Agenda_citas_laboratorio.service.Impl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sophos.Agenda_citas_laboratorio.entities.Appoinment;
import com.sophos.Agenda_citas_laboratorio.repository.AppoinmentRepository;
import com.sophos.Agenda_citas_laboratorio.service.AppoinmentService;
@Service
public class AppoinmentServiceImpl implements AppoinmentService{
	@Autowired
	AppoinmentRepository appoinmentRepository;

	@Override
	public List<Appoinment> getList() {
		
		return appoinmentRepository.findAll();
	}

	@Override
	public Optional<Appoinment> getById(Integer id) {
		Optional<Appoinment> appoinment = appoinmentRepository.findById(id);
		return appoinment;
	}

	@Override
	public Appoinment post(Appoinment appoinmentNew) {
		if(appoinmentNew != null ) 
		{
		
			
			return appoinmentRepository.save(appoinmentNew);
		}
		return new Appoinment();
	}

	@Override
	public String delete(Integer id) {
		if(appoinmentRepository.findById(id).isPresent()) 
		{
			appoinmentRepository.deleteById(id);
			return "Appoiment deleted succes";
		}
		
		return "Error! the Appoinment doesn't Exist";
	}

	@Override
	public String put(Appoinment appoinmentUpdated)  {
		
		try {
		Integer id = appoinmentUpdated.getId();
		if(appoinmentRepository.findById(id).isPresent()) 
		{
			
			Appoinment appointmentToUpdate = new Appoinment();
			appointmentToUpdate.setId(appoinmentUpdated.getId());
			appointmentToUpdate.setDate(appoinmentUpdated.getDate());
			appointmentToUpdate.setHour(appoinmentUpdated.getHour());
			appointmentToUpdate.setId_test(appoinmentUpdated.getId_test());
			appointmentToUpdate.setId_affiliate(appoinmentUpdated.getId_affiliate());
			
			
			appoinmentRepository.save(appointmentToUpdate);
			
			
			
			return "Appointment updated";
			
			}
		
		return "Error to update the Appointment";
		}catch (Exception e) {
		   return e.getMessage();
		}
	}
	
	

}
