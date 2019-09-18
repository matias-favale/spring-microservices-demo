package com.belatrix.meetup.catalogservice.services;

import com.belatrix.meetup.catalogservice.model.CategoriesList;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * @author Matias Favale.
 */
@Service
public class CategoryService {
    
    @Autowired
    private RestTemplate restTemplate;;
    
    @HystrixCommand(fallbackMethod = "getFallbackCategory",
        commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
        } 
    )
    public CategoriesList getCategories() {
        return restTemplate.getForObject("http://categories-service/categories", CategoriesList.class);
    }
    
    private CategoriesList getFallbackCategory() {
        return new CategoriesList(Collections.emptyList());
    }
}
