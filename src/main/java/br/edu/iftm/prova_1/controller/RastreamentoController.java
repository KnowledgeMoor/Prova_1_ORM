package br.edu.iftm.prova_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.prova_1.model.Rastreamento;
import br.edu.iftm.prova_1.service.RatreamentoService;

@RestController
@RequestMapping("/rastreamentos")
public class RastreamentoController {

    @Autowired
    private RatreamentoService service;

    @PostMapping
	public Rastreamento create(@RequestBody Rastreamento item) {
		return service.salva(item);
	}

    @GetMapping("/{id}")
	public List<Rastreamento> pacote(@PathVariable Long id) {
		return service.busca(id);
	}
}
