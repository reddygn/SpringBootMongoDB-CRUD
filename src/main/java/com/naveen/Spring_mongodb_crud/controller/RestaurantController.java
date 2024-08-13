package com.naveen.Spring_mongodb_crud.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.naveen.Spring_mongodb_crud.service.RestaurantService;
import org.bson.Document;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.Map;

/**
 * @author Naveen Reddy
 * @project Spring-mongodb-crud
 */
@RequestMapping("/api/restaurants")
@RestController
public class RestaurantController {


    @Autowired
    RestaurantService mongoService;


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

    @PostMapping("/{id}")
    public Document updateRestaurant(@RequestBody Document inputData, @PathVariable String id) {
        return mongoService.updateRestaurant(inputData, id);
    }

}
