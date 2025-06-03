package com.devsuperior.produto_departamento.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsuperior.produto_departamento.entities.Product;
import com.devsuperior.produto_departamento.dto.ProductDTO;
import com.devsuperior.produto_departamento.repositories.ProductRepository;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = products.stream().map(ProductDTO::new).toList();
        return productDTOs;
    }
}
