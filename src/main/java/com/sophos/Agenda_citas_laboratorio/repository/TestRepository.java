package com.sophos.Agenda_citas_laboratorio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sophos.Agenda_citas_laboratorio.entities.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {

	Void save(Optional<Test> testToUpdate);
}
