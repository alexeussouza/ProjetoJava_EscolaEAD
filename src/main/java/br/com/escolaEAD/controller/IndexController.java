package br.com.escolaEAD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    //Para acessar a pagina index.html basta acessar http://localhost:8080/

}