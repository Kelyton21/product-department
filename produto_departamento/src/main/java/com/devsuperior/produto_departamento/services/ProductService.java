package com.devsuperior.produto_departamento.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.produto_departamento.entities.Department;
import com.devsuperior.produto_departamento.entities.Product;
import com.devsuperior.produto_departamento.dto.ProductDTO;
import com.devsuperior.produto_departamento.dto.ProductUpdateDTO;
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

    public void uptadeProduct(Long id, ProductUpdateDTO product){
        var productFind = productRepository.findById(id);
        if (productFind.isPresent()) {
            Product productEntity = productFind.get();
            if(product.getName() != null){
                productEntity.setName(product.getName());
            }
            if (product.getPrice() != null) {
                productEntity.setPrice(product.getPrice());
            }
            if (product.getDepartment() != null) {
                Department departmentR = departmentRepository.findByName(product.getDepartment().getName())
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found: " + product.getDepartment()));
                productEntity.setDepartment(departmentR);
            }
            productRepository.save(productEntity);
        } else {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }  
    }

    public void deleteProduct(Long id){
        var productFind = productRepository.existsById(id);
        if (!productFind) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}
