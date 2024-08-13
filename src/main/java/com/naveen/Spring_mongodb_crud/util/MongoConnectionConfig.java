package com.naveen.Spring_mongodb_crud.util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Naveen Reddy
 * @project Spring-mongodb-crud
 */

@Configuration
public class MongoConnectionConfig {

    private MongoClient mongoClient;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("");
    }

    @PreDestroy
    public void closeMongoClient() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

}
