package br.com.escolaEAD.model;

import jakarta.persistence.Entity;

@Entity
public class Professor extends Pessoa{
    private String formacao;

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
}
