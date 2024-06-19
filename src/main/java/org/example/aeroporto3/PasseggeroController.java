package org.example.aeroporto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passeggeri")
public class PasseggeroController {

    @Autowired
    private PasseggeroService passeggeroService;

    @GetMapping()
    public List<Passeggero> getAllPasseggeri(){
        return passeggeroService.getAll();
    }

    @GetMapping("/esempio")
    public String esempio(){
        return "Esempio";
    }

    @PostMapping
    public ResponseEntity<Passeggero> createPasseggero(@RequestBody Passeggero passeggero){
        Passeggero savedPasseggero = passeggeroService.savePasseggero(passeggero);
        return new ResponseEntity<>(savedPasseggero, HttpStatus.CREATED);
    }
}
