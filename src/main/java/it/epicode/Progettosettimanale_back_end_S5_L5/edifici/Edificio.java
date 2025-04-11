package it.epicode.Progettosettimanale_back_end_S5_L5.edifici;

import it.epicode.Progettosettimanale_back_end_S5_L5.postazioni.Postazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "edifici")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column (length = 100)
    private String indirizzo;

    @Column (length = 100)
    private String citta;

    @OneToMany (mappedBy = "edificio")
    private List<Postazione> postazioni;
}
