package it.epicode.Progettosettimanale_back_end_S5_L5.utenti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente save(Utente utente) {
        if (utente.getUsername() == null) throw new IllegalArgumentException("Username obbligatorio");
        if (utente.getEmail() == null) throw new IllegalArgumentException("Email obbligatoria");
        return utenteRepository.save(utente);
    }
}
