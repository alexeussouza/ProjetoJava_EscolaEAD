package br.com.escolaEAD.model;

import jakarta.persistence.Entity;

@Entity
public class Aluno extends Pessoa {
    private String matricula;
      
    // Getters e Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
