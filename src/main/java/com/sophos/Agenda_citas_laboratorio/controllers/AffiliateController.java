package com.sophos.Agenda_citas_laboratorio.controllers;

import java.util.List;
import java.util.Optional;

import com.sophos.Agenda_citas_laboratorio.entities.Affiliate;

public interface AffiliateController {
	
	public List<Affiliate> getAList();
	
	public Optional<Affiliate> getAById(Integer id);
	
	public String postA(Affiliate affiliate);
	
	public String deleteA(Integer id);
	
	public String putA(Affiliate affiliate);
	
	public String test();
	
	

}
