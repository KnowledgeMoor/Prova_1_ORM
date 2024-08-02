package br.edu.iftm.prova_1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.prova_1.model.Pacote;
import br.edu.iftm.prova_1.model.Rastreamento;
import br.edu.iftm.prova_1.repository.PacoteRepository;
import br.edu.iftm.prova_1.repository.RastreamentoRepository;

@Service
public class PacoteService {
    
    @Autowired
    private PacoteRepository repository;
    @Autowired
    private RastreamentoRepository rastreamentoRepository;

    public List<Pacote> pacotes() {
		List<Pacote> lista = new ArrayList<Pacote>();
		repository.findAll().forEach(i -> lista.add(i));
		return lista;
	}

    public Pacote salva(Pacote item) {
		return repository.save(item);
	}

    public Pacote busca(Long id) {
		return repository.findById(id).get();
	}

    public Pacote atualiza(Long id, Pacote pacote, Long id_rastreamento) {
		Pacote pacoteExistente = repository.findById(id).get();
        Rastreamento rastreamento = rastreamentoRepository.findById(id_rastreamento).get();

		pacoteExistente.setId_pacote(pacote.getId_pacote());
		pacoteExistente.setDestinatario(pacote.getDestinatario());
		pacoteExistente.setEndereco(pacote.getEndereco());
        
        rastreamentoRepository.save(rastreamento);
        pacoteExistente.atualizarStatus(rastreamento.getStatus(), rastreamento.getData(), rastreamento.getLocalizacao());
		
        return repository.save(pacoteExistente);
	}

    public void delete(Long id) {
		repository.deleteById(id);
	}

}
