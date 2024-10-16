package br.com.wynne.demo_gemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DemoDeminiApplication {

	public @Bean com.mongodb.client.MongoClient mongoClient() {
		return com.mongodb.client.MongoClients.create("mongodb://localhost:27017");
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoDeminiApplication.class, args);
	}

}
