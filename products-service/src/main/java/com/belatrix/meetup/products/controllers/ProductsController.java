package com.belatrix.meetup.products.controllers;

import com.belatrix.meetup.products.model.Product;
import com.belatrix.meetup.products.model.ProductsList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Matias Favale.
 */
@RestController
@RequestMapping("/products")
public class ProductsController {

    @GetMapping
    public ProductsList list() {
        return mockedList();
    }

    @GetMapping("/{code}")
    public Product getProduct(@PathVariable("code") String code) {
        return mockedList()
                .getProducts()
                .stream()
                .filter(p -> p.getCode().equals(code))
                .findFirst()
                .get();
    }

    @GetMapping("/by_category/{categoryId}")
    public ProductsList productsInCategory(@PathVariable("categoryId") Long categoryId) {
        ProductsList byCat = mockedList();
        byCat.setProducts(byCat.getProducts()
                .stream()
                .filter(product -> product.getCategoryId().equals(categoryId))
                .collect(Collectors.toList())
        );
        return byCat;
    }

    private ProductsList mockedList() {
        return new ProductsList(Arrays.asList(
                new Product("1", "Somsang Golaxy S10", 60000f, 1L),
                new Product("2", "Pineapple PhoneI XS", 200000f, 1L),
                new Product("3", "Aire Acondicionado Inverter", 20000f, 2L),
                new Product("4", "Cortina de baño", 200f, 2L),
                new Product("5", "Remera", 400f, 3L),
                new Product("6", "Pantalon Jean Lovis", 4000f, 3L)
        ));
    }
}
