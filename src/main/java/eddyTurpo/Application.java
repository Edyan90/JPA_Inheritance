package eddyTurpo;

import eddyTurpo.dao.EventDAO;
import eddyTurpo.dao.LocationDAO;
import eddyTurpo.dao.PartecipazioneDAO;
import eddyTurpo.dao.PersonaDAO;
import eddyTurpo.entities.Location;
import eddyTurpo.entities.Persona;
import eddyTurpo.enums.SessoType;
import eddyTurpo.exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;


public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventDAO eventDAO = new EventDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

        Location location = new Location("Salone Conferenze", "Milano");
        locationDAO.save(location);

        Persona persona1 = new Persona("Eddy", "Turpo", "edyan7@hotmail.it", LocalDate.of(1990, 04, 01), SessoType.M);
        personaDAO.save(persona1);
        Persona persona2 = new Persona("Arianna", "Loreti", "aryanna@hotmail.it", LocalDate.of(1999, 04, 01), SessoType.F);
        personaDAO.save(persona1);


        try {
            // Evento laureaDB = eventDAO.findByID(UUID.fromString("6c0882df-551e-4398-9acd-065df73d5d4f"));
            // System.out.println(laureaDB);
        } catch (NotFoundEx e) {
            System.out.println(e.getMessage());
        }

        /*try {
            eventDAO.delete(UUID.fromString("c1926e8d-f537-4050-a9d1-0ffe23fcabc8"));
        } catch (NotFoundEx e) {
            System.out.println(e.getMessage());
        }*/
        em.close();
        emf.close();
    }
}