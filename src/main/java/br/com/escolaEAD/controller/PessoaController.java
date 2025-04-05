package br.com.escolaEAD.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.escolaEAD.model.Pessoa;
import br.com.escolaEAD.services.PessoaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    // 1️⃣ Listar todas as pessoas
    @GetMapping
    public ModelAndView listarPessoas() {
        List<Pessoa> pessoas = pessoaService.listarTodas();
        ModelAndView mv = new ModelAndView("pessoas/lista");
        mv.addObject("pessoas", pessoas);
        return mv;
    }

    // 2️⃣ Formulário para cadastro de uma nova pessoa
    @GetMapping("/novo")
    public ModelAndView novoCadastro() {
        ModelAndView mv = new ModelAndView("pessoas/form");
        mv.addObject("pessoa", new Pessoa()); // Objeto vazio para preenchimento no formulário
        return mv;
    }

    // 3️⃣ Salvar pessoa (tanto novo cadastro quanto alteração)
    @PostMapping("/salvar")
    public String salvarPessoa(@ModelAttribute Pessoa pessoa) {
        pessoaService.salvar(pessoa);
        return "redirect:/pessoas"; // Redireciona para edição após salvar
    }

    // 4️⃣ Carregar formulário de edição com os dados preenchidos
    @GetMapping("/alterar/{id}")
    public ModelAndView alterarPessoa(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.buscarPorId(id);
        if (pessoa == null) {
            return new ModelAndView("redirect:/pessoas");
        }
        ModelAndView mv = new ModelAndView("pessoas/form");
        mv.addObject("pessoa", pessoa);
        return mv;
    }

    //PostMapping para processar a alteração
    @PostMapping("/alterar/{id}")
    public String alterarPessoa(@PathVariable Long id, @ModelAttribute Pessoa pessoa) {
        pessoa.setId(id);
        pessoaService.alterar(id, pessoa);
        return "redirect:/pessoas";
    }

    // 6️⃣ Excluir pessoa
    @GetMapping("/excluir/{id}")
    public String excluirPessoa(@PathVariable Long id) {
        pessoaService.excluir(id);
        return "redirect:/pessoas";
    }
}

