package com.devsuperior.produto_departamento.services;
import java.util.List;

import com.devsuperior.produto_departamento.dto.ProductCreateDTO;
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
import java.util.Optional;


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
    @Transactional
    public Long createProduct(ProductCreateDTO productDto) {
    var productExist = productRepository.findByName(productDto.getName());

    if (productExist.isEmpty()) {
        Department department = departmentRepository.findById(productDto.getIdDepartment()).orElse(null);

        Product entity = new Product(null, productDto.getName(), productDto.getPrice(), department);
        var productSave = productRepository.save(entity);
        return productSave.getId();
    } else {
        throw new ResourceNotFoundException("Product already exists with name: " + productDto.getName());
    }
    }
    @Transactional
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
    @Transactional
    public void deleteProduct(Long id){
        var productFind = productRepository.existsById(id);
        if (!productFind) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

    public Optional<ProductDTO> findById(Long id){
        var product = productRepository.findById(id);
        return product.map(ProductDTO::new);
    }

    public List<ProductDTO> findProductsByName(String titulo) {
        List<Product> products = productRepository.findByName(titulo);
        return products.stream().map(ProductDTO::new).toList();
    }
}
