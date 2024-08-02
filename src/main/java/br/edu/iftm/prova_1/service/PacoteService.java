package br.edu.iftm.prova_1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.prova_1.model.Endereco;
import br.edu.iftm.prova_1.model.Pacote;
import br.edu.iftm.prova_1.repository.EnderecoRepository;
import br.edu.iftm.prova_1.repository.PacoteRepository;


@Service
public class PacoteService {
    
    @Autowired
    private PacoteRepository repository;
    @Autowired
    private EnderecoRepository enderecoRepository;


    public List<Pacote> pacotes() {
		List<Pacote> lista = new ArrayList<Pacote>();
		repository.findAll().forEach(i -> lista.add(i));
		return lista;
	}

    public Pacote salva(Pacote item) {
        Endereco endereco = item.getEndereco();
        enderecoRepository.save(endereco);
		return repository.save(item);
	}

    public Pacote busca(Long id) {
		return repository.findById(id).get();
	}

    public Pacote atualiza(Long id, Pacote pacote) {
		Pacote pacoteExistente = repository.findById(id).get();

		pacoteExistente.setId_pacote(pacote.getId_pacote());
		pacoteExistente.setDestinatario(pacote.getDestinatario());
        return repository.save(pacoteExistente);
	}

    public void delete(Long id) {
		repository.deleteById(id);
	}

}
