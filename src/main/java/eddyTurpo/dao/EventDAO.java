package eddyTurpo.dao;

import eddyTurpo.entities.Evento;
import eddyTurpo.enums.InStreamingType;
import eddyTurpo.exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class EventDAO {
    private final EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento event) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
        System.out.println("L'evento " + event.getTitolo() + " è stato salvato correttamente");
    }

    public Evento findByID(UUID id) {
        Evento found = em.find(Evento.class, id);
        if (found == null) throw new NotFoundEx(id);
        return found;
    }

    public void delete(UUID id) {
        Evento found = this.findByID(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("l'evento è stato rimosso!");

    }

    public List<InStreamingType> getConcertiInStreaming() {
        TypedQuery<InStreamingType> query = em.createQuery("SELECT c.in_streaming FROM Concerti c", InStreamingType.class);
        return query.getResultList();
    }
}
