package com.sophos.Agenda_citas_laboratorio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sophos.Agenda_citas_laboratorio.dto.JoinDto;
import com.sophos.Agenda_citas_laboratorio.entities.Appoinment;


public interface AppoinmentRepository extends JpaRepository<Appoinment, Integer>
{
	Void save(Optional<Appoinment> appoinmentToUpdate);
	 @Query("SELECT new com.sophos.Agenda_citas_laboratorio.dto.JoinDto ( a.id,a.name,a.age,a.mail,app.id,app.date_appoinment,app.hour,t.name)"
	            +"FROM affiliates a  INNER JOIN appoinments app.id_affiliate app INNER JOIN app.id_test t ")
	List<JoinDto> fetchDataInnerJoin();
}
