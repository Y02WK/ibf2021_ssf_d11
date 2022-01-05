package main.demo;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication {

	private static final Logger logger = LoggerFactory.getLogger(MyApplication.class);
	private static final String DEFAULT_PORT = "3000";

	public static void main(String[] args) {
		// init Spring app
		SpringApplication app = new SpringApplication(MyApplication.class);

		// decode app args using Spring args helper
		ApplicationArguments cliArgs = new DefaultApplicationArguments(args);

		// init port as default port value
		String port = DEFAULT_PORT;

		// checks if cli contains port option
		if (cliArgs.containsOption("port")) {
			port = cliArgs.getOptionValues("port").get(0);
			// else checks if PORT environment variable is set
		} else if (System.getenv("PORT") != null) {
			port = System.getenv("PORT");
		}

		// log port
		logger.info("Port is " + port);

		// override spring boot app server port to the port specified
		app.setDefaultProperties(Collections.singletonMap("server.port", port));
		app.run(args);
	}
}
