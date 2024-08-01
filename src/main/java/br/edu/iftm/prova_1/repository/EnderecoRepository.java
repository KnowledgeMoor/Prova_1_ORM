package br.edu.iftm.prova_1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.prova_1.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

}
