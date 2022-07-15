package com.sophos.Agenda_citas_laboratorio.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sophos.Agenda_citas_laboratorio.entities.Master;
import com.sophos.Agenda_citas_laboratorio.repository.MasterRepository;
import com.sophos.Agenda_citas_laboratorio.service.MasterService;

@Service
public class MasterServiceImpl implements MasterService {
	@Autowired
	MasterRepository masterRepository;

	@Override
	public List<Master> getByDate(String date) {
		List<Master> master = masterRepository.findUserByDate(date);
		return master;
	}

	@Override
	public List<Master> getByAffiliates(Integer id) {
		List<Master> master = masterRepository.findAffiliateById(id);
		return master;
	}

}
