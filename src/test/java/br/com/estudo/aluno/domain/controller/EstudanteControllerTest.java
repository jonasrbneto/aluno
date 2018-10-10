package br.com.estudo.aluno.domain.controller;

import br.com.estudo.domain.estudante.application.EstudanteApplication;
import br.com.estudo.domain.estudante.controller.EstudanteController;
import br.com.estudo.entity.Estudante;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = EstudanteApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
@DataJpaTest
public class EstudanteControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EstudanteApplication estudanteApplication;

    @Test
    public void shouldCreatedAEstudante() throws Exception {

        Estudante estudante = new Estudante("João Teste", LocalDate.now(), "CURSO DE TESTE", "PREDIO TESTE");

        mvc.perform(MockMvcRequestBuilders.post("/api/estudante")
                .content(asJsonString(estudante))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
