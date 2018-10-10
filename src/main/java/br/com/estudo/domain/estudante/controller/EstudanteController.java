package br.com.estudo.domain.estudante.controller;

import br.com.estudo.domain.estudante.application.EstudanteApplication;
import br.com.estudo.domain.estudante.vo.EstudanteVO;
import br.com.estudo.entity.Estudante;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/estudante")
public class EstudanteController {

    Logger logger = LogManager.getLogger(EstudanteController.class);

    private final EstudanteApplication estudanteApplication;

    @Autowired
    public EstudanteController(final EstudanteApplication estudanteApplication) {
        this.estudanteApplication = estudanteApplication;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createEstudante(@RequestBody EstudanteVO estudanteVO) {

        logger.info("Estudante criado " + estudanteVO.toString());
        Estudante estudante = estudanteApplication.create(estudanteVO);

        return ResponseEntity.ok(estudante.getId());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Integer id) {
        logger.info("Id do Estudante que será deletado: " + id);

        estudanteApplication.delete(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Estudante> find(@PathVariable(value = "id") Integer id) {
        logger.info("find do Estudante: " + id);

        final Estudante estudante = estudanteApplication.find(id);
        return ResponseEntity.ok(estudante);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleContentNotAllowedException(EntityNotFoundException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
