package org.example.aeroporto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetodoDiPagamentoService {
    @Autowired
    private MetodoDiPagamentoRepository metodoDiPagamentoRepository;

    public MetodoDiPagamento saveMetodoDiPagamento(MetodoDiPagamento metodoDiPagamento){
        if(!metodoDiPagamentoRepository.existsByNumero(metodoDiPagamento.getNumero()))
            metodoDiPagamentoRepository.save(metodoDiPagamento);
        return metodoDiPagamento;
    }
}
