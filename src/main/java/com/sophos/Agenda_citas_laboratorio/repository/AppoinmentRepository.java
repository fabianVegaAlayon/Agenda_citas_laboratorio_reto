package com.sophos.Agenda_citas_laboratorio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sophos.Agenda_citas_laboratorio.entities.Appoinment;

public interface AppoinmentRepository extends JpaRepository<Appoinment, Integer>
{
	Void save(Optional<Appoinment> appoinmentToUpdate);
	
}
