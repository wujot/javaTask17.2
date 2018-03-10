package show.products.javatask172.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import show.products.javatask172.model.Product;
import show.products.javatask172.model.Products;

@Controller
@RequestMapping("/")
public class FormController {
    private Products products;

    public FormController(Products products) {
        this.products = products;
    }

    // add product
    @RequestMapping("/addProduct")
    public String addProduct(@RequestParam String name, @RequestParam String price, @RequestParam String category) {
        products.addProduct(new Product(name, price, category));
        System.out.println("Product was added");
        return "redirect:/";
    }
}
