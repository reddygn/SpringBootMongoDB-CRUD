package com.naveen.Spring_mongodb_crud.controller;

import com.naveen.Spring_mongodb_crud.service.RestaurantService;
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

    @PutMapping("/{id}")
    public Document updateRestaurant(@RequestBody Document inputData, @PathVariable String id) {
        return mongoService.updateRestaurant(inputData, id);
    }

    @PostMapping("")
    public boolean addRestaurant(@RequestBody Document inputData) {
        return mongoService.addRestaurant(inputData);
    }

}
