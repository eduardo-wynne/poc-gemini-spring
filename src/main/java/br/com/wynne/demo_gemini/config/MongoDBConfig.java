package br.com.wynne.demo_gemini.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("br.com.wynne.demo_gemini")
public class MongoDBConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "corretion";
    }

    protected String getMappingBasePackage(){
        return "br.com.wynne.demo_gemini";
    }
}
