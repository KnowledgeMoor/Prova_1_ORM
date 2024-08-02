package br.edu.iftm.prova_1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.prova_1.model.Endereco;
import br.edu.iftm.prova_1.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;


    public List<Endereco> enderecos() {
		List<Endereco> lista = new ArrayList<Endereco>();
		repository.findAll().forEach(i -> lista.add(i));
		return lista;
	}

    public Endereco salva(Endereco item) {
		return repository.save(item);
	}


}
