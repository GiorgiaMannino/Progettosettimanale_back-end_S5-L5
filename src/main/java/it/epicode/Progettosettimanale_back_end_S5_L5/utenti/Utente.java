package it.epicode.Progettosettimanale_back_end_S5_L5.utenti;

import it.epicode.Progettosettimanale_back_end_S5_L5.prenotazioni.Prenotazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "utenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utente {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column (nullable = false, length = 50)
    private String username;

    @Column (nullable = false, length = 100)
    private String nomeCompleto;

    @Column (length = 100)
    private String email;

    @OneToMany (mappedBy = "utente")
    private List <Prenotazione> prenotazioni;


}
