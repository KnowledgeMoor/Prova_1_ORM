package br.edu.iftm.prova_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.prova_1.model.Endereco;
import br.edu.iftm.prova_1.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping
	public List<Endereco> endereco() {
		return service.enderecos();
	}

    @PostMapping
	public Endereco create(@RequestBody Endereco item) {
		return service.salva(item);
	}
}
