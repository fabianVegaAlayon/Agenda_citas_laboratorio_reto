package com.sophos.Agenda_citas_laboratorio.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sophos.Agenda_citas_laboratorio.entities.Affiliate;
import com.sophos.Agenda_citas_laboratorio.repository.AffiliateRepository;
import com.sophos.Agenda_citas_laboratorio.service.AffiliateService;

@Service
public class AffiliateServiceImpl implements AffiliateService {
	@Autowired
	AffiliateRepository affiliateRepository;

	@Override
	public List<Affiliate> getList() {

		return affiliateRepository.findAll();

	}

	@Override
	public Optional<Affiliate> getById(Integer id) {
		Optional<Affiliate> affiliate = affiliateRepository.findById(id);
		return affiliate;
	}

	@Override
	public Affiliate post(Affiliate affiliateNew) {
		if (affiliateNew != null) {
			return affiliateRepository.save(affiliateNew);
		}
		return new Affiliate();
	}

	@Override
	public String delete(Integer id) {
		if (affiliateRepository.findById(id).isPresent()) {
			affiliateRepository.deleteById(id);
			return "Affiliate deleted success";
		}
		return "Error! the Affiliate doesn't Exist";
	}

	@Override
	public String put(Affiliate affiliateUpdated) {
		Integer id = affiliateUpdated.getId();
		if (affiliateRepository.findById(id).isPresent()) {
			Affiliate affiliateToUpdate = new Affiliate();
			affiliateToUpdate.setId(affiliateUpdated.getId());
			affiliateToUpdate.setName(affiliateUpdated.getName());
			affiliateToUpdate.setAge(affiliateUpdated.getAge());
			affiliateToUpdate.setMail(affiliateUpdated.getMail());
			affiliateRepository.save(affiliateToUpdate);
			return "Affiliate Updated";

		}

		return "Error to update the Affiliate";
	}

}
