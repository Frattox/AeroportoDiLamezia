package org.example.aeroporto3;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table(name = "\"Passeggero\"")
public class Passeggero {
    @Id
    @Column(name = "\"CF\"")
    private String cf;

    @Column(name = "\"Nome\"")
    private String nome;

    @Column(name = "\"Cognome\"")
    private String cognome;

    @Column(name = "\"Email\"")
    private String email;

    @Column(name = "\"Password\"")
    private String password;
}
