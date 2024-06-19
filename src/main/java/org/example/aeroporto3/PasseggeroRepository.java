package org.example.aeroporto3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasseggeroRepository extends JpaRepository<Passeggero,String> {
}
