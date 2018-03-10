package show.products.javatask172.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import show.products.javatask172.model.Product;
import show.products.javatask172.model.Products;
import show.products.javatask172.utils.DisplayCategory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/")
public class MenuController {
    private Products products;

    public MenuController(Products products) {
        this.products = products;
    }

    String p;

    // display products
    @ResponseBody
    @RequestMapping("/allProducts")
    public String allProducts(@RequestParam(required = false) String category, Model model) {
        List<Product> listOfProducts;
        if (category != null) {
            List<Product> productsByCategory = DisplayCategory.displayProductByCategory(products.getProducts(), category);
            listOfProducts = productsByCategory;
        } else {
            listOfProducts = products.getProducts();
        }
        return DisplayCategory.displayResult(listOfProducts, category);
    }
}
