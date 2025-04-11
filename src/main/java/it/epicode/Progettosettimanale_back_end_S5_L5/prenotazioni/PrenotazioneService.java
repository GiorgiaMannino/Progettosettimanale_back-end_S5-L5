package it.epicode.Progettosettimanale_back_end_S5_L5.prenotazioni;

import it.epicode.Progettosettimanale_back_end_S5_L5.postazioni.Postazione;
import it.epicode.Progettosettimanale_back_end_S5_L5.postazioni.PostazioneRepository;
import it.epicode.Progettosettimanale_back_end_S5_L5.utenti.Utente;
import it.epicode.Progettosettimanale_back_end_S5_L5.utenti.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    public void prenota(Postazione postazione, Utente utente, LocalDate data) {
        System.out.println("--------- Prenotazione: " + utente.getNomeCompleto() + " per il " + data + " ---------");

        Prenotazione existingPrenotazione = prenotazioneRepository.findByPostazioneAndUtenteAndData(postazione, utente, data);
        if (existingPrenotazione != null) {
            System.out.println("L'utente " + utente.getNomeCompleto() + " ha già una prenotazione per questa postazione il " + data);
            System.out.println(" ");
            return;
        }

        boolean isPostazioneOccupata = prenotazioneRepository.existsByPostazioneAndData(postazione, data);
        if (isPostazioneOccupata) {
            System.out.println("La postazione è già occupata per il " + data);
            System.out.println(" ");
            return;
        }

        Prenotazione prenotazione = new Prenotazione(postazione, utente, data);
        prenotazioneRepository.save(prenotazione);

        System.out.println("Prenotazione effettuata per " + utente.getNomeCompleto() + " alla postazione " + postazione.getCodice() + " il " + data);
        System.out.println(" ");
    }
}
