package br.com.escolaEAD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.escolaEAD.model.Pessoa;

@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa, Long>{}
