package br.com.escolaEAD.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.escolaEAD.model.Pessoa;
import br.com.escolaEAD.repository.PessoaRepository;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa buscarPorId(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    public void excluir(Long id) {
        pessoaRepository.deleteById(id);
    }
    public void alterar(Long id, Pessoa pessoa) {
        if (pessoaRepository.existsById(id)) {
            pessoa.setId(id);
            pessoaRepository.save(pessoa);
        }
    }
}
