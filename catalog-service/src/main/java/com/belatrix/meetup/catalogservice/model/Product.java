package com.belatrix.meetup.catalogservice.model;

/**
 * @author Matias Favale.
 */
public class Product {
    private String code;
    private String name;
    private Float price;
    private Long categoryId;

    public Product() {
    }

    public Product(final String code, final String name, final Float price, final Long categoryId) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
