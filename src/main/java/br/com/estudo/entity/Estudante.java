package br.com.estudo.entity;

import org.apache.tomcat.jni.Local;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "estudante")
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dt_nascimento")
    private LocalDate dtNascimento;

    @Column(name = "curso")
    private String curso;

    @Column(name = "predio")
    private String predio;

    @Deprecated
    public Estudante() {
    }

    public Estudante(String nome, LocalDate dtNascimento, String curso, String predio) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.curso = curso;
        this.predio = predio;
    }

    public Integer getId() {
        return id;
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

    public static class EstudanteBuilder {
        private String nome;
        private LocalDate dtNascimento;
        private String curso;
        private String predio;

        public EstudanteBuilder withNome(final String nome) {
            this.nome = nome;
            return this;
        }

        public EstudanteBuilder withDtNascimento(final LocalDate dtNascimento) {
            this.dtNascimento = dtNascimento;
            return this;
        }

        public EstudanteBuilder withCurso(final String curso) {
            this.curso = curso;
            return this;
        }

        public EstudanteBuilder withPredio(final String predio) {
            this.predio = predio;
            return this;
        }

        public Estudante build() {
            return new Estudante(nome, dtNascimento, curso, predio);
        }


    }

}
