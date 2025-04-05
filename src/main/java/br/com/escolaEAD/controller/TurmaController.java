package br.com.escolaEAD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.escolaEAD.model.Turma;
import br.com.escolaEAD.services.AlunoService;
import br.com.escolaEAD.services.ProfessorService;
import br.com.escolaEAD.services.TurmaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ModelAndView listarTurmas() {
        ModelAndView mv = new ModelAndView("turmas/lista");
        mv.addObject("turmas", turmaService.listarTodos());
        return mv;
    }

    //Formulario para cadastro de nova turma
    @GetMapping("/novo")
    public ModelAndView novaTurma() {
        ModelAndView mv = new ModelAndView("turmas/form");
        mv.addObject("turma", new Turma());
        mv.addObject("professores", professorService.listarTodos());
        mv.addObject("alunos", alunoService.listarTodos());
        return mv;
    }

    @PostMapping("/salvar")
    public String salvarTurma(@ModelAttribute Turma turma) {
        turmaService.salvar(turma);
        return "redirect:/turmas";
    }

    @GetMapping("/excluir/{id}")
    public String excluirTurma(@PathVariable Long id){
        turmaService.excluir(id);
        return "redirect:/turmas";
    }
    //Carrega o formulario com as informações para alteração
    @GetMapping("/alterar/{id}")
    public ModelAndView carregarFormularioTurma(@PathVariable Long id){
        Turma turma = turmaService.buscarPorId(id);
        ModelAndView mv = new ModelAndView("turmas/form");
        mv.addObject("turma", turma);
        mv.addObject("professores", professorService.listarTodos());
        mv.addObject("alunos", alunoService.listarTodos());
        
        return mv;
    }

    //Realiza as alterações no formulario
    @PostMapping("/alterar/{id}")
    public String alterarTurma(@PathVariable Long id, @ModelAttribute Turma turma) {
        turma.setId(id);
        turmaService.alterar(id, turma);
        return "redirect:/turmas";
    }
}
