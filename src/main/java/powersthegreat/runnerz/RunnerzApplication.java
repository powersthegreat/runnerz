package powersthegreat.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

import powersthegreat.runnerz.run.Run;
import powersthegreat.runnerz.run.Location;

@SpringBootApplication
public class RunnerzApplication {
	
	private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
		log.info("RunnerzApplication started successfully!");
	}

	@Bean
    CommandLineRunner runner() {
        return args -> {
            Run run = new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR);
            log.info("Run: {}", run);
        };
    }
}
