package it.epicode.Progettosettimanale_back_end_S5_L5.postazioni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostazioneService {

    @Autowired
    PostazioneRepository postazioneRepository;

    public Postazione save(Postazione postazione) {
        if (postazione.getCodice() == null) throw new IllegalArgumentException("Codice obbligatorio");
        return postazioneRepository.save(postazione);
    }
}
