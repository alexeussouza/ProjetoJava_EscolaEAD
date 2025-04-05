package br.com.escolaEAD.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.escolaEAD.model.Professor;
import br.com.escolaEAD.repository.ProfessorRepository;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor buscarPorId(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }
    public void salvar(Professor professor) {
        professorRepository.save(professor);
    }
    public void excluir(Long id) {
        professorRepository.deleteById(id);
    }
    public void alterar(Long id, Professor professor) {
        if (professorRepository.existsById(id)) {
            professor.setId(id);
            professorRepository.save(professor);
        }
    }
}