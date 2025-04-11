package it.epicode.Progettosettimanale_back_end_S5_L5.edifici;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {

    @Autowired
    EdificioRepository edificioRepository;

    public Edificio save(Edificio edificio) {
        if (edificio.getNome() == null) throw new IllegalArgumentException("Nome obbligatorio");
        return edificioRepository.save(edificio);
    }

}
