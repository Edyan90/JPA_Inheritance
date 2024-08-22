package eddyTurpo.entities;

import eddyTurpo.enums.EventType;
import eddyTurpo.enums.GenereType;
import eddyTurpo.enums.InStreamingType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;


@Entity

public class Concerto extends Evento {
    @Column(name = "genere_type")
    @Enumerated(EnumType.STRING)
    private GenereType genere;
    @Column(name = "streaming_type")
    @Enumerated(EnumType.STRING)
    private InStreamingType in_streaming;

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, EventType tipoEvento, long numeroMassimoPartecipanti, Location location, GenereType genere, InStreamingType in_streaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.in_streaming = in_streaming;
    }

    public Concerto() {

    }

    public GenereType getGenere() {
        return genere;
    }

    public void setGenere(GenereType genere) {
        this.genere = genere;
    }

    public InStreamingType getIn_streaming() {
        return in_streaming;
    }

    public void setIn_streaming(InStreamingType in_streaming) {
        this.in_streaming = in_streaming;
    }

    @Override
    public String toString() {
        return "Concerto{" + super.toString() +
                ", genere=" + genere +
                ", in_streaming=" + in_streaming +
                "} ";
    }
}
