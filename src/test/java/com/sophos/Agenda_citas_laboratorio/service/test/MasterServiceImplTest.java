package com.sophos.Agenda_citas_laboratorio.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sophos.Agenda_citas_laboratorio.entities.Master;

import com.sophos.Agenda_citas_laboratorio.repository.MasterRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class MasterServiceImplTest {

	@Autowired
	private MasterRepository masterRepository;

	@Test
	public void testGetMasterUserListByDate() {

		List<Master> result = masterRepository.findUserByDate("09/07/2022");

		for (Master master : result) {
			System.out.println(master.toString());

		}

		assertNotNull(result);

	}

	@Test
	public void testGetMasterUserListByAffiliateId() {

		List<Master> result = masterRepository.findAffiliateById(2);

		for (Master master : result) {
			System.out.println(master.toString());

		}

		assertNotNull(result);

	}

}
