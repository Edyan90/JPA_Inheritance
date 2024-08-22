package eddyTurpo.entities;


import eddyTurpo.enums.EventType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity

public class PartitaDiCalcio extends Evento {
    @Column(name = "squadra_di_casa")
    private String squadra_di_casa;
    @Column(name = "squadra_ospite")
    private String squadra_ospite;
    @Column(name = "squadra_vincente", nullable = false)
    private String squadra_vincente;
    @Column(name = "numero_gol_casa")
    private int numero_gol_squadra_casa;
    @Column(name = "numero_gol_ospite")
    private int numero_gol_ospite;

    public PartitaDiCalcio() {

    }

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, EventType tipoEvento, long numeroMassimoPartecipanti, Location location, String squadra_di_casa, String squadra_ospite, String squadra_vincente, int numero_gol_squadra_casa, int numero_gol_ospite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.squadra_di_casa = squadra_di_casa;
        this.squadra_ospite = squadra_ospite;
        this.squadra_vincente = squadra_vincente;
        this.numero_gol_squadra_casa = numero_gol_squadra_casa;
        this.numero_gol_ospite = numero_gol_ospite;
    }

    public String getSquadra_di_casa() {
        return squadra_di_casa;
    }

    public void setSquadra_di_casa(String squadra_di_casa) {
        this.squadra_di_casa = squadra_di_casa;
    }

    public String getSquadra_ospite() {
        return squadra_ospite;
    }

    public void setSquadra_ospite(String squadra_ospite) {
        this.squadra_ospite = squadra_ospite;
    }

    public String getSquadra_vincente() {
        return squadra_vincente;
    }

    public void setSquadra_vincente(String squadra_vincente) {
        this.squadra_vincente = squadra_vincente;
    }

    public int getNumero_gol_squadra_casa() {
        return numero_gol_squadra_casa;
    }

    public void setNumero_gol_squadra_casa(int numero_gol_squadra_casa) {
        this.numero_gol_squadra_casa = numero_gol_squadra_casa;
    }

    public int getNumero_gol_ospite() {
        return numero_gol_ospite;
    }

    public void setNumero_gol_ospite(int numero_gol_ospite) {
        this.numero_gol_ospite = numero_gol_ospite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" + super.toString() +
                "squadra_di_casa='" + squadra_di_casa + '\'' +
                ", squadra_ospite='" + squadra_ospite + '\'' +
                ", squadra_vincente='" + squadra_vincente + '\'' +
                ", numero_gol_squadra_casa=" + numero_gol_squadra_casa +
                ", numero_gol_ospite=" + numero_gol_ospite +
                "}";
    }
}
