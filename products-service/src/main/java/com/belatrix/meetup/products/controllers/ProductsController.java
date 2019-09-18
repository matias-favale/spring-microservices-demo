package com.belatrix.meetup.products.controllers;

import com.belatrix.meetup.products.model.Product;
import com.belatrix.meetup.products.model.ProductsList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Matias Favale.
 */
@RestController
@RequestMapping("/products")
public class ProductsController {

    @GetMapping
    public ProductsList list() {
        return new ProductsList(Collections.singletonList(new Product("CODE1234", "PRODNAME", 100f, 1L)));
    }

    @GetMapping("/{code}")
    public Product getProduct(@PathVariable("code") String code) {
        return new Product("codecode", "namename", 50f, 2L);
    }

    @GetMapping("/by_category/{categoryId}")
    public ProductsList productsInCategory(@PathVariable("categoryId") Long categoryId) {
        return new ProductsList(Arrays.asList(
                new Product("1234", "PRODNAME", 100f, categoryId),
                new Product("5678", "PRODNAME2", 200f, categoryId)));
    }
}
