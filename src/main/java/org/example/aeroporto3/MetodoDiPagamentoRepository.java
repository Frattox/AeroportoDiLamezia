package org.example.aeroporto3;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MetodoDiPagamentoRepository extends JpaRepository<MetodoDiPagamento,Integer> {
    boolean existsByNumero(int numero);
}
