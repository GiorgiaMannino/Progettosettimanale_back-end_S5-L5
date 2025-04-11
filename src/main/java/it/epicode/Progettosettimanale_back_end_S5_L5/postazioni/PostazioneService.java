package it.epicode.Progettosettimanale_back_end_S5_L5.postazioni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    PostazioneRepository postazioneRepository;

    public Postazione save(Postazione postazione) {
        if (postazione.getCodice() == null) throw new IllegalArgumentException("Codice obbligatorio");
        return postazioneRepository.save(postazione);
    }

    public void ricercaPostazioni(TipoPostazione tipoRicercato, String cittaRicercata) {
        List<Postazione> postazioniTrovate = postazioneRepository.findByTipoAndEdificio_Citta(tipoRicercato, cittaRicercata);

        if (postazioniTrovate.isEmpty()) {
            System.out.println("Nessuna postazione trovata per tipo " + tipoRicercato + " a " + cittaRicercata);
        } else {
            System.out.println("Postazioni trovate per tipo " + tipoRicercato + " a " + cittaRicercata + ":");
            postazioniTrovate.forEach(p ->
                    System.out.println("Codice: " + p.getCodice() + ", Descrizione: " + p.getDescrizione()));
        }
        System.out.println();
    }
}
