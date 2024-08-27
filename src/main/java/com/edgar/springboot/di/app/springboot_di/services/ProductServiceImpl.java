package com.edgar.springboot.di.app.springboot_di.services;

// import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.springboot.di.app.springboot_di.models.Product;
import com.edgar.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired // Inyección a ProductServiceImpl una instancia Singleton de ProductRepositoryImpl (Inyección mediante atributo/campo)
    private ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p-> {
            
            Double priceTax = p.getPrice() * 1.25d;
            // Product newProduct = new Product(p.getId(), p.getName(), priceTax.longValue());
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceTax.longValue());

            return newProduct;

        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {

        return repository.findById(id);
    }

    
}
