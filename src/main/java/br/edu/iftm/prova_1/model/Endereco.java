package br.edu.iftm.prova_1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = { "id"})
@EqualsAndHashCode(of = { "rua", "numero", "cidade", "estado", "cep" })
@Entity
public class Endereco {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;

    public String getEnderecoCompleto(){
        return "Rua: " + rua + " " + numero + "\nCidade: " + cidade + "\nEstado: " + estado + "\nCep: " + cep;
    }
}
