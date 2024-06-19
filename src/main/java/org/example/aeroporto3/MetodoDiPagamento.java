package org.example.aeroporto3;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "\"MetodoDiPagamento\"")
public class MetodoDiPagamento {
    @Id
    @Column(name = "\"Numero\"")
    int numero;

    @Column(name = "\"Tipologia\"")
    String tipologia;

    @Column(name = "\"LimiteTransazione\"")
    int limiteTransazione;

    @ManyToOne
    @JoinColumn(name = "\"CFUtente\"", referencedColumnName = "\"CF\"")
    private Passeggero passeggero;


}
