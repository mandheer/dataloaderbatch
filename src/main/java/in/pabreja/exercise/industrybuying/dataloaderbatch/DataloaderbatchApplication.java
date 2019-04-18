package in.pabreja.exercise.industrybuying.dataloaderbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataloaderbatchApplication {

	public static final Logger log = LoggerFactory.getLogger(DataloaderbatchApplication.class);

	public static void main(String[] args) {
		log.info("Starting the application...");
		SpringApplication.run(DataloaderbatchApplication.class, args);
		log.info("Application completed successfully...");
	}

}
