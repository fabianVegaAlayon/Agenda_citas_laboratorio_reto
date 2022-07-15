package com.sophos.Agenda_citas_laboratorio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sophos.Agenda_citas_laboratorio.entities.TestL;
@Repository
public interface TestRepository extends JpaRepository<TestL, Integer> {

	Void save(Optional<TestL> testToUpdate);
}
