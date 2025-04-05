package br.com.escolaEAD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.escolaEAD.model.Aluno;
import br.com.escolaEAD.services.AlunoService;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/alunos")
public class AlunoController {

@Autowired
    private AlunoService alunoService;

    @GetMapping
    public ModelAndView listarAlunos() {
        ModelAndView mv = new ModelAndView("alunos/lista");
        mv.addObject("alunos", alunoService.listarTodos());
        return mv;
    }

    @GetMapping("/novo")
    public ModelAndView novoAluno() {
        ModelAndView mv = new ModelAndView("alunos/form");
        mv.addObject("aluno", new Aluno());
        return mv;
    }
    
    @PostMapping("/salvar")
    public String salvarProfessor(@ModelAttribute Aluno aluno) {
        alunoService.salvar(aluno);
        return "redirect:/alunos";
    }

    @GetMapping("/excluir/{id}")
    public String deletarAluno(@PathVariable Long id){
        alunoService.excluir(id);
        return "redirect:/alunos";
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView carregarFormularioAluno(@PathVariable Long id) {
        Aluno alunos = alunoService.buscarPorId(id);
        ModelAndView mv = new ModelAndView("alunos/form");
        mv.addObject("aluno", alunos);
        return mv;
    }
    
    @PostMapping("/alterar/{id}")
    public String alterarAluno(@PathVariable Long id, @ModelAttribute Aluno aluno) {
        alunoService.alterar(id, aluno);
        return "redirect:/alunos";
    }
}
