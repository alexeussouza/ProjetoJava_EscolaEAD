package br.com.escolaEAD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.escolaEAD.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{}
