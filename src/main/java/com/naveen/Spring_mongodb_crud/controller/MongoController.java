package com.naveen.Spring_mongodb_crud.controller;

import com.naveen.Spring_mongodb_crud.service.MongoService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Naveen Reddy
 * @project Spring-mongodb-crud
 */
@RequestMapping("/api/restaurants")
@RestController
public class MongoController {


    @Autowired
    MongoService mongoService;


    @GetMapping(value = "")
    public List<Document> getAllRestaurants() {
        return mongoService.getAllRestaurants();
    }

    @GetMapping(value = "/{res_id}")
    public List<Document> getRestaurantsById(@PathVariable Long res_id) {
        return mongoService.getRestaurantsById(res_id);
    }

    @GetMapping(value = "/cuisine/{cuisineName}")
    public List<Document> getRestaurantsByCuisine(@PathVariable String cuisineName) {
        return mongoService.getRestaurantsByCuisine(cuisineName);
    }

}
