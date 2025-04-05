package br.com.escolaEAD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.escolaEAD.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{}
