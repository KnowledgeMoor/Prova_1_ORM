package br.edu.iftm.prova_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.prova_1.model.Pacote;
import br.edu.iftm.prova_1.service.PacoteService;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    @Autowired
	private PacoteService service;

    @GetMapping
	public List<Pacote> pacotes() {
		return service.pacotes();
	}

    @PostMapping
	public Pacote create(@RequestBody Pacote item) {
		return service.salva(item);
	}

    @GetMapping("/{id}")
	public Pacote pacote(@PathVariable Long id) {
		return service.busca(id);
	}

    @PutMapping("/{id}")
	public Pacote atualiza(@PathVariable Long id, @RequestBody Pacote item) {
		return service.atualiza(id, item);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}


	

}
