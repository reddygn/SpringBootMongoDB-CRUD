package com.naveen.Spring_mongodb_crud.service;

import com.mongodb.client.*;
import com.naveen.Spring_mongodb_crud.util.MongoConnectionConfig;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.naveen.Spring_mongodb_crud.util.SpringBootMongoConstants.SAMPLE_COLLECTION;
import static com.naveen.Spring_mongodb_crud.util.SpringBootMongoConstants.SAMPLE_DATABASE;

/**
 * @author Naveen Reddy
 * @project Spring-mongodb-crud
 */

@Service
public class RestaurantService {


    MongoConnectionConfig mongoConnectionConfig = new MongoConnectionConfig();
    MongoClient mongoClient = mongoConnectionConfig.mongoClient();


    public List<Document> getAllRestaurants() {

        List<Document> documents = new ArrayList<>();
        MongoDatabase restaurantsDataStore = mongoClient.getDatabase(SAMPLE_DATABASE);
        MongoCollection<Document> restaurantsCollection = restaurantsDataStore.getCollection(SAMPLE_COLLECTION);

        Bson sort = eq("name", -1);

        for (Document document : restaurantsCollection.find().sort(sort).limit(500)) {
            documents.add(document);
        }
        return documents;
    }

    public List<Document> getRestaurantsById(long id) {

        List<Document> documents = new ArrayList<>();
        MongoDatabase restaurantsDataStore = mongoClient.getDatabase(SAMPLE_DATABASE);
        MongoCollection<Document> restaurantsCollection = restaurantsDataStore.getCollection(SAMPLE_COLLECTION);

        Bson filter = eq("restaurant_id", String.valueOf(id));
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

        Bson filter = eq("cuisine", cuisine);
        FindIterable<Document> results = restaurantsCollection.find(filter).limit(5);

        for (Document document : results) {
            documents.add(document);
        }
        return documents;
    }

    public Document addRestaurant(Document inputData, String id) {

        MongoDatabase restaurantsDataStore = mongoClient.getDatabase(SAMPLE_DATABASE);
        MongoCollection<Document> restaurantsCollection = restaurantsDataStore.getCollection(SAMPLE_COLLECTION);

        Bson filter = eq("_id", new ObjectId(id));
        Document set = new Document("$set", new Document(inputData));

        return restaurantsCollection.findOneAndUpdate(filter, set);
    }
}


