package br.edu.iftm.prova_1.model;

import java.sql.Date;

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
@EqualsAndHashCode(of = { "data", "status", "localizacao" })
@Entity
public class Rastreamento {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private Date data;
    private String status;
    private String localizacao;

    public String getResumo(){
        return "Data: " + data + " - Status: " + status + " - Localização: " + localizacao;
    }
}
