package com.benz;

import com.benz.framework.jpa.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class BenzAcApplication {
	public static void main(String[] args) {
		SpringApplication.run(BenzAcApplication.class, args);
	}
}
