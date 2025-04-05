package br.com.escolaEAD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.escolaEAD.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{}
