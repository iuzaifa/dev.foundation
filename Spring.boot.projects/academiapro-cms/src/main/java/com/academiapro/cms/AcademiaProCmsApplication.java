package com.academiapro.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AcademiaProCmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademiaProCmsApplication.class, args);
        System.out.println("AcademiaProCmsApplication.............../");
	}

}
