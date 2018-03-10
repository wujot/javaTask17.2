package show.products.javatask172.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import show.products.javatask172.model.Product;
import show.products.javatask172.model.Products;
import show.products.javatask172.utils.DisplayCategory;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    private Products products;

    private HomeController(Products products) {
        this.products = products;
    }

    // display homepage
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
