package br.com.estudo.domain.estudante.controller;

import br.com.estudo.domain.estudante.application.EstudanteApplication;
import br.com.estudo.domain.estudante.vo.EstudanteVO;
import br.com.estudo.entity.Estudante;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/estudante")
public class EstudanteController {

    Logger logger = Logger.getLogger("EstudanteController");

    private final EstudanteApplication estudanteApplication;

    public EstudanteController(final EstudanteApplication estudanteApplication) {
        this.estudanteApplication = estudanteApplication;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createEstudante(EstudanteVO estudanteVO) {

        logger.info("Sucesso");


        Estudante estudante = estudanteApplication.create(estudanteVO);

        return ResponseEntity.ok(estudante.getId());
    }

}
