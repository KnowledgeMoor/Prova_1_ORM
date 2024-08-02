package br.edu.iftm.prova_1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.prova_1.model.Pacote;
import br.edu.iftm.prova_1.model.Rastreamento;
import br.edu.iftm.prova_1.repository.PacoteRepository;
import br.edu.iftm.prova_1.repository.RastreamentoRepository;

@Service
public class RatreamentoService {
    
    @Autowired
    private RastreamentoRepository repository;
    @Autowired
    private PacoteRepository pacoteRepository;

    public Rastreamento salva(Rastreamento item) {
		return repository.save(item);
	}

    public List<Rastreamento> busca(Long id) {
		Pacote pacote = pacoteRepository.findById(id).get();
        return pacote.getRastreamentos();
	}
}
