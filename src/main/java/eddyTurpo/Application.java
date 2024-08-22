package eddyTurpo;

import eddyTurpo.dao.EventDAO;
import eddyTurpo.dao.LocationDAO;
import eddyTurpo.dao.PartecipazioneDAO;
import eddyTurpo.dao.PersonaDAO;
import eddyTurpo.entities.Concerto;
import eddyTurpo.entities.Location;
import eddyTurpo.entities.Persona;
import eddyTurpo.enums.EventType;
import eddyTurpo.enums.GenereType;
import eddyTurpo.enums.InStreamingType;
import eddyTurpo.enums.SessoType;
import eddyTurpo.exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;


public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventDAO eventDAO = new EventDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

        Location location1 = new Location("Salone Conferenze", "Milano");
        //locationDAO.save(location1);

        Persona persona1 = new Persona("Eddy", "Turpo", "edyan7@hotmail.it", LocalDate.of(1990, 04, 01), SessoType.M);
        //personaDAO.save(persona1);
        Persona persona2 = new Persona("Arianna", "Loreti", "aryanna@hotmail.it", LocalDate.of(1999, 04, 01), SessoType.F);
        //personaDAO.save(persona2);
        Persona persona3 = new Persona("Francesca", "Battistini", "frabba@hotmail.it", LocalDate.of(1991, 04, 01), SessoType.F);
        //personaDAO.save(persona3);

        Concerto concerto1 = new Concerto("Milky Chance", LocalDate.now(), "musica indie", EventType.PUBBLICO, 150, location1, GenereType.POP, InStreamingType.TRUE);
        //eventDAO.save(concerto1);

        List<Concerto> concertiInStreaming = eventDAO.getConcertiInStreaming(InStreamingType.TRUE);
        System.out.println(concertiInStreaming);
        List<Concerto> concertiPerGenere = eventDAO.getConcertiPerGenere(GenereType.POP);
        System.out.println(concertiPerGenere);
//        if (concerto1.getIn_streaming() == InStreamingType.TRUE) {
//            System.out.println("Il concerto 'Milky Chance' è in streaming.");
//        } else {
//            System.out.println("Il concerto 'Milky Chance' non è in streaming.");
//        }

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