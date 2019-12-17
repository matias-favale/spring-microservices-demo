package com.belatrix.meetup.catalogservice.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Matias Favale.
 */
public class Catalog {

    private List<Category> categoriesData;
    private Map<Long, CatalogCategory> categories = new HashMap<>();

    public Catalog() {
    }

    public Catalog(List<Category> categoriesData, Map<Long, CatalogCategory> categories) {
        this.categoriesData = categoriesData;
        this.categories = categories;
    }

    public List<Category> getCategoriesData() {
        return categoriesData;
    }

    public void setCategoriesData(List<Category> categoriesData) {
        this.categoriesData = categoriesData;
    }

    public Map<Long, CatalogCategory> getCategories() {
        return categories;
    }

    public void setCategories(Map<Long, CatalogCategory> categories) {
        this.categories = categories;
    }
}
