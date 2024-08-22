package eddyTurpo.entities;

import eddyTurpo.enums.SessoType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cognome")
    private String cognome;
    @Column(name = "email")
    private String email;
    @Column(name = "data_nascita")
    private LocalDate data_nascita;
    @Column(name = "sesso")
    private SessoType sesso;

    @ManyToMany(mappedBy = "lista_atleti")
    private List<GaraAtletica> lista_atleti;

    // private List<Partecipazioni> partecipazioniList;


    public Persona() {

    }

    public Persona(String nome, String cognome, String email, LocalDate data_nascita, SessoType sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.data_nascita = data_nascita;
        this.sesso = sesso;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(LocalDate data_nascita) {
        this.data_nascita = data_nascita;
    }

    public SessoType getSesso() {
        return sesso;
    }

    public void setSesso(SessoType sesso) {
        this.sesso = sesso;
    }
}
