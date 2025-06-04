package com.devsuperior.produto_departamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.produto_departamento.dto.ProductDTO;
import com.devsuperior.produto_departamento.services.ProductService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value =  "/products")
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @PostMapping
    public Long createProduct(@RequestBody ProductDTO product){
        var productSave = productService.createProduct(product);
        return productSave.getId();
    }
}
