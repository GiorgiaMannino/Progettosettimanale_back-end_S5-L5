package it.epicode.Progettosettimanale_back_end_S5_L5.postazioni;

import it.epicode.Progettosettimanale_back_end_S5_L5.edifici.Edificio;
import it.epicode.Progettosettimanale_back_end_S5_L5.prenotazioni.Prenotazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "postazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Postazione {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column (nullable = false, length = 50)
    private String codice;

    @Column (length = 100)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;

    private int maxOccupanti;

    @ManyToOne
    private Edificio edificio;

    @OneToMany (mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;
}