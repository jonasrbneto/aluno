package br.com.estudo.domain.estudante.service;

import br.com.estudo.entity.Estudante;
import br.com.estudo.entity.repository.EstudanteRepository;
import org.springframework.stereotype.Service;

@Service
public class EstudanteService {

    private final EstudanteRepository estudanteRepository;

    public EstudanteService(final EstudanteRepository estudanteRepository) {
        this.estudanteRepository = estudanteRepository;
    }

    public Estudante create(final Estudante estudante) {
        return estudanteRepository.save(estudante);
    }
}
