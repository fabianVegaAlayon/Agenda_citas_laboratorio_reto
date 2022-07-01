package com.sophos.Agenda_citas_laboratorio.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sophos.Agenda_citas_laboratorio.entities.Test;
import com.sophos.Agenda_citas_laboratorio.repository.TestRepository;
import com.sophos.Agenda_citas_laboratorio.service.TestService;
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestRepository testRepository;

	@Override
	public List<Test> getList() {

		return testRepository.findAll();
	}

	@Override
	public Optional<Test> getById(Integer id) {
		Optional<Test> test = testRepository.findById(id);
		return test;
	}

	@Override
	public Test post(Test testNew) {
		if (testNew != null) {
			return testRepository.save(testNew);
		}
		return new Test();
	}

	@Override
	public String delete(Integer id) {
		if (testRepository.findById(id).isPresent()) {
			testRepository.deleteById(id);
			return "Test deleted Succes";
		}
		return "Error! the test doesn't Exist";
	}

	@Override
	public String put(Test testUpdated) {
		Integer id = testUpdated.getId();
		if (testRepository.findById(id).isPresent()) {
			Test testToUpdate = new Test();
			testToUpdate.setId(testUpdated.getId());
			testToUpdate.setName(testUpdated.getName());
			testToUpdate.setDescription(testUpdated.getDescription());
			return "Test update";

		}

		return "Error to update the Test";
	}

}
