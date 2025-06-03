package com.devsuperior.produto_departamento.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.produto_departamento.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
