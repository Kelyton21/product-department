package com.devsuperior.produto_departamento.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.produto_departamento.dto.ProductDTO;
import com.devsuperior.produto_departamento.dto.ProductUpdateDTO;
import com.devsuperior.produto_departamento.services.ProductService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value =  "/products")
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById (@PathVariable Long id) {
        var productDTO = productService.findById(id);
        if (productDTO.isPresent() == false) {
            return ResponseEntity.notFound().build();
            
        }
        return ResponseEntity.ok().body(productDTO.get());
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductDTO product){
        Long productSave = productService.createProduct(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productSave)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build(); // retorno um 204
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody ProductUpdateDTO product) {
         productService.uptadeProduct(id, product);
         return ResponseEntity.ok().build(); 
    }

}
