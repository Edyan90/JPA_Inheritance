package eddyTurpo.exceptions;

import java.util.UUID;

public class NotFoundEx extends RuntimeException {
    public NotFoundEx(UUID id) {
        super("L'elemento con ID " + id + " non è stato trovato");
    }

    public NotFoundEx(int partecipanti) {
        super("L'evento con " + partecipanti + " pari a numero max di partecipanti non è stato trovato");
    }
}
