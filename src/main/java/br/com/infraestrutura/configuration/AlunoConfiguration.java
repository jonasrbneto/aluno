package br.com.infraestrutura.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = "br.com.estudo.entity")
@EnableJpaRepositories("br.com.estudo.entity")
public class AlunoConfiguration {
}
