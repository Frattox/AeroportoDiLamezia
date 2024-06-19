package org.example.aeroporto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metodoPagamento")
public class MetodoDiPagamentoController {
    @Autowired
    private MetodoDiPagamentoService metodoDiPagamentoService;

    @PostMapping
    public ResponseEntity<MetodoDiPagamento> createMetodoDiPagamento(@RequestBody MetodoDiPagamento metodoDiPagamento){
        MetodoDiPagamento m = metodoDiPagamentoService.saveMetodoDiPagamento(metodoDiPagamento);
        return new ResponseEntity<>(m, HttpStatus.CREATED);
    }

}
