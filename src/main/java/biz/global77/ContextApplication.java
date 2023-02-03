package biz.global77;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"biz.global77"})
@EnableJpaRepositories("biz.global77.repository")
@EntityScan("biz.global77.model")
public class ContextApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContextApplication.class, args);
	}

}
