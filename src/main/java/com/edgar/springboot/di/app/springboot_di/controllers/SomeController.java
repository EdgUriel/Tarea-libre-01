package com.edgar.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.edgar.springboot.di.app.springboot_di.models.Product;
import com.edgar.springboot.di.app.springboot_di.services.ProductService;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api")
public class SomeController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable Long id, org.springframework.ui.Model model) { // Antes retornaba Product
        Product product = service.findById(id);
    
        model.addAttribute("product", product);
        return "product";
    }
}
