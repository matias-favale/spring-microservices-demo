package com.belatrix.meetup.catalogservice.controllers;

import com.belatrix.meetup.catalogservice.model.Catalog;
import com.belatrix.meetup.catalogservice.model.CatalogCategory;
import com.belatrix.meetup.catalogservice.model.CategoriesList;
import com.belatrix.meetup.catalogservice.model.ProductsList;
import com.belatrix.meetup.catalogservice.services.CategoryService;
import com.belatrix.meetup.catalogservice.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Matias Favale.
 */
@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ProductsService productsService;

    @GetMapping
    public Catalog getCatalog() {
        CategoriesList categoriesList = categoryService.getCategories();
        Catalog catalog = new Catalog();
        catalog.setCategoriesData(categoriesList.getCategories());

        catalog.setCategories(new HashMap<>());
        categoriesList.getCategories()
                .forEach(c -> {
                    ProductsList productsList = productsService.getProducts(c.getId());
                    catalog.getCategories().put(c.getId(), new CatalogCategory(productsList.getProducts()));
                });
        return catalog;
    }
}
