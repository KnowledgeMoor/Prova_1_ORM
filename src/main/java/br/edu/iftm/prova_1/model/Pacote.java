package br.edu.iftm.prova_1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = { "id", "endereco"})
@EqualsAndHashCode(of = { "id_pacote", "destinatario", "status" })
@Entity
public class Pacote {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String id_pacote;
    private String destinatario;

    @OneToOne
    private Endereco endereco;

    private String status;

    public void atualizarStatus(String status) {
        this.status = status;
    }

    public String consultarInformacoes(){
        return "Pacote: " + id_pacote + "\nDestinatário: " + destinatario + "\nStatus: " + status;
    }

}
