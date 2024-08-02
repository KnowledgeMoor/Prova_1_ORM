package br.edu.iftm.prova_1.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private String status;

    @OneToOne
    private Endereco endereco;
    @OneToMany
	private List<Rastreamento> rastreamentos = new ArrayList<Rastreamento>();

    public Pacote(String id_pacote, String destinatario, Endereco endereco){
        this.id_pacote = id_pacote;
        this.destinatario = destinatario;
        this.endereco = endereco;
    }

    public Pacote(String id_pacote, String destinatario){
        this.id_pacote = id_pacote;
        this.destinatario = destinatario;
    }

    public void atualizarStatus(String status, Date dataHora, String localizacao) {
        rastreamentos.add(new Rastreamento(dataHora, status, localizacao));
        this.status = status;
    }

    public String consultarInformacoes(){
        return "Pacote: " + id_pacote + "\nDestinatário: " + destinatario + "\nStatus: " + status;
    }

}
