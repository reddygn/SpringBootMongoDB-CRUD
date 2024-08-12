package com.naveen.Spring_mongodb_crud.util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Naveen Reddy
 * @project Spring-mongodb-crud
 */

@Configuration
public class MongoConnectionConfig {

    public @Bean MongoClient mongoClient() {
        return MongoClients.create("");
    }

}
