package it.epicode.Progettosettimanale_back_end_S5_L5.common;

import it.epicode.Progettosettimanale_back_end_S5_L5.edifici.Edificio;
import it.epicode.Progettosettimanale_back_end_S5_L5.edifici.EdificioRepository;
import it.epicode.Progettosettimanale_back_end_S5_L5.edifici.EdificioService;
import it.epicode.Progettosettimanale_back_end_S5_L5.postazioni.Postazione;
import it.epicode.Progettosettimanale_back_end_S5_L5.postazioni.PostazioneRepository;
import it.epicode.Progettosettimanale_back_end_S5_L5.postazioni.PostazioneService;
import it.epicode.Progettosettimanale_back_end_S5_L5.postazioni.TipoPostazione;
import it.epicode.Progettosettimanale_back_end_S5_L5.prenotazioni.PrenotazioneRepository;
import it.epicode.Progettosettimanale_back_end_S5_L5.prenotazioni.PrenotazioneService;
import it.epicode.Progettosettimanale_back_end_S5_L5.utenti.Utente;
import it.epicode.Progettosettimanale_back_end_S5_L5.utenti.UtenteRepository;
import it.epicode.Progettosettimanale_back_end_S5_L5.utenti.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class CommonRunner implements CommandLineRunner {

    @Autowired
    EdificioRepository edificioRepository;
    @Autowired
    PostazioneRepository postazioneRepository;
    @Autowired
    UtenteRepository utenteRepository;
    @Autowired
    PrenotazioneRepository prenotazioneRepository;

    @Autowired
    EdificioService edificioService;
    @Autowired
    PostazioneService postazioneService;
    @Autowired
    UtenteService utenteService;
    @Autowired
    PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {
        // Creo edifici
        Edificio edificio1 = new Edificio(null, "Edificio A", "Via Roma 100", "Milano", null);
        edificioService.save(edificio1);
        Edificio edificio2 = new Edificio(null, "Edificio B", "Corso Italia 200", "Palermo", null);
        edificioService.save(edificio2);
        Edificio edificio3 = new Edificio(null, "Edificio C", "Via Torino 300", "Torino", null);
        edificioService.save(edificio3);

        System.out.println(" ");
        System.out.println("Edifici salvati");

        // Creo postazioni
        Postazione postazione1 = new Postazione(null, "P001", "Postazione privata", TipoPostazione.PRIVATO, 1, edificio1, null);
        postazioneService.save(postazione1);
        Postazione postazione2 = new Postazione(null, "P002", "Openspace moderno", TipoPostazione.OPENSPACE, 10, edificio1, null);
        postazioneService.save(postazione2);
        Postazione postazione3 = new Postazione(null, "P003", "Sala riunioni", TipoPostazione.SALA_RIUNIONI, 6, edificio2, null);
        postazioneService.save(postazione3);

        System.out.println("Postazioni salvate");

        // Creo utenti
        Utente utente1 = new Utente(null, "mariorossi", "Mario Rossi", "mario.rossi@email.com", null);
        utenteService.save(utente1);
        Utente utente2 = new Utente(null, "lucabianchi", "Luca Bianchi", "luca.bianchi@email.com", null);
        utenteService.save(utente2);
        Utente utente3 = new Utente(null, "annaverdi", "Anna Verdi", "anna.verdi@email.com", null);
        utenteService.save(utente3);
        Utente utente4 = new Utente(null, "giuseppeneri", "Giuseppe Neri", "giuseppe.neri@email.com", null);
        utenteService.save(utente4);

        System.out.println("Utenti salvati ");
        System.out.println(" ");
        System.out.println("-------------------------------------------------------");
        System.out.println(" ");


        // Creo prenotazioni tramite il servizio
        prenotazioneService.prenota(postazione1, utente1, LocalDate.of(2025, 4, 18));
        prenotazioneService.prenota(postazione1, utente1, LocalDate.of(2025, 4, 18)); // FALLIRÀ perchè l'utente inserito è già prenotato
        prenotazioneService.prenota(postazione1, utente2, LocalDate.of(2025, 4, 18)); // FALLIRÀ perchè la postazione è già prenotata da un altro utente

        prenotazioneService.prenota(postazione3, utente3, LocalDate.of(2025, 4, 18));// NON FALLITÀ perchè si può prenotare per la stessa data ma in postazioni diverse
        prenotazioneService.prenota(postazione3, utente4, LocalDate.of(2025, 4, 20));

        System.out.println("-------------------------------------------------------");
        System.out.println(" ");
        System.out.println("--------- Ricerca postazioni per tipo e città ---------");
        System.out.println(" ");

        // Ricerca postazioni per tipo e città
        postazioneService.ricercaPostazioni(TipoPostazione.PRIVATO, "Milano");
        postazioneService.ricercaPostazioni(TipoPostazione.SALA_RIUNIONI, "Palermo");
        postazioneService.ricercaPostazioni(TipoPostazione.PRIVATO, "Torino");

    }

}
