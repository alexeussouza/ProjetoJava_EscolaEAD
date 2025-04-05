package br.com.escolaEAD.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.escolaEAD.model.Turma;
import br.com.escolaEAD.repository.TurmaRepository;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> listarTodos() {
        return turmaRepository.findAll();
    }

    public void salvar(Turma turma) {
        turmaRepository.save(turma);
    }

    public Turma buscarPorId(Long id) {
        return turmaRepository.findById(id).orElseThrow(() -> new RuntimeException("Turma não encontrada"));
    }

    public void excluir(Long id) {
        turmaRepository.deleteById(id);
    }

    public void alterar(Long id, Turma turmaAtualizada) {
        Turma turma = buscarPorId(id);
        turma.setTurno(turmaAtualizada.getTurno());
        turma.setProfessor(turmaAtualizada.getProfessor());
        turma.setAlunos(turmaAtualizada.getAlunos());
        turmaRepository.save(turma);
    }
}
