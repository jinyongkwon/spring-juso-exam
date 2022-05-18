package site.metacoding.addressapitest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AddressapitestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressapitestApplication.class, args);
	}

}
