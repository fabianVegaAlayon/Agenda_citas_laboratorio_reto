package com.sophos.Agenda_citas_laboratorio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sophos.Agenda_citas_laboratorio.entities.Affiliate;


public interface AffiliateService {
	

	//  find All Affiliates
	public List<Affiliate> getList();

	public Optional<Affiliate> getById(Integer id);

	// save Affiliate
	public Affiliate post(Affiliate affiliateNew);

	// delete Affiliate
	public String delete(Integer id);

	// update Affiliate
	public String put(Affiliate affiliateUpdated);

}
