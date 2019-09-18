package com.belatrix.meetup.catalogservice.services;

import com.belatrix.meetup.catalogservice.model.ProductsList;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * @author Matias Favale.
 */
@Service
public class ProductsService {
    @Autowired
    private RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod = "getFallbackProducts")
    public ProductsList getProducts(final Long categoryId) {
        return restTemplate.getForObject("http://products-service/products/by_category/" + categoryId, ProductsList.class);
    }
    
    public ProductsList getFallbackProducts(final Long categoryId) {
        return new ProductsList(Collections.emptyList());
    }
}
