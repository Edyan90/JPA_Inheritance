package eddyTurpo.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "città")
    private String città;

    @OneToMany(mappedBy = "location")
    private List<Evento> eventi;

    public Location() {
    }

    public Location(String nome, String città) {
        this.nome = nome;
        this.città = città;

    }

    public Location(List<Evento> eventi) {
        this.eventi = eventi;
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

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", città='" + città + '\'' +

                '}';
    }
}
