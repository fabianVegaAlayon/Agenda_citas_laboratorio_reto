package com.sophos.Agenda_citas_laboratorio.repository;



import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import com.sophos.Agenda_citas_laboratorio.entities.Master;

@Repository
public interface MasterRepository extends JpaRepository<Master, Integer>{
	
	
	@Query(value = "SELECT m.* FROM Masters m WHERE m.date_appoinment = ?1", nativeQuery = true)
	List<Master> findUserByDate(String date);
	
	
	@Query(value = "SELECT m.* FROM Masters m WHERE m.ID_AFFILIATE= ?1", nativeQuery = true)
	List<Master> findAffiliateById(Integer id);

	
}
