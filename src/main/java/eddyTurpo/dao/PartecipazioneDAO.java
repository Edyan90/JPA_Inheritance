package eddyTurpo.dao;

import eddyTurpo.entities.Evento;
import eddyTurpo.entities.Partecipazione;
import eddyTurpo.exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class PartecipazioneDAO {
    private final EntityManager pDao;

    public PartecipazioneDAO(EntityManager pDao) {
        this.pDao = pDao;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = pDao.getTransaction();
        transaction.begin();
        pDao.persist(partecipazione);
        transaction.commit();
        System.out.println("La partecipazione con ID:  " + partecipazione.getId() + " è stato salvato correttamente");
    }

    public Partecipazione findByID(UUID id) {
        Partecipazione found = pDao.find(Partecipazione.class, id);
        if (found == null) throw new NotFoundEx(id);
        return found;
    }

    public void delete(UUID id) {
        Partecipazione found = this.findByID(id);
        EntityTransaction transaction = pDao.getTransaction();
        transaction.begin();
        pDao.remove(found);
        transaction.commit();
        System.out.println("la partecipazione è stata rimossa!");

    }

    public List<Partecipazione> getPartecipazioniDaConfermarePerEvento(Evento evento) {
        TypedQuery<Partecipazione> query = pDao.createQuery("SELECT p FROM Partecipazione p WHERE p.evento=:evento AND p.stato IS NULL", Partecipazione.class);
        query.setParameter("evento", evento);
        return query.getResultList();
    }

}
