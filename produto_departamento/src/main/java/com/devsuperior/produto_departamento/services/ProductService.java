package com.devsuperior.produto_departamento.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.produto_departamento.entities.Department;
import com.devsuperior.produto_departamento.entities.Product;
import com.devsuperior.produto_departamento.dto.ProductDTO;
import com.devsuperior.produto_departamento.repositories.DepartmentRepository;
import com.devsuperior.produto_departamento.repositories.ProductRepository;

// Add this import if you have the exception in your project
import com.devsuperior.produto_departamento.exceptions.ResourceNotFoundException;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = products.stream().map(ProductDTO::new).toList();
        return productDTOs;
    }

    public Product createProduct(ProductDTO product){
        Department departmentR = departmentRepository.findByName(product.getDepartment())
        .orElseThrow(() -> new ResourceNotFoundException("Department not found: " + product.getDepartment()));
       
        var entity = new Product(null,product.getName(),product.getPrice(),departmentR);
        var productSave = productRepository.save(entity);
        return productSave;
    }
}
