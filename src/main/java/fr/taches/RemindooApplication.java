package fr.taches;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import fr.taches.jms.Consumer;

@SpringBootApplication
public class RemindooApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {

		SpringApplication.run(RemindooApplication.class, args);

		Thread thread = new Thread(new Consumer());
		thread.run();

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RemindooApplication.class);
	}
}

