package br.com.estudo.domain.estudante.service;

import br.com.estudo.entity.Estudante;
import br.com.estudo.entity.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class EstudanteService {

    private final EstudanteRepository estudanteRepository;

    @Autowired
    public EstudanteService(final EstudanteRepository estudanteRepository) {
        this.estudanteRepository = estudanteRepository;
    }

    public Estudante create(final Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    public void delete(Integer id) {

        estudanteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        estudanteRepository.deleteById(id);
    }

    public Estudante find(final Integer id) {
        return estudanteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

    }
}
