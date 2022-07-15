package com.sophos.Agenda_citas_laboratorio.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sophos.Agenda_citas_laboratorio.entities.TestL;
import com.sophos.Agenda_citas_laboratorio.repository.TestRepository;
import com.sophos.Agenda_citas_laboratorio.service.TestService;
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestRepository testRepository;

	@Override
	public List<TestL> getList() {

		return testRepository.findAll();
	}

	@Override
	public Optional<TestL> getById(Integer id) {
		Optional<TestL> test = testRepository.findById(id);
		return test;
	}

	@Override
	public TestL post(TestL testNew) {
		if (testNew != null) {
			return testRepository.save(testNew);
		}
		return new TestL();
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
	public String put(TestL testUpdated) {
		Integer id = testUpdated.getId();
		if (testRepository.findById(id).isPresent()) {
			TestL testToUpdate = new TestL();
			testToUpdate.setId(testUpdated.getId());
			testToUpdate.setName(testUpdated.getName());
			testToUpdate.setDescription(testUpdated.getDescription());
			testRepository.save(testToUpdate);
			return "Test update";

		}

		return "Error to update the Test";
	}

}
