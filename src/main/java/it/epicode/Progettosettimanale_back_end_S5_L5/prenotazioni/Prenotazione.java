package it.epicode.Progettosettimanale_back_end_S5_L5.prenotazioni;

import it.epicode.Progettosettimanale_back_end_S5_L5.postazioni.Postazione;
import it.epicode.Progettosettimanale_back_end_S5_L5.utenti.Utente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table (name = "prenotazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column (nullable = false)
    private LocalDate data;

    @ManyToOne
    private Utente utente;

    @ManyToOne
    private Postazione postazione;

    public Prenotazione(Postazione postazione, Utente utente, LocalDate data) {
        this.postazione = postazione;
        this.utente = utente;
        this.data = data;
    }

}
