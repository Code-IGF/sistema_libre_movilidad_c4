package fia.ues.sistema_libre_movilidad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SistemaLibreMovilidadApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SistemaLibreMovilidadApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SistemaLibreMovilidadApplication.class, args);
	}

}
