package org.example.aeroporto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passeggeri")
public class PasseggeroController {

    @Autowired
    private PasseggeroRepository passeggeroRepository;

    @GetMapping("/ciao")
    public List<Passeggero> getAllPasseggeri(){
        return passeggeroRepository.findAll();
    }

    @PostMapping
    public Optional<Passeggero> createPasseggero(@RequestBody Passeggero passeggero){
        return null;
    }
}
