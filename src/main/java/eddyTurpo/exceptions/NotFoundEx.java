package eddyTurpo.exceptions;

import eddyTurpo.entities.Persona;

import java.util.UUID;

public class NotFoundEx extends RuntimeException {
    public NotFoundEx(UUID id) {
        super("L'elemento con ID " + id + " non è stato trovato");
    }

    public NotFoundEx(int partecipanti) {
        super("L'evento con " + partecipanti + " pari a numero max di partecipanti non è stato trovato");
    }

    public NotFoundEx(Persona persona) {
        super("L'atleta e/o vincitore " + persona + " non è stato trovato in nessuna gara");
    }


}
