package com.sophos.Agenda_citas_laboratorio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.sophos.Agenda_citas_laboratorio.entities.Affiliate;




@Repository
public interface AffiliateRepository extends JpaRepository<Affiliate, Integer> {
	Void save(Optional<Affiliate> affiliateToUpdate);

}
