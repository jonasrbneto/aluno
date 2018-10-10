package br.com.estudo.aluno.domain.controller;

import br.com.estudo.domain.estudante.controller.EstudanteController;
import br.com.estudo.entity.Estudante;
import br.com.estudo.entity.repository.EstudanteRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EstudanteRepositoryTest {

    Logger logger = LogManager.getLogger(EstudanteRepositoryTest.class);

    private EstudanteController subject;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Test
    public void createEstudante() {
        Estudante estudante = new Estudante("João Teste", LocalDate.now(), "CURSO DE TESTE", "PREDIO TESTE");

        estudante = estudanteRepository.save(estudante);
        Optional<Estudante> byId = estudanteRepository.findById(1);

        Assert.assertEquals(byId.get().getId(), estudante.getId());
        Assert.assertEquals(byId.get().getDtNascimento(), estudante.getDtNascimento());
        Assert.assertEquals(byId.get().getNome(), estudante.getNome());
    }

}
