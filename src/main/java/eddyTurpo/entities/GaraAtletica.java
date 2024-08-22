package eddyTurpo.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class GaraAtletica extends Evento {
    @ManyToMany
    @JoinTable(name = "lista_atleti",
            joinColumns = @JoinColumn(name = "gara_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "persona_id", nullable = false))
    private List<Persona> lista_atleti;
    @ManyToOne
    @JoinColumn(name = "vincitore")
    private Persona vincitore;

}
