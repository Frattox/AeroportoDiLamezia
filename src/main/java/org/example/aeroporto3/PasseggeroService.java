package org.example.aeroporto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasseggeroService {
    @Autowired
    private PasseggeroRepository passeggeroRepository;

    public Passeggero savePasseggero(Passeggero passeggero){
        if(!passeggeroRepository.existsByCf(passeggero.getCf()))
            passeggeroRepository.save(passeggero);
        return passeggero;
    }

    public List<Passeggero> getAll(){
        return passeggeroRepository.findAll();
    }
}
