package powersthegreat.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

import powersthegreat.runnerz.run.Run;
import powersthegreat.runnerz.run.Location;
import powersthegreat.runnerz.run.RunRepository;
import powersthegreat.runnerz.user.UserRestClient;
import powersthegreat.runnerz.user.User;

@SpringBootApplication
public class RunnerzApplication {
	
	private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
		log.info("RunnerzApplication started successfully!");
	}

    @Bean
    CommandLineRunner runner(UserRestClient client) {
        return args -> {
            List<User> users = client.findAll();
            System.out.println(users);
        };
    }
    
}
