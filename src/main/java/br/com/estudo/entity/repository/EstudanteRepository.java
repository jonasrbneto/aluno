package br.com.estudo.entity.repository;

import br.com.estudo.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante, Integer> {
}
