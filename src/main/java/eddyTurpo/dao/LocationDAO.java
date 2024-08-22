package eddyTurpo.dao;

import eddyTurpo.entities.Location;
import eddyTurpo.exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    private final EntityManager localDao;

    public LocationDAO(EntityManager localDao) {

        this.localDao = localDao;
    }

    public void save(Location location) {
        EntityTransaction transaction = localDao.getTransaction();
        transaction.begin();
        localDao.persist(location);
        transaction.commit();
        System.out.println("La location con ID:  " + location.getId() + " è stato salvato correttamente");
    }

    public Location findByID(UUID id) {
        Location found = localDao.find(Location.class, id);
        if (found == null) throw new NotFoundEx(id);
        return found;
    }

    public void delete(UUID id) {
        Location found = this.findByID(id);
        EntityTransaction transaction = localDao.getTransaction();
        transaction.begin();
        localDao.remove(found);
        transaction.commit();
        System.out.println("la location è stata rimossa!");

    }
}
