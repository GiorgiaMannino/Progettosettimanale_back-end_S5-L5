package it.epicode.Progettosettimanale_back_end_S5_L5.prenotazioni;

import it.epicode.Progettosettimanale_back_end_S5_L5.postazioni.Postazione;
import it.epicode.Progettosettimanale_back_end_S5_L5.utenti.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByPostazioneAndData(Postazione postazione, LocalDate data);
    Prenotazione findByPostazioneAndUtenteAndData(Postazione postazione, Utente utente, LocalDate data);
}
