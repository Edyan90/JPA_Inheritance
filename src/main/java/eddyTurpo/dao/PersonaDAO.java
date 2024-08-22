package eddyTurpo.dao;

import eddyTurpo.entities.Persona;
import eddyTurpo.exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDAO {
    private final EntityManager personaDao;

    public PersonaDAO(EntityManager personaDao) {
        this.personaDao = personaDao;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = personaDao.getTransaction();
        transaction.begin();
        personaDao.persist(persona);
        transaction.commit();
        System.out.println("La persona con ID:  " + persona.getId() + " è stato salvato correttamente");
    }

    public Persona findByID(UUID id) {
        Persona found = personaDao.find(Persona.class, id);
        if (found == null) throw new NotFoundEx(id);
        return found;
    }

    public void delete(UUID id) {
        Persona found = this.findByID(id);
        EntityTransaction transaction = personaDao.getTransaction();
        transaction.begin();
        personaDao.remove(found);
        transaction.commit();
        System.out.println("la persona è stata rimossa!");

    }
}
