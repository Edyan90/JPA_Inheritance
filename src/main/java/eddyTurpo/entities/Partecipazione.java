package eddyTurpo.entities;

import eddyTurpo.enums.StatoType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    private Persona persona;

    @ManyToOne
    private Evento evento;
    @Column(name = "stato")
    @Enumerated(EnumType.STRING)
    private StatoType stato;

    public Partecipazione() {

    }

    public Partecipazione(Persona persona, Evento evento, StatoType stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public UUID getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public StatoType getStato() {
        return stato;
    }

    public void setStato(StatoType stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
