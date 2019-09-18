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

import java.util.HashMap;

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
        CategoriesList categoriesList = restTemplate.getForObject("http://categories-service/categories", CategoriesList.class);
        Catalog catalog = new Catalog();
        catalog.setCategoriesData(categoriesList.getCategories());

        catalog.setCategories(new HashMap<>());
        categoriesList.getCategories()
                .forEach(c -> {
                    ProductsList productsList = restTemplate.getForObject("http://products-service/products/by_category/" + c.getId(), ProductsList.class);
                    catalog.getCategories().put(c.getId(), new CatalogCategory(productsList.getProducts()));
                });
        return catalog;
    }
}
