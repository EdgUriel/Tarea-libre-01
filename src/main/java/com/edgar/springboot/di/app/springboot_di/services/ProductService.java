package com.edgar.springboot.di.app.springboot_di.services;

import java.util.List;

import com.edgar.springboot.di.app.springboot_di.models.Product;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

} 