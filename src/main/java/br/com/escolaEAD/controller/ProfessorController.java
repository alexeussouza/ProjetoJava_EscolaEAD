package br.com.escolaEAD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import br.com.escolaEAD.model.Professor;
import br.com.escolaEAD.services.ProfessorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ModelAndView listarProfessores() {
        List<Professor> professores = professorService.listarTodos();
        ModelAndView mv = new ModelAndView("professores/lista");
        mv.addObject("professores", professores);
        return mv;
    }

    @GetMapping("/novo")
    public ModelAndView novoProfessor() {
        ModelAndView mv = new ModelAndView("professores/form");
        mv.addObject("professor", new Professor());
        return mv;
    }

    @PostMapping("/salvar")
    public String salvarProfessor(@ModelAttribute Professor professor) {

        professorService.salvar(professor);
        return "redirect:/professores";
    }

    @GetMapping("/excluir/{id}")
    public String deletarProfessor(@PathVariable Long id) {
        professorService.excluir(id);
        return "redirect:/professores";
    }

    // GetMapping para exibir o formulário de alteração
    @GetMapping("/alterar/{id}")
    public ModelAndView exibirFormularioAlterar(@PathVariable Long id) {
        Professor professor = professorService.buscarPorId(id);
        if(professor == null){
            return new ModelAndView("redirect:/professores");
        }

        ModelAndView mv = new ModelAndView("professores/form");
        mv.addObject("professor", professor);
        return mv;
    }

    //PostMapping para processar a alteração
    @PostMapping("/alterar/{id}")
    public String alterarProfessor(@PathVariable Long id, @ModelAttribute Professor professor) {
        professor.setId(id);
        professorService.alterar(id, professor);
        return "redirect:/professores";
    }
}