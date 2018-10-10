package br.com.estudo.domain.estudante.application;

import br.com.estudo.domain.estudante.converter.EstudantoConverter;
import br.com.estudo.domain.estudante.service.EstudanteService;
import br.com.estudo.entity.Estudante;
import br.com.estudo.domain.estudante.vo.EstudanteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstudanteApplication {

    private final EstudantoConverter converter;
    private final EstudanteService estudanteService;

    @Autowired
    public EstudanteApplication(final EstudantoConverter converter, final EstudanteService estudanteService) {
        this.converter = converter;
        this.estudanteService = estudanteService;
    }

    public Estudante create(EstudanteVO estudanteVO) {
        Estudante estudante = converter.convert(estudanteVO);
        return estudanteService.create(estudante);
    }

    public void delete(Integer id) {
        estudanteService.delete(id);
    }

    public Estudante find(final Integer id) {
        return estudanteService.find(id);
    }

}
