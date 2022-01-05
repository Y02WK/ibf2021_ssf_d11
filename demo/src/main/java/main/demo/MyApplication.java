package main.demo;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MyApplication.class);

		ApplicationArguments cliArgs = new DefaultApplicationArguments(args);
		if (cliArgs.containsOption("port")) {
			String port = cliArgs.getOptionValues("port").get(0);
			app.setDefaultProperties(Collections.singletonMap("server.port", port));
		}
		app.run(args);
	}
}
