package com.sophos.Agenda_citas_laboratorio.service;



import java.util.List;



import com.sophos.Agenda_citas_laboratorio.entities.Master;

public interface MasterService {
	
	public List<Master> getByDate(String date);
	
	public List<Master> getByAffiliates(Integer id);

}
