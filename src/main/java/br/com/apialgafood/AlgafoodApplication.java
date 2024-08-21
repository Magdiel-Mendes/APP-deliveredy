package br.com.apialgafood;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.apialgafood.infraistructor.repository.CustomRepositoryIpml;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryIpml.class)
public class AlgafoodApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(AlgafoodApplication.class, args);
	}

}
