package br.com.escolaEAD.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.escolaEAD.model.Aluno;
import br.com.escolaEAD.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }
    public void salvar(Aluno aluno) {
        alunoRepository.save(aluno);
    }
    public void excluir(Long id) {
        alunoRepository.deleteById(id);
    }
    public void alterar(Long id, Aluno aluno) {
        if (alunoRepository.existsById(id)) {
            aluno.setId(id);
            alunoRepository.save(aluno);
        }
    }
}