package br.com.estudo.domain.estudante.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class EstudanteVO {

    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dtNascimento;

    private String curso;

    private String predio;

    @JsonCreator
    public EstudanteVO(@JsonProperty("nome") String nome, @JsonProperty("dtNascimento") LocalDate dtNascimento,
                       @JsonProperty("curso") String curso, @JsonProperty("predio") String predio) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.curso = curso;
        this.predio = predio;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public String getCurso() {
        return curso;
    }

    public String getPredio() {
        return predio;
    }
}
