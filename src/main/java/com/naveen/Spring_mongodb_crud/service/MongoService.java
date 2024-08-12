package com.naveen.Spring_mongodb_crud.service;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.naveen.Spring_mongodb_crud.util.MongoConnectionConfig;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.naveen.Spring_mongodb_crud.util.SpringBootMongoConstants.SAMPLE_COLLECTION;
import static com.naveen.Spring_mongodb_crud.util.SpringBootMongoConstants.SAMPLE_DATABASE;

/**
 * @author Naveen Reddy
 * @project Spring-mongodb-crud
 */

@Service
public class MongoService {


    MongoConnectionConfig mongoConnectionConfig = new MongoConnectionConfig();
    MongoClient mongoClient = mongoConnectionConfig.mongoClient();


    public List<Document> getAllRestaurants() {

        List<Document> documents = new ArrayList<>();
        MongoDatabase restaurantsDataStore = mongoClient.getDatabase(SAMPLE_DATABASE);
        MongoCollection<Document> restaurantsCollection = restaurantsDataStore.getCollection(SAMPLE_COLLECTION);

        for (Document document : restaurantsCollection.find().limit(10)) {
            documents.add(document);
        }

        return documents;
    }

    public List<Document> getRestaurantsById(long id) {

        List<Document> documents = new ArrayList<>();
        MongoDatabase restaurantsDataStore = mongoClient.getDatabase(SAMPLE_DATABASE);
        MongoCollection<Document> restaurantsCollection = restaurantsDataStore.getCollection(SAMPLE_COLLECTION);

        Bson filter = Filters.eq("restaurant_id", String.valueOf(id));
        FindIterable<Document> results = restaurantsCollection.find(filter);

        for (Document document : results) {
            documents.add(document);
        }
        return documents;
    }

    public List<Document> getRestaurantsByCuisine(String cuisine) {

        List<Document> documents = new ArrayList<>();
        MongoDatabase restaurantsDataStore = mongoClient.getDatabase(SAMPLE_DATABASE);
        MongoCollection<Document> restaurantsCollection = restaurantsDataStore.getCollection(SAMPLE_COLLECTION);

        Bson filter = Filters.eq("cuisine", cuisine);
        FindIterable<Document> results = restaurantsCollection.find(filter).limit(5);

        for (Document document : results) {
            documents.add(document);
        }
        return documents;

    }
}
