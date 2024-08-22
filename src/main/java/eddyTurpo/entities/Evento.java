package eddyTurpo.entities;

import eddyTurpo.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity//qui vogliamo che la classe sia mappata ad una specifica tabella nel db
@Table(name = "evento")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Evento {
    @Id
    @GeneratedValue
    protected UUID id;
    @Column(name = "titolo")
    protected String titolo;
    @Column(name = "data_evento")
    protected LocalDate dataEvento;
    @Column(name = "descrizione")
    protected String descrizione;
    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    protected EventType tipoEvento;
    @Column(name = "numero_max_partecipanti")
    protected long numeroMassimoPartecipanti;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    protected Location location;

    public Evento() {
    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, EventType tipoEvento, long numeroMassimoPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public EventType getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(EventType tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public long getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(long numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", location=" + location +
                '}';
    }
}
