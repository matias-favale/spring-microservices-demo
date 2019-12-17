package com.belatrix.meetup.categories.controllers;

import com.belatrix.meetup.categories.model.CategoriesList;
import com.belatrix.meetup.categories.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author Matias Favale.
 */
@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @GetMapping
    public CategoriesList list() {
        return new CategoriesList(Arrays.asList(
            new Category(1L, "Tecnologia"),
            new Category(2L, "Hogar y Electrodomesticos"),
            new Category(3L, "Moda")));
    }
}
