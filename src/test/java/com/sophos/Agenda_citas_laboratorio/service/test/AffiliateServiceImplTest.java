package com.sophos.Agenda_citas_laboratorio.service.test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sophos.Agenda_citas_laboratorio.entities.Affiliate;
import com.sophos.Agenda_citas_laboratorio.repository.AffiliateRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class AffiliateServiceImplTest {

	@Autowired
	private AffiliateRepository affiliateRepository;

	@Test
	public void testGetList() {

		List<Affiliate> resultado = affiliateRepository.findAll();

		for (Affiliate affiliate : resultado) {
			System.out.println(affiliate.getId() + " " + affiliate.getName() + " " + affiliate.getAge() + " "
					+ affiliate.getMail());

		}

		assertNotNull(resultado);

	}

	@Test
	public void testGetById() {
		System.out.println("testGetById");
		Affiliate mockAffiliate = new Affiliate();
		mockAffiliate.setId(2);
		mockAffiliate.setName("mengana");
		mockAffiliate.setAge(19);
		mockAffiliate.setMail("m@any.com");

		Affiliate resultAffiliate = new Affiliate();

		Optional<Affiliate> resultado = affiliateRepository.findById(2);
		if (resultado.isPresent()) {
			resultAffiliate = resultado.get();
			assertEquals(mockAffiliate.getId(), resultAffiliate.getId());
			assertEquals(mockAffiliate.getName(), resultAffiliate.getName());
			assertEquals(mockAffiliate.getAge(), resultAffiliate.getAge());
			assertEquals(mockAffiliate.getMail(), resultAffiliate.getMail());
		}

	}

	@Test
	// @Rollback ( false)
	void testPostMethod() {
		System.out.println("testPost");
		Affiliate mockAffiliate = new Affiliate();
		mockAffiliate.setName("fufulano");
		mockAffiliate.setAge(15);
		mockAffiliate.setMail("fufu@any.com");

		Affiliate newAffiliate = affiliateRepository.save(mockAffiliate);
		assertNotNull(newAffiliate);

	}

	@Test
	// @Rollback(false)
	void testPutMethod() {
		System.out.println("testPost");
		Affiliate mockAffiliate = new Affiliate();
		Integer id = 21;
		mockAffiliate.setId(id);
		mockAffiliate.setName("fufulian");
		mockAffiliate.setAge(16);
		mockAffiliate.setMail("fufu@any.com");

		Affiliate updtAffiliate = new Affiliate();
		affiliateRepository.save(mockAffiliate);
		Optional<Affiliate> updateAffiliate = affiliateRepository.findById(id);

		if (updateAffiliate.isPresent()) {
			updtAffiliate = updateAffiliate.get();
			System.out.println(mockAffiliate.getName());
			System.out.println(updtAffiliate.getName());
			assertEquals(mockAffiliate.getName(), updtAffiliate.getName());
		}

	}

	@Test
	@Rollback(false)
	void testDeleteWhenTheAffiliateExist() {
		Integer id = 21;
		boolean existeElRegistroAEliminar = affiliateRepository.findById(id).isPresent();
		affiliateRepository.deleteById(id);

		assertTrue(existeElRegistroAEliminar);
	}

	@Test
	// @Rollback(false)
	void testDeleteWhenTheAffiliateDoesntExist() {
		System.out.println("testDeleteWhenTheAffiliateDoesntExist()");
		Integer id = 1;
		boolean existeElRegistroAEliminar = affiliateRepository.findById(id).isPresent();
		System.out.println(existeElRegistroAEliminar);
		affiliateRepository.deleteById(id);

		assertFalse(existeElRegistroAEliminar);
	}

}
