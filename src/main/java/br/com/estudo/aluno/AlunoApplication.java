package br.com.estudo.aluno;

import br.com.infraestrutura.configuration.AlunoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Import(AlunoConfiguration.class)
@SpringBootApplication(scanBasePackages = {"br.com.estudo.domain.estudante"})
public class AlunoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlunoApplication.class, args);
    }
}
