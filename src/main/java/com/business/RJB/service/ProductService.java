package com.business.RJB.service;

import com.business.RJB.model.Products;
import com.business.RJB.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    IProductRepository productRepository;
    public void saveProduct(Products products){
        productRepository.save(products);
    }

    public List<Products> getAllProducts(){
        return productRepository.findAll();
    }
}
