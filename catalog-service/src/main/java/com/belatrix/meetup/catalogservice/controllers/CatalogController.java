package com.belatrix.meetup.catalogservice.controllers;

import com.belatrix.meetup.catalogservice.model.Catalog;
import com.belatrix.meetup.catalogservice.model.CatalogCategory;
import com.belatrix.meetup.catalogservice.model.CategoriesList;
import com.belatrix.meetup.catalogservice.model.ProductsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Matias Favale.
 */
@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public Catalog getCatalog() {
        // Get all categories with their data
        CategoriesList categoriesList = restTemplate.getForObject("http://localhost:9002/categories", CategoriesList.class);
        Catalog catalog = new Catalog();
        catalog.setCategoriesData(categoriesList.getCategories());

        // Populate products by category list
        categoriesList.getCategories()
                .forEach(c -> {
                    ProductsList productsList = restTemplate.getForObject("http://localhost:9001/products/by_category/" + c.getId(), ProductsList.class);
                    catalog.getCategories().put(c.getId(), new CatalogCategory(productsList.getProducts()));
                });
        return catalog;
    }
}
